package com.bsoft.system.timer;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.entity.primary.TimeTaskDO;
import com.bsoft.system.manager.TimeTaskManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-06-29 11:12
 * @Version 1.0
 * @Description
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class HelloWorldJob implements Job {
    @Autowired
    private TimeTaskManager timeTaskManager;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
            TimeTaskDTO timeTaskDO = timeTaskManager.get(10);
            System.out.println("这是一个定时器id为:"+ timeTaskDO.getId()+"时间："+ serverDateManager.getServerDateTime());

    }

}
