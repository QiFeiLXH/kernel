package com.bsoft.user.manager.impl;

import com.bsoft.user.manager.OfficeVeriManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Component
public class OfficeVeriManagerImpl implements OfficeVeriManager {
    private static final String DEFAULT_OFFICE_VERI = "OfficeVeri";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void setVeriInfo(String Ip, String mapString, long timeout, TimeUnit unit) {
        set(Ip,mapString,timeout,unit);
    }

    @Override
    public void removeVeriInfo(String Ip) {
        delete(Ip);
    }

    @Override
    public Boolean hasVeriInfo(String Ip) {
        return hasKey(Ip);
    }

    @Override
    public String getVeriInfo(String Ip) {
        return get(Ip);
    }

    private void set(String key, String mapString, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(getKey(key),mapString,timeout,unit);
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
        return new StringBuilder(DEFAULT_OFFICE_VERI).append(":").append(key).toString();
    }
}
