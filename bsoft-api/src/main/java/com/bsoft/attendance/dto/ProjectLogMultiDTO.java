package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * @author  hy
 * @date  2020/3/18 9:58
 * @description
 */
public class ProjectLogMultiDTO implements Serializable {
    private AttendanceDTO attendance;
    private List<ProjectLogDTO> projectLogs;

    public AttendanceDTO getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceDTO attendance) {
        this.attendance = attendance;
    }

    public List<ProjectLogDTO> getProjectLogs() {
        return projectLogs;
    }

    public void setProjectLogs(List<ProjectLogDTO> projectLogs) {
        this.projectLogs = projectLogs;
    }
}
