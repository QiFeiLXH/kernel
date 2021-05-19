package com.bsoft.cost.timer;

import com.bsoft.cost.manager.BillingInfoManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:19
 * @Description: 查询获取开票信息
 */
@DisallowConcurrentExecution
@Component
public class AutoInvoiceJob implements Job {
    @Autowired
    private BillingInfoManager billingInfoManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        billingInfoManager.saveBillingInvoice();
    }
}
