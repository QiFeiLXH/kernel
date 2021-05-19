package com.bsoft.system.manager;

import com.bsoft.system.entity.primary.TimeTaskDO;
import org.quartz.SchedulerException;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:43
 * @Version 1.0
 * @Description
 */
public interface QuartzManager {
    void addJob(TimeTaskDO task);
    void deleteJob(TimeTaskDO task) throws SchedulerException;
    void updateJobCron(TimeTaskDO task) throws SchedulerException;
    void runJobNow(TimeTaskDO task) throws SchedulerException;
    void pauseJob(TimeTaskDO task) throws SchedulerException;
    void resumeJob(TimeTaskDO task) throws SchedulerException;
}
