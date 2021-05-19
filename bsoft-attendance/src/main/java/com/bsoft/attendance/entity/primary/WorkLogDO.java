package com.bsoft.attendance.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.KQ_GZRZ")
public class WorkLogDO {
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
    private String projectName; //项目名称（不会保存至数据库）
    private Integer verifyFlag; //审核标志
    private Double verifyHours; //审核工时
    private String verifyRemark; //审核备注
    private String verifier; //审核人
    private Date verifyDate; //审核时间
    private Integer checkFlag;//日志确认标志
    private Integer sourceType;//日志来源 0 本表 1 支持结算 2 结构化日志
    private String technumid;//支持单号
    private String personId;//工号
    private Date attendanceDate;//考勤日期
    private String rank;//等级
    private Double wages;//工资*项目比例

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

    @Transient
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    @Column(name = "personid")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "attendancedate")
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Column(name = "wages")
    public Double getWages() {
        return wages;
    }

    public void setWages(Double wages) {
        this.wages = wages;
    }
}
