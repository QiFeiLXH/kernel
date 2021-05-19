package com.bsoft.user.manager;

public interface BinderManager {
    public void bindApp(String userId,String deviceId);
    public String getAppDevice(String userId);
    public Boolean isBindApp(String userId);
    public Boolean validateDevice(String userId,String deviceId);
    public Boolean isDeviceEmty(String userId);
}
