package com.bsoft.hr.timer;

import com.bsoft.hr.manager.PersonFinancialTypeEmailManager;
import com.bsoft.hr.manager.PersonSickLeaveEmailManager;
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
@DisallowConcurrentExecution //部门人员财务类别维护邮件提醒功能
@Component
public class PersonSickLeaveEmailJob implements Job{
    @Autowired
    private PersonSickLeaveEmailManager personSickLeaveEmailManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        personSickLeaveEmailManager.PersonSickLeaveEmail();
    }
}
