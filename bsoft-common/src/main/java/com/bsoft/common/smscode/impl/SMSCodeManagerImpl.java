package com.bsoft.common.smscode.impl;

import com.bsoft.common.smscode.SMSCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SMSCodeManagerImpl implements SMSCodeManager {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void setToken(String type,String mobileno, String token) {
        set(type,mobileno,token);
    }

    @Override
    public void setToken(String type,String mobileno, String token, long timeout, TimeUnit unit) {
        set(type,mobileno,token,timeout,unit);
    }

    @Override
    public void removeToken(String type,String mobileno) {
        delete(type,mobileno);
    }

    @Override
    public Boolean hasToken(String type,String mobileno) {
        return hasKey(type,mobileno);
    }

    @Override
    public String getToken(String type,String mobileno) {
        return get(type,mobileno);
    }

    @Override
    public void expireToken(String type,String mobileno, long timeout, TimeUnit unit) {
        redisTemplate.expire(new StringBuilder(type).append(":").append(mobileno).toString(),timeout,unit);
    }

    private void set(String type,String key,String value){
        redisTemplate.opsForValue().set(getKey(type,key),value);
    }

    private void set(String type,String key, String value, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(getKey(type,key),value,timeout,unit);
    }

    private String get(String type,String key){
        return redisTemplate.opsForValue().get(getKey(type,key));
    }

    private void delete(String type,String key){
        redisTemplate.delete(getKey(type,key));
    }

    private Boolean hasKey(String type,String key){
        return redisTemplate.hasKey(getKey(type,key));
    }

    private String getKey(String type,String key){
        return new StringBuilder(type).append(":").append(key).toString();
    }
}
