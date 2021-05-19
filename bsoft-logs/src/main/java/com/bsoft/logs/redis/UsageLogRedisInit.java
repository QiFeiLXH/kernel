package com.bsoft.logs.redis;

import com.bsoft.logs.manager.UsageLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class UsageLogRedisInit implements ApplicationRunner {
    @Autowired
    private UsageLogManager usageLogManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //项目启动时读取redis缓存至项目
//        usageLogManager.initRedisCache();
    }

    @PreDestroy
    public void destory() throws Exception {
        //项目关闭时 将最新的访问情况数据输出至redis
        usageLogManager.sinkToRedisWithClose();
    }
}
