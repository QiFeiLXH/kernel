package com.bsoft.user.manager.impl;

import com.bsoft.user.manager.AppVeriManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xucl
 * @DateTime: 2020/7/23 14:18
 * @Description: App登录验证Manager实现类
 */
@Component
public class AppVeriManagerImpl implements AppVeriManager {
    private static final String DEFAULT_APP_VERI = "AppVeri";
    private static final String DEFAULT_APP_VERI_CODE = "AppVeriCode";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public void setVeriInfo(String uuid, String mapString, long timeout, TimeUnit unit) {
        set(uuid,mapString,timeout,unit);
    }

    @Override
    public void removeVeriInfo(String uuid) {
        delete(uuid);
    }

    @Override
    public Boolean hasVeriInfo(String uuid) {
        return hasKey(uuid);
    }

    @Override
    public String getVeriInfo(String uuid) {
        return get(uuid);
    }

    @Override
    public void setVerifyCode(String uuid, String code, long timeout, TimeUnit unit) {
        setCode(uuid,code,timeout,unit);
    }

    @Override
    public String getVerifyCode(String uuid) {
        if (hasCodeKey(uuid)){
            return getCode(uuid);
        }else{
            return null;
        }
    }

    private void set(String key, String mapString, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(getKey(key),mapString,timeout,unit);
    }

    private void setCode(String key, String code, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(getCodeKey(key),code,timeout,unit);
    }

    private String get(String key){
        return redisTemplate.opsForValue().get(getKey(key));
    }

    private String getCode(String key){
        return redisTemplate.opsForValue().get(getCodeKey(key));
    }

    private void delete(String key){
        redisTemplate.delete(getKey(key));
    }

    private void deleteCode(String key){
        redisTemplate.delete(getCodeKey(key));
    }

    private Boolean hasKey(String key){
        return redisTemplate.hasKey(getKey(key));
    }

    private Boolean hasCodeKey(String key){
        return redisTemplate.hasKey(getCodeKey(key));
    }

    private String getKey(String key){
        return new StringBuilder(DEFAULT_APP_VERI).append(":").append(key).toString();
    }

    private String getCodeKey(String key){
        return new StringBuilder(DEFAULT_APP_VERI_CODE).append(":").append(key).toString();
    }
}
