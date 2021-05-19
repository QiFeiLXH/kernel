package com.bsoft.user.manager;

import java.util.concurrent.TimeUnit;

public interface AppTokenManger {
    public void setToken(String userId,String token);

    public void setToken(String userId,String token,long timeout,TimeUnit unit);

    public void removeToken(String userId);

    public Boolean hasToken(String userId);

    public String getToken(String userId);

    public void expireToken(String userId, long timeout, TimeUnit unit);
}
