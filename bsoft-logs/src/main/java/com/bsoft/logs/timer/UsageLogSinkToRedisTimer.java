package com.bsoft.logs.timer;

import com.bsoft.logs.manager.UsageLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsageLogSinkToRedisTimer implements  Runnable {
    @Autowired
    private UsageLogManager usageLogManager;
    @Override
    public void run() {
        usageLogManager.sinkToRedis();
    }
}
