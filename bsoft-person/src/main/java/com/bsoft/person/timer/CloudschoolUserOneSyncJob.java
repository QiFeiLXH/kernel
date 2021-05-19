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
public class CloudschoolUserOneSyncJob implements Job {
    @Autowired
    private CloudschoolSynManager cloudschoolSynManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        //同步用户
        cloudschoolSynManager.SyncOnePersonnel();
    }
}
