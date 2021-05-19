package com.bsoft.cost.manager.impl;

import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.cost.dao.primary.DeptCostTypeDao;
import com.bsoft.cost.entity.primary.AccountCaliberDO;
import com.bsoft.cost.entity.primary.CostTypeDeptViewDO;
import com.bsoft.cost.entity.primary.DeptCostTypeDO;
import com.bsoft.cost.entity.primary.DeptCostTypeViewDO;
import com.bsoft.cost.manager.AccountCaliberManager;
import com.bsoft.cost.manager.DeptCostTypeManager;
import com.bsoft.cost.repository.primary.DeptCostTypeRepository;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 9:08
 * @Description:
 */
@Component
public class DeptCostTypeManagerImpl implements DeptCostTypeManager {
    @Autowired
    private DeptCostTypeRepository deptCostTypeRepository;
    @Autowired
    private DeptCostTypeDao deptCostTypeDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private AccountCaliberManager accountCaliberManager;

    @Override
    public List<CostTypeDeptViewDO> findDeptList(Integer year,Integer flag, Integer bmlb, Integer zxbz,String deptId) {
        return deptCostTypeRepository.findDeptList(year,flag,bmlb,zxbz,deptId);
    }

    @Override
    public List<CostTypeDeptViewDO> findDeptListByDept(Integer year,Integer flag, Integer bmlb, Integer zxbz,String parentBm) {
        return deptCostTypeRepository.findDeptListByDeptId(year,flag,bmlb,zxbz,parentBm);
    }

    @Override
    public DeptCostTypeViewDO getDeptCostType(Integer year, String deptNo) {
        DeptCostTypeViewDO viewDO = deptCostTypeRepository.getDeptCostType(year,deptNo);
        return viewDO;
    }

    @Override
    @Transactional
    public void saveCostType(DeptCostTypeViewDO viewDO) {
        Integer year = viewDO.getYear();
        String dept = viewDO.getDept();
        String parentDept = viewDO.getParentDept().equals(viewDO.getDept()) ? null:viewDO.getParentDept();//一级部门
        List<String> allDepts = getAllDept(parentDept,dept);
        //删除所有已存的部门费用类别信息
        deptCostTypeDao.deleteAllByYearAndDeptIn(year,allDepts);
        //获取需要保存的信息
        List<DeptCostTypeDO> dos = getDeptCostTypes(viewDO,allDepts);
        deptCostTypeDao.saveAll(dos);//保存部门费用类别信息
        Date now = serverDateManager.getServerDate();

        //保存部门核算口归属
        accountCaliberManager.deleteAccountCaliber(year,allDepts);
        String accountcalibers = viewDO.getAccountcalibers();
        if (StringUtils.isNotBlank(accountcalibers)){
            String[] accounts = accountcalibers.split(",");
            List<AccountCaliberDO> list = getAllAccountcalibers(year,allDepts,accounts,now);
            saveAccountcalibers(list);
        }
    }

    private void saveAccountcalibers(List<AccountCaliberDO> list){
        accountCaliberManager.saveAccountCaliber(list);
    }

    private List<AccountCaliberDO> getAllAccountcalibers(Integer year,List<String> deptIds,String[] accounts,Date now){
        List<AccountCaliberDO> list = new ArrayList<>();
        for (String deptId:deptIds){
            List<AccountCaliberDO> detail = getAccountcalibers(year,deptId,accounts,now);
            list.addAll(detail);
        }
        return list;
    }

    private List<AccountCaliberDO> getAccountcalibers(Integer year,String deptId,String[] accounts,Date now){
        List<AccountCaliberDO> list = new ArrayList<>();
        for (String s:accounts){
            AccountCaliberDO caliberDO = new AccountCaliberDO();
            caliberDO.setId(keyGenerator.increaseDeptAccountbore());
            caliberDO.setDeptId(deptId);
            caliberDO.setYear(year);
            caliberDO.setAccountCaliber(Integer.valueOf(s));
            caliberDO.setRegistrationDate(now);
            list.add(caliberDO);
        }
        return list;
    }

