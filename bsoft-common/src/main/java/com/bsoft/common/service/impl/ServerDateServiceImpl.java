package com.bsoft.common.service.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.service.ServerDateService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
@Service
public class ServerDateServiceImpl implements ServerDateService {
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public Date getServerDate() {
        return serverDateManager.getServerDate();
    }

    @Override
    public java.util.Date getServerDateTime() {
        return serverDateManager.getServerDateTime();
    }
}
