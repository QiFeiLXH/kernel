package com.bsoft.system.listener;

import com.bsoft.common.manager.TimerTaskStartManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.system.manager.TimeTaskManager;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:24
 * @Version 1.0
 * @Description
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobInitListener.class);

    @Autowired
    TimeTaskManager timeTaskManager;
    @Autowired
    private QuartzJobListener quartzJobListener;
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private TimerTaskStartManager timerTaskStartManager;

    @Override
    public void run(String... arg0) {
        try {
            if(!timerTaskStartManager.isAllowStart()){
                logger.info("非指定服务器，无法启动定时器！");
                return;
            }
            scheduler.getListenerManager().addJobListener(quartzJobListener);
            scheduler.start();
            timeTaskManager.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
