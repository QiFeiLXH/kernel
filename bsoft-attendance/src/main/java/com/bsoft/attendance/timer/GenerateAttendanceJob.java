package com.bsoft.attendance.timer;

import com.bsoft.attendance.manager.AttendanceManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/15 16:40
 * @Description 每天将未离职的员工生成到考勤表
 */
@DisallowConcurrentExecution
@Component
public class GenerateAttendanceJob implements Job {
    @Autowired
    private AttendanceManager attendanceManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        attendanceManager.generateAttendance();

    }
}
