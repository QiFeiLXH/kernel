package com.bsoft.logs.manager.impl;

import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.logs.dao.primary.LoginLogDao;
import com.bsoft.logs.entity.primary.LoginLogDO;
import com.bsoft.logs.manager.LoginLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginLogManagerImpl implements LoginLogManager {
    @Autowired
    private LoginLogDao loginLogDao;
    @Override
    public void save(LoginLogDO loginLogDO) {
        ValidateUtil.check(loginLogDO);
        loginLogDao.save(loginLogDO);
    }
}
