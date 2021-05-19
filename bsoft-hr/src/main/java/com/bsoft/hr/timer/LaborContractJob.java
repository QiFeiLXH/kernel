package com.bsoft.hr.timer;

import com.bsoft.hr.entity.primary.PersonLaborContractViewDO;
import com.bsoft.hr.manager.LaborContractRenewalManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @author: zy
 * @date: 2020/12/10
 * @description 劳动合同自动续签定时任务
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class LaborContractJob implements Job {
    @Autowired
    private LaborContractRenewalManager laborContractRenewalManager;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<PersonLaborContractViewDO> personList = laborContractRenewalManager.getRenewalPersonList();
        if(personList !=null && personList.size() > 0) {
            laborContractRenewalManager.startAndCompleteProcess(personList);
        }
    }
}
