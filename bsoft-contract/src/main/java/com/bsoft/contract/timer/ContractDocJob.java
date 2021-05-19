package com.bsoft.contract.timer;

import com.bsoft.contract.manager.ContractDocManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/12/9 9:54
 * @Description: 合同资料缺失定时提醒
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class ContractDocJob implements Job {
    @Autowired
    ContractDocManager contractDocManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        contractDocManager.sendContractOriginalEmail();
        contractDocManager.sendBidWinningNoticeEmail();
        contractDocManager.sendContractNotMaintainEmail();
    }
}
