package com.bsoft.logs.manager;

import com.bsoft.logs.entity.primary.LoginLogDO;

public interface LoginLogManager {
    public void save(LoginLogDO loginLogDO);
}
