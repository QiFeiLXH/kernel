package com.bsoft.account.manager.impl;

import com.bsoft.account.dao.primary.AccountFrozenInfoDao;
import com.bsoft.account.entity.primary.AccountFrozenInfoDO;
import com.bsoft.account.manager.AccountFrozenInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-24 14:58
 * @Version 1.0
 * @Description
 */
@Component
public class AccountFrozenInfoManagerImpl implements AccountFrozenInfoManager {
    @Autowired
    private AccountFrozenInfoDao accountFrozenInfoDao;

    @Override
    public void saveAccountFrozenInfos(List<AccountFrozenInfoDO> accountFrozenInfoDOList) {
        accountFrozenInfoDao.saveAll(accountFrozenInfoDOList);
    }
}
