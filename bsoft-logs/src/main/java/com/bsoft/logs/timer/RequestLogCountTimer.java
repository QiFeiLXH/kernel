package com.bsoft.logs.timer;

import com.bsoft.logs.manager.RequestLogManager;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/10/29
 * @description
 */
@Component
public class RequestLogCountTimer implements Runnable{
    @Autowired
    private RequestLogManager requestLogManager;

    @Override
    public void run() {
        requestLogManager.saveCount();
    }

}
