package com.bsoft.project.timer;

import com.bsoft.project.manager.ProjectStartDateManager;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProjectStartDateTimer implements Job {
    @Autowired
    private ProjectStartDateManager projectStartDateManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        projectStartDateManager.insertProjectStartDate();
    }
}
