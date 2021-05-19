package com.bsoft.attendance.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ker_att_worklog_view")
public class WorkLogViewDO {
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
    private String projectName; //项目名称
    private String projectDeptName;//项目部门名称
    private Integer verifyFlag; //审核标志
    private Double verifyHours; //审核工时
    private String verifyRemark; //审核备注
    private String verifier; //审核人
    private Date verifyDate; //审核时间
    private Integer checkFlag;//日志确认标志
    private String technumid;//支持单号
    private Integer sourceType;//来源


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "kqid")
    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    @Column(name = "gzrz")
    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    @Column(name = "tjsj")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "xmlb")
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Column(name = "xmbm")
    public String getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(String projectDept) {
        this.projectDept = projectDept;
    }

    @Column(name = "gsxm")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "xmbl")
    public Double getProjectScale() {
        return projectScale;
    }

    public void setProjectScale(Double projectScale) {
        this.projectScale = projectScale;
    }

    @Column(name = "gzsj")
    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    @Column(name = "projectname")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "projectdeptname")
    public String getProjectDeptName() {
        return projectDeptName;
    }

    public void setProjectDeptName(String projectDeptName) {
        this.projectDeptName = projectDeptName;
    }

    @Column(name = "rzsh")
    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }
    @Column(name = "shgs")
    public Double getVerifyHours() {
        return verifyHours;
    }

    public void setVerifyHours(Double verifyHours) {
        this.verifyHours = verifyHours;
    }
    @Column(name = "bzxx")
    public String getVerifyRemark() {
        return verifyRemark;
    }

    public void setVerifyRemark(String verifyRemark) {
        this.verifyRemark = verifyRemark;
    }

    @Column(name = "shgh")
    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    @Column(name = "shsj")
    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    @Column(name = "qrbz")
    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    @Column(name = "sourcetype")
    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Column(name = "technumid")
    public String getTechnumid() {
        return technumid;
    }

    public void setTechnumid(String technumid) {
        this.technumid = technumid;
    }
}
