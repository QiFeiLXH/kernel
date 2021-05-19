package com.bsoft.cost.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.cost.dao.primary.AccountCaliberDao;
import com.bsoft.cost.dao.primary.AccountCaliberViewDao;
import com.bsoft.cost.entity.primary.AccountCaliberDO;
import com.bsoft.cost.entity.primary.AccountCaliberViewDO;
import com.bsoft.cost.manager.AccountCaliberManager;
import com.bsoft.cost.repository.primary.AccountCaliberRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 9:57
 * @Description
 */
@Service
public class AccountCaliberManagerImpl implements AccountCaliberManager {
    @Autowired
    private AccountCaliberDao accountCaliberDao;
    @Autowired
    private AccountCaliberViewDao accountCaliberViewDao;
    @Autowired
    private AccountCaliberRepository accountCaliberRepository;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
        public PageInfo<AccountCaliberViewDO> getDpetAccountCaliberList(Integer pageNo, Integer pageSize, Integer year, Integer accountCaliber, String deptId, Integer deptType) {
        PageHelper.startPage(pageNo, pageSize);
        List<AccountCaliberViewDO> list = accountCaliberRepository.getAccountCaliberListByYear(year, deptId,deptType, accountCaliber);
        PageInfo<AccountCaliberViewDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    @Transactional
    public void saveYearlyDeptAccountCaliber(Integer year) {
        Date serverDate = serverDateManager.getServerDate();
        List<AccountCaliberDO> list = new ArrayList<>();
        // 获取上一年度所有有效部门核算口径
        List<AccountCaliberDO> lastCaliberDOS = accountCaliberRepository.getValidDeptAccountCaliberListByYear(year-1);
        Map<String, List<Integer>> lastCaliberMap = lastCaliberDOS.stream().collect(Collectors.groupingBy(AccountCaliberDO::getDeptId, Collectors.mapping(AccountCaliberDO::getAccountCaliber, Collectors.toList())));


        // 获取当年所有部门核算口径
        List<AccountCaliberDO> currentCaliberDOS = accountCaliberDao.findAllByYear(year);
        Map<String, List<Integer>> currentCaliberMap = currentCaliberDOS.stream().collect(Collectors.groupingBy(AccountCaliberDO::getDeptId, Collectors.mapping(AccountCaliberDO::getAccountCaliber, Collectors.toList())));

        lastCaliberMap.forEach((lastDeptId, lastCalibers) -> {
            if (!currentCaliberMap.containsKey(lastDeptId)) {
                if (!lastCalibers.isEmpty()){
                    lastCalibers.forEach(lastCaliber -> {
                        AccountCaliberDO accountCaliberDO = new AccountCaliberDO();
                        accountCaliberDO.setDeptId(lastDeptId);
                        accountCaliberDO.setAccountCaliber(lastCaliber);
                        accountCaliberDO.setYear(year);
                        accountCaliberDO.setRegistrationDate(serverDate);
                        list.add(accountCaliberDO);
                    });
                }
            } else {
                List<Integer> currentCalibers = currentCaliberMap.get(lastDeptId);
                lastCalibers.forEach(lastCaliber -> {
                    if(!currentCalibers.isEmpty()) {
                        if (!currentCalibers.contains(lastCaliber)) {
                            AccountCaliberDO accountCaliberDO = new AccountCaliberDO();
                            accountCaliberDO.setDeptId(lastDeptId);
                            accountCaliberDO.setAccountCaliber(lastCaliber);
                            accountCaliberDO.setYear(year);
                            accountCaliberDO.setRegistrationDate(serverDate);
                            list.add(accountCaliberDO);
                        }
                    }
                });
            }
        });
        accountCaliberDao.saveAll(list);
    }

    @Override
    @Transactional
    public void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year) {
        List<AccountCaliberDO> list = new ArrayList<>();
        Date serverDate = serverDateManager.getServerDate();
        // 删除待删除的部门核算口径
        if (!caliberDeletes.isEmpty()) {
            accountCaliberDao.deleteAllByDeptIdAndYearAndAccountCaliberIn(deptId,year,caliberDeletes);
        }
        // 保存待保存的部门核算口径
        if (!caliberSaves.isEmpty()) {
            caliberSaves.forEach(caliberId -> {
                AccountCaliberDO accountCaliberDO = new AccountCaliberDO();
                accountCaliberDO.setRegistrationDate(serverDate);
                accountCaliberDO.setYear(year);
                accountCaliberDO.setDeptId(deptId);
                accountCaliberDO.setAccountCaliber(caliberId);
                list.add(accountCaliberDO);
            });
            accountCaliberDao.saveAll(list);
        }
    }

    @Override
    public List<AccountCaliberViewDO> findByDeptIdAndYear(String deptId, Integer year) {
        List<AccountCaliberViewDO> list = accountCaliberViewDao.findAccountCaliberList(deptId,year);
        return list;
    }

    @Override
    public void saveAccountCaliber(List<AccountCaliberDO> accountCaliberDOS) {
        accountCaliberDao.saveAll(accountCaliberDOS);
    }

    @Override
    public void deleteAccountCaliber(Integer year, List<String> deptIds) {
        accountCaliberDao.deleteAllByYearAndDeptIdIn(year,deptIds);
    }

    @Override
    public List<AccountCaliberDO> findAllByYear(Integer year) {
        return accountCaliberDao.findAllByYear(year);
    }

    @Override
    public List<AccountCaliberDO> getLastYear(Integer year) {
        return accountCaliberDao.findLastYear(year);
    }
}
