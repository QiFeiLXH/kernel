package com.bsoft.contract.timer;

import com.bsoft.contract.manager.ContractProductManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 18:54
 * @Description
 */
@DisallowConcurrentExecution
@Component
public class ContractProductSyncTimer implements Job {
    @Autowired
    private ContractProductManager contractProductManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        contractProductManager.syncContractProduct();
    }
}
