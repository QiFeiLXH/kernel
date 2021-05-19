package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.ServerDateDao;
import com.bsoft.common.manager.ServerDateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Component
public class ServerDateManagerImpl implements ServerDateManager {
    @Autowired
    private ServerDateDao serverDateDao;
    @Override
    public Date getServerDate() {
        return serverDateDao.getServerDate();
    }

    @Override
    public java.util.Date getServerDateTime() {
        Timestamp t = serverDateDao.getServerDateTime();
        return new java.util.Date(t.getTime());
    }
}
