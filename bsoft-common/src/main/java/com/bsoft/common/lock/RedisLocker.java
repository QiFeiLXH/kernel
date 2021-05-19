package com.bsoft.common.lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RedisLocker {
    private static final Logger logger = LoggerFactory.getLogger(RedisLocker.class);
    private static final Long RELEASE_SUCCESS = 1L;
    private static final int DEFAULT_EXPIRETIME = 120;
    private static final String DEFAULT_LOCKKEY = "Locker";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void lock(String lockKey,String requestId){
        lock(lockKey,requestId,DEFAULT_EXPIRETIME);
    }

    public void lock(String lockKey,String requestId,int expireTime){
        lockKey = DEFAULT_LOCKKEY + ":" + lockKey;
        while(true){
            if(tryLock(lockKey,requestId,expireTime)){
                logger.info("lockKey:" + lockKey + "和requestId:" + requestId + "加锁成功");
                return;
            }
        }
    }

    public Boolean releaseLock(String lockKey, String requestId){
        lockKey = DEFAULT_LOCKKEY + ":" + lockKey;
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(script);
        redisScript.setResultType(Long.class);
        List<String> keys = new ArrayList<>();
        keys.add(lockKey);
        Long result = (Long) redisTemplate.execute(redisScript,  keys,requestId);
        if(RELEASE_SUCCESS.equals(result)){
            logger.info("lockKey:" + lockKey + "和requestId:" + requestId + "释放锁成功");
            return true;
        }
        return false;
    }

    public String getRequestId(){
        return UUID.randomUUID().toString();
    }

    private Boolean tryLock(String lockKey,String requestId,int expireTime){
        return redisTemplate.opsForValue().setIfAbsent(lockKey,requestId, Duration.ofSeconds(expireTime));
    }

}
