package com.bsoft.project.timer;

import com.bsoft.project.manager.ProjectManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 14:37
 * @Description
 */
@DisallowConcurrentExecution
@Component
public class ProProjectExpandSyncTimer implements Job {
    @Autowired
    private ProjectManager projectManager;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        projectManager.syncProProjectExpand();
    }
}
