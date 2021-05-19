package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;


public class WorkLogVerifyDTO implements Serializable {
    private String projectId; //项目ID
    private String projectName; //项目名称
    private Integer workLogId; //日志ID
    private String personId; //考勤人员工号
    private String personName; //考勤人员姓名
    private Date attendanceDate; //考勤日期
    private Double projectScale; //项目比例
    private String workLog; //工作日志
    private Double workLoad; //工作量
    private String projectPinyin; //项目拼音简码
    private String personPinyin; //人员拼音简码
    private String projectManager; //项目经理
    private Integer verifyFlag; //审核标志 1同意 -1退回
    private Double verifyHours; //审核工时
    private String verifyRemark; //审核备注
    private String verifier; //审核人
    private Date verifyDate; //审核时间

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

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Double getProjectScale() {
        return projectScale;
    }

    public void setProjectScale(Double projectScale) {
        this.projectScale = projectScale;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    public String getProjectPinyin() {
        return projectPinyin;
    }

    public void setProjectPinyin(String projectPinyin) {
        this.projectPinyin = projectPinyin;
    }

    public String getPersonPinyin() {
        return personPinyin;
    }

    public void setPersonPinyin(String personPinyin) {
        this.personPinyin = personPinyin;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Double getVerifyHours() {
        return verifyHours;
    }

    public void setVerifyHours(Double verifyHours) {
        this.verifyHours = verifyHours;
    }

    public String getVerifyRemark() {
        return verifyRemark;
    }

    public void setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }
}
