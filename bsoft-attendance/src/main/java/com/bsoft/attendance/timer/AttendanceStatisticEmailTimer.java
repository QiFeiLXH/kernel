package com.bsoft.attendance.timer;

import com.bsoft.attendance.manager.AttendanceReportManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/2 9:58
 * @Description 考勤统计未提交邮件-每月1号发送津贴文秘，6号抄送李金铭
 */
@DisallowConcurrentExecution
@Component
public class AttendanceStatisticEmailTimer implements Job {
    @Autowired
    private AttendanceReportManager attendanceReportManager;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        attendanceReportManager.sendAttendanceStatisticRemindEmail();
    }
}
