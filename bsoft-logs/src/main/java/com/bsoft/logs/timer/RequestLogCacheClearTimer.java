package com.bsoft.logs.timer;

import com.bsoft.logs.manager.RequestLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Component
public class RequestLogCacheClearTimer implements Runnable{
    @Autowired
    private RequestLogManager requestLogManager;
    @Override
    public void run() {
        requestLogManager.clearCache();
    }
}
