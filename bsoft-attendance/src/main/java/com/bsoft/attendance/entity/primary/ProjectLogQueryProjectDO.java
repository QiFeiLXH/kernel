package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-10
 * @Description: 项目日志查询-项目列表
 */
@Entity
@Table(name="bsoft_portal.ker_projectlog_query_view")
public class ProjectLogQueryProjectDO {
    @Id
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
