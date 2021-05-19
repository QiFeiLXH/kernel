package com.bsoft.common.smscode;

import java.util.concurrent.TimeUnit;

/**
 * sms验证码
 */
public interface SMSCodeManager {

    public void setToken(String type,String mobileno,String smsCode);

    public void setToken(String type,String mobileno, String smsCode, long timeout, TimeUnit unit);

    public void removeToken(String type,String mobileno);

    public Boolean hasToken(String type,String mobileno);

    public String getToken(String type,String mobileno);

    public void expireToken(String type,String mobileno, long timeout, TimeUnit unit);

}
