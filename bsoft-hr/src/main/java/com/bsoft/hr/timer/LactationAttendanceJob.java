package com.bsoft.hr.timer;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.hr.manager.LactationManager;
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
 * @Date 2021/1/5 17:26
 * @Description 当人员在哺乳假期间内的，上下班迟到、早退时间，在哺乳假时间内的，算正常出勤
 */
@DisallowConcurrentExecution
@Component
public class LactationAttendanceJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(LactationAttendanceJob.class);

    @Autowired
    private LactationManager lactationManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TimeConsumer timeConsumer = TimeConsumer.start();
        lactationManager.updateLactationAttendance();
        long times = timeConsumer.end();
        LOGGER.info("根据哺乳假员工更新考勤表出勤结束，共耗时：{}", times);
    }
}
