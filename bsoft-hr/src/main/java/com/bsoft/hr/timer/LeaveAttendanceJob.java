package com.bsoft.hr.timer;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.hr.manager.LeaveManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/7 17:40
 * @Description 修改员工请假出勤
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class LeaveAttendanceJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveAttendanceJob.class);

    @Autowired
    private LeaveManager leaveManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TimeConsumer timeConsumer = TimeConsumer.start();
        leaveManager.updateLeaveAttendance();
        long times = timeConsumer.end();
        LOGGER.info("根据请假表数据更新考勤表出勤结束，共耗时：{}", times);
    }
}
