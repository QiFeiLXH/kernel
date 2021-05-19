package com.bsoft.person.timer;

import com.bsoft.person.manager.CloudschoolRestypeManager;
import com.bsoft.person.manager.CloudschoolSynManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 云学堂同步用户定时任务
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class CloudschoolRestypeOneSyncJob implements Job {

    @Autowired
    private CloudschoolRestypeManager cloudschoolRestypeManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        //将岗位备份表中所有数据同步到云学堂同步岗位
        cloudschoolRestypeManager.SyncOneRestype();
    }
}