    @Override
    public boolean checkAnnualGener(Integer year) {
        List<DeptCostTypeDO> list = deptCostTypeDao.findAllByYear(year);//年度部门费用信息
        List<AccountCaliberDO> accountCaliberDOS = accountCaliberManager.findAllByYear(year);//年度核算口径归属信息
        if (list.isEmpty() && accountCaliberDOS.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void annualGener(Integer year,String personId) {
        if(checkAnnualGener(year)){
            List<DeptCostTypeDO> list = getLastYear(year - 1);//上年度部门费用类别
            if (!list.isEmpty()){
                List<DeptCostTypeDO> saveData = getNeedSave(list,personId,year);
                deptCostTypeDao.saveAll(saveData);
            }
            List<AccountCaliberDO> accountCaliberDOS = accountCaliberManager.getLastYear(year - 1);//上年度部门核算口径归属
            if (!accountCaliberDOS.isEmpty()){
                List<AccountCaliberDO> list1 = getYearAccounts(accountCaliberDOS,year);
                accountCaliberManager.saveAccountCaliber(list1);
            }
        }else{
            throw new ServiceException("该年度已生成数据，无法重复生成!");
        }
    }

    private List<AccountCaliberDO> getYearAccounts(List<AccountCaliberDO> lastYearData,Integer year){
        List<AccountCaliberDO> list = new ArrayList<>();
        Date now = serverDateManager.getServerDate();
        for (AccountCaliberDO accountCaliberDO:lastYearData){
            AccountCaliberDO caliberDO = new AccountCaliberDO();
            caliberDO.setId(keyGenerator.increaseDeptAccountbore());
            caliberDO.setDeptId(accountCaliberDO.getDeptId());
            caliberDO.setYear(year);
            caliberDO.setAccountCaliber(accountCaliberDO.getAccountCaliber());
            caliberDO.setRegistrationDate(now);
            list.add(caliberDO);
        }
        return list;
    }

    private List<DeptCostTypeDO> getNeedSave(List<DeptCostTypeDO> lastYearData,String personId,Integer year){
        List<DeptCostTypeDO> newData = new ArrayList<>();
        Date now = serverDateManager.getServerDate();
        for (DeptCostTypeDO typeDO:lastYearData){
            DeptCostTypeDO costTypeDO = new DeptCostTypeDO();
            costTypeDO.setId(keyGenerator.increaseDeptCostType());
            costTypeDO.setYear(year);
            costTypeDO.setDept(typeDO.getDept());
            costTypeDO.setRegistrant(personId);
            costTypeDO.setRegistrantDate(now);
            costTypeDO.setCostType(typeDO.getCostType());
            costTypeDO.setFlag(typeDO.getFlag());
            newData.add(costTypeDO);
        }
        return newData;
    }

    private List<DeptCostTypeDO> getLastYear(Integer year){
        return deptCostTypeDao.findLastList(year);
    }

    private List<String> getAllDept(String parentDept,String dept){
        List<String> allDepts = new ArrayList<>();
        allDepts.add(dept);
        if (StringUtils.isBlank(parentDept)){//一级部门
            List<DeptDO> list = deptManager.getChildDeptList(dept,0);
            for (DeptDO deptDO:list){
                allDepts.add(deptDO.getDeptId());
            }
        }
        return allDepts;
    }

    private List<DeptCostTypeDO> getDeptCostTypes(DeptCostTypeViewDO viewDO,List<String> depts){
        Date now = serverDateManager.getServerDate();
        String costTypes = viewDO.getCostTypes();
        List<String> costTypeList = Arrays.asList(costTypes.split(","));
        Integer costType = viewDO.getCostType();
        Integer year = viewDO.getYear();
        String personId = viewDO.getRegistrant();
        List<DeptCostTypeDO> dos = new ArrayList<>();
        for (String dept:depts){
            List<DeptCostTypeDO> dosDetail = getDeptCostType(year,personId,dept,now,costTypeList,costType);
            dos.addAll(dosDetail);
        }
        return dos;
    }

    private List<DeptCostTypeDO> getDeptCostType(Integer year,String personId,String dept,Date now,List<String> costTypeList,Integer costType){
        List<DeptCostTypeDO> dos = new ArrayList<>();
        for (String cost:costTypeList){
            DeptCostTypeDO typeDO = new DeptCostTypeDO();
            Integer id = keyGenerator.increaseDeptCostType();
            typeDO.setId(id);
            typeDO.setYear(year);
            typeDO.setDept(dept);
            typeDO.setRegistrant(personId);
            typeDO.setRegistrantDate(now);
            typeDO.setCostType(Integer.valueOf(cost));
            if (cost.equals(costType.toString())){
                typeDO.setFlag(1);
            }else{
                typeDO.setFlag(0);
            }
            dos.add(typeDO);
        }
        return dos;
    }
}
