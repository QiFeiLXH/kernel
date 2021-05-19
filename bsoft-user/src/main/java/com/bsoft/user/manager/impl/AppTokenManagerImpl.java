package com.bsoft.user.manager.impl;

import com.bsoft.user.manager.AppTokenManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Component
public class AppTokenManagerImpl implements AppTokenManger {
    private static final String DEFAULT_APP_TOKEN = "AppToken";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void setToken(String userId, String token) {
        set(userId,token);
    }

    @Override
    public void setToken(String userId, String token, long timeout, TimeUnit unit) {
        set(userId,token,timeout,unit);
    }

    @Override
    public void removeToken(String userId) {
        delete(userId);
    }

    @Override
    public Boolean hasToken(String userId) {
        return hasKey(userId);
    }

    @Override
    public String getToken(String userId) {
        return get(userId);
    }

    @Override
    public void expireToken(String userId, long timeout, TimeUnit unit) {
        redisTemplate.expire(userId,timeout,unit);
    }

    private void set(String key,String value){
        redisTemplate.opsForValue().set(getKey(key),value);
    }

    private void set(String key, String value, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(getKey(key),value,timeout,unit);
    }

    private String get(String key){
        return redisTemplate.opsForValue().get(getKey(key));
    }

    private void delete(String key){
        redisTemplate.delete(getKey(key));
    }

    private Boolean hasKey(String key){
        return redisTemplate.hasKey(getKey(key));
    }

    private String getKey(String key){
        return new StringBuilder(DEFAULT_APP_TOKEN).append(":").append(key).toString();
    }
}
