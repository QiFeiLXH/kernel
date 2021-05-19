package com.bsoft.dept.timer;

import com.bsoft.dept.manager.CloudschoolDeptSyncManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生日邮件定时器类
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class CloudschoolDeptSyncJob implements Job {
    @Autowired
    private CloudschoolDeptSyncManager cloudschoolDeptSyncManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        cloudschoolDeptSyncManager.SyncSaveDept();
        cloudschoolDeptSyncManager.SyncDeleteDept();
    }
}
