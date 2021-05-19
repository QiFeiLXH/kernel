package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkLogDTO implements Serializable {
    private Integer id; //主键
    private Integer attendanceId; //考勤ID
    private String workLog; //工作日志
    private Date submitDate; //提交时间
    private Integer flag; //提交类型
    private String projectType; //项目类别
    private String projectDept; //项目部门
    private String projectId; //归属项目
    private Double projectScale; //项目比例
    private Double workLoad; //工作量
    private String projectDeptName; //项目部门名称
    private String projectName;//项目名称
    private Integer checkFlag;//日志确认标志
    private Integer sourceType;//日志来源 0 本表 1 支持结算 2 结构化日志
    private String technumid;//支持单号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(String projectDept) {
        this.projectDept = projectDept;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getProjectScale() {
        return projectScale;
    }

    public void setProjectScale(Double projectScale) {
        this.projectScale = projectScale;
    }

    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    public String getProjectDeptName() {
        return projectDeptName;
    }

    public void setProjectDeptName(String projectDeptName) {
        this.projectDeptName = projectDeptName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getTechnumid() {
        return technumid;
    }

    public void setTechnumid(String technumid) {
        this.technumid = technumid;
    }
}
