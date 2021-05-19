package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ker_att_worklogverify_view")
public class WorkLogVerifyDO {
    private String projectId;
    private String projectName;
    private Integer workLogId;
    private String personId;
    private String personName;
    private Date attendanceDate;
    private Double projectScale;
    private String workLog;
    private Double workLoad;
    private String projectPinyin;
    private String personPinyin;
    private String projectManager;
    private Integer verifyFlag;
    private Double verifyHours;
    private String verifyRemark;
    private String verifier;
    private Date verifyDate;

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

    @Id
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
