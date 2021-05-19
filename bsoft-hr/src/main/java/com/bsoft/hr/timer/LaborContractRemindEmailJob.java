package com.bsoft.hr.timer;

import com.bsoft.hr.manager.LaborContractRenewalManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-12-15 13:43
 * @Version 1.0
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class LaborContractRemindEmailJob implements Job{
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        laborContractRenewalManager.sendRemindEmailToDept();
        laborContractRenewalManager.sendRemindEmailToDealPerson();
    }
}
