package com.bsoft.person.timer;

import com.bsoft.person.manager.BirthDayManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生日邮件定时器类
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class BirthEmailJob implements Job {
    @Autowired
    private BirthDayManager birthDayManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        birthDayManager.sendBirthEmail();
    }
}
