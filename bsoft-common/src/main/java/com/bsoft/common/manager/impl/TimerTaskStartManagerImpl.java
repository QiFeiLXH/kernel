package com.bsoft.common.manager.impl;

import com.bsoft.common.manager.TimerTaskStartManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author zhanglf
 * @Date 2020-07-02 10:37
 * @Version 1.0
 * @Description
 */
@Component
public class TimerTaskStartManagerImpl implements TimerTaskStartManager {
    private final static Logger logger = LoggerFactory.getLogger(TimerTaskStartManagerImpl.class);
    private static final String DEFAULT_TIMER_KEY = "Timer:AllowServer";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public Boolean isAllowStart() {
        Boolean isHaveAllowServer = redisTemplate.hasKey(DEFAULT_TIMER_KEY);
        try {
            String localHost = InetAddress.getLocalHost().getHostAddress();
            logger.info("获取到本机IP为：{}",localHost );
            if(isHaveAllowServer){
                String server = redisTemplate.opsForValue().get(DEFAULT_TIMER_KEY);
                if(server.equals(localHost)){
                    return true;
                }else{
                    return false;
                }
            }else{
                redisTemplate.opsForValue().set(DEFAULT_TIMER_KEY,localHost);
                return true;
            }
        } catch (UnknownHostException e) {
            logger.error("获取IP失败，原因：{}",e.getMessage() );
        }

        return false;
    }
}
