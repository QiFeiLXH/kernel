package com.bsoft.user.manager;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xucl
 * @DateTime: 2020/7/23 14:17
 * @Description: App登录验证
 */
public interface AppVeriManager {
    public void setVeriInfo(String uuid, String mapString, long timeout, TimeUnit unit);

    public void removeVeriInfo(String uuid);

    public Boolean hasVeriInfo(String uuid);

    public String getVeriInfo(String uuid);

    void setVerifyCode(String uuid,String code, long timeout, TimeUnit unit);

    String getVerifyCode(String uuid);
}
