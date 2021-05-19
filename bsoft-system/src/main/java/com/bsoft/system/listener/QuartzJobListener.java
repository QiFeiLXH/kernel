package com.bsoft.system.listener;

import com.bsoft.email.util.LocalThreadScopeDataUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class QuartzJobListener implements JobListener {

    @Autowired
    private Scheduler scheduler;

    @Override
    public String getName() {
        return "myJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        LocalThreadScopeDataUtil data = LocalThreadScopeDataUtil.getInstance();
        data.setJobDataMap(jobDataMap);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
            //定时任务监控结束后将当前对象赋值为空
            LocalThreadScopeDataUtil data = LocalThreadScopeDataUtil.getInstance();
            data=null;
    }
}
