package com.bsoft.attendance.timer;

import com.bsoft.attendance.manager.ProjectLogManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 13:28
 * @Description 结构化日志项目中项目经理环节待审是否和项目里的项目经理相同，不相同则替换
 */
@DisallowConcurrentExecution
@Component
public class DifferentProjectManagerReplaceTimer implements Job {
    @Autowired
    private ProjectLogManager projectLogManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        projectLogManager.replaceDifferentProjectManager();
    }
}
