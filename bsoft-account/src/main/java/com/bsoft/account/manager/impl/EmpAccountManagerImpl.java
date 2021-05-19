package com.bsoft.account.manager.impl;

import com.bsoft.account.dao.primary.EmpAccountDao;
import com.bsoft.account.entity.primary.EmpAccountDO;
import com.bsoft.account.manager.EmpAccountManager;
import com.bsoft.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @Author zhanglf
 * @Date 2020-05-14 10:02
 * @Version 1.0
 * @Description
 */
@Component
public class EmpAccountManagerImpl implements EmpAccountManager {
    @Autowired
    private EmpAccountDao empAccountDao;

    //冻结账户 冻结标志置为1   冻结次数自动加1
    @Override
    public void frozenAccount(String userId) {
        Optional<EmpAccountDO> empAccountOp = empAccountDao.findById(userId);
        empAccountOp.orElseThrow(()->new ServiceException("无该账号"));
        EmpAccountDO empAccount = empAccountOp.get();
        empAccount.setAccountInfo(1);
        empAccount.setFrozenNums(empAccount.getFrozenNums()+1);
        empAccountDao.save(empAccount);
    }

    //解冻账户 冻结标志置为0  冻结次数置为0
    @Override
    public void thawAccount(String userId) {
        Optional<EmpAccountDO> empAccountOp = empAccountDao.findById(userId);
        empAccountOp.orElseThrow(()->new ServiceException("无该账号"));
        EmpAccountDO empAccount = empAccountOp.get();
        empAccount.setAccountInfo(0);
        empAccount.setFrozenNums(0);
        empAccountDao.save(empAccount);
    }

    @Override
    public void saveEmpAccount(List<EmpAccountDO> empAccountDOS) {
        empAccountDao.saveAll(empAccountDOS);
    }
}
