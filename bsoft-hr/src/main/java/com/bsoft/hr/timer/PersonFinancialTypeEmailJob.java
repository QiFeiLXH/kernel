package com.bsoft.hr.timer;

import com.bsoft.hr.manager.PersonFinancialTypeEmailManager;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-12-15 13:43
 * @Version 1.0
 */
@DisallowConcurrentExecution //部门人员财务类别维护邮件提醒功能
@Component
public class PersonFinancialTypeEmailJob implements Job{
    @Autowired
    private PersonFinancialTypeEmailManager personFinancialTypeEmailManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        personFinancialTypeEmailManager.sendRemindEmailToDeptFinancial();
    }
}
