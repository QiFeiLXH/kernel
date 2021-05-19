package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectLogQueryProjectDTO implements Serializable {
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 项目经理 */
    private String projectManager;
    /** 日志填写人 */
    private String submitter;
    /** 考勤日期 */
    private String attendanceDate;
    /** 日志数 */
    private Integer logsNum;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getLogsNum() {
        return logsNum;
    }

    public void setLogsNum(Integer logsNum) {
        this.logsNum = logsNum;
    }
}
