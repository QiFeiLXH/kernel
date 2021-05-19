package com.bsoft.system.manager.impl;

import com.bsoft.system.entity.primary.TimeTaskDO;
import com.bsoft.system.manager.QuartzManager;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-06-29 10:44
 * @Version 1.0
 * @Description
 */
@Component
public class QuartzManagerImpl implements QuartzManager {
    @Autowired
    private Scheduler scheduler;
    /**
     * 添加任务
     *
     * @param task
     * @throws SchedulerException
     */
    @Override
    public void addJob(TimeTaskDO task) {
        try {
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类

            Class<? extends Job> jobClass = (Class<? extends Job>) (Class.forName(task.getBeanClass()).newInstance()
                    .getClass());
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(task.getTaskName(), task.getTaskGroup())// 任务名称和组构成任务key
                    .build();
            //赋值to邮件接收人 与cc抄送人
            jobDetail.getJobDataMap().put("to",task.getReceiver());
            jobDetail.getJobDataMap().put("cc",task.getCcPerson());
            // 定义调度触发规则
            // 使用cornTrigger规则
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(task.getTaskName(), task.getTaskGroup())// 触发器key
                    .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(CronScheduleBuilder.cronSchedule(task.getExpression())).startNow().build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除任务
     *
     * @param task
     * @throws SchedulerException
     */
    @Override
    public void deleteJob(TimeTaskDO task) throws SchedulerException{
        JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 更新表达式
     *
     * @param task
     * @throws SchedulerException
     */
    @Override
    public void updateJobCron(TimeTaskDO task) throws SchedulerException{
        TriggerKey triggerKey = TriggerKey.triggerKey(task.getTaskName(), task.getTaskGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getExpression());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 立即执行job
     *
     * @param task
     * @throws SchedulerException
     */
    @Override
    public void runJobNow(TimeTaskDO task) throws SchedulerException{
        JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 暂停一个job
     *
     * @param task
     * @throws SchedulerException
     */
    public void pauseJob(TimeTaskDO task) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复一个job
     *
     * @param task
     * @throws SchedulerException
     */
    public void resumeJob(TimeTaskDO task) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(task.getTaskName(), task.getTaskGroup());
        scheduler.resumeJob(jobKey);
    }

}
