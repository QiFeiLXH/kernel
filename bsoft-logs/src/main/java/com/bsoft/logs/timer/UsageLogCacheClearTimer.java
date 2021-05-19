package com.bsoft.logs.timer;

import com.bsoft.logs.manager.UsageLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsageLogCacheClearTimer implements  Runnable{
    @Autowired
    private UsageLogManager usageLogManager;
    @Override
    public void run() {
        usageLogManager.clearCache();
    }
}
