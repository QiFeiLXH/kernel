package com.bsoft.logs.timer;

import com.bsoft.logs.manager.UsageLogManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution //作业不并发
@Component
public class UsageLogCountJob implements Job {
    @Autowired
    private UsageLogManager usageLogManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        usageLogManager.saveCount();
    }
}
