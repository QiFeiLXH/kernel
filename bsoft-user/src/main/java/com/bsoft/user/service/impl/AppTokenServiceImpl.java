package com.bsoft.user.service.impl;

import com.bsoft.user.manager.AppTokenManger;
import com.bsoft.user.service.AppTokenService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

@Service
public class AppTokenServiceImpl implements AppTokenService {
    @Autowired
    private AppTokenManger appTokenManger;
    @Override
    public void setToken(String userId, String token) {
        appTokenManger.setToken(userId,token);
    }

    @Override
    public void setToken(String userId, String token, long timeout, TimeUnit unit) {
        appTokenManger.setToken(userId,token,timeout,unit);
    }

    @Override
    public String getToken(String userId) {
        return appTokenManger.getToken(userId);
    }

    @Override
    public void removeToken(String userId) {
        appTokenManger.removeToken(userId);
    }

    @Override
    public Boolean hasToken(String userId) {
        return appTokenManger.hasToken(userId);
    }

    @Override
    public void expireToken(String userId, long timeout, TimeUnit unit) {
        appTokenManger.expireToken(userId,timeout,unit);
    }
}
