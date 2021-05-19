package com.bsoft.logs.timer;

import com.bsoft.logs.manager.RequestLogManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/10/28
 * @description
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class RequestLogCountJob implements Job {
    @Autowired
    private RequestLogManager requestLogManager;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        requestLogManager.saveCount();
    }
}
