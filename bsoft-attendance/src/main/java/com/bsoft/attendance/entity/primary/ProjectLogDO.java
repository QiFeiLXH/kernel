package com.bsoft.attendance.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * 项目工程日志
 */
@Entity
@Table(name="bsoft_portal.pro_worklog")
public class ProjectLogDO {
    private Integer id;
    private Integer attendanceId;
    private Integer milepostId;
    private Integer range;
    private Integer plan;
    private Integer role;
    private Integer model;
    private Integer type;
    private String workLog;
    private Double workload;
    private Integer workLogId;
    private String auditter;
    private String nextAuditter;//待审人
    private Date auditDate;
    private Integer auditFlag;
    private Integer refuse;
    private String remark;
    private Date submitDate;
    private String submitter;
    private Integer result;
    private Integer auditType;
    private Date attendanceDate;
    private String technumid;
    private Integer auditCount;
    private String projectId;
    private Date lastestOperate;
    private String projectType;
    private String projectDept;
    private Integer sourceType;
    private String projectName;
    private String contractNo;

    @Id
    @SequenceGenerator(name="seq_pro_worklog",allocationSize=1,sequenceName="seq_pro_worklog")
    @GeneratedValue(generator="seq_pro_worklog",strategy=GenerationType.SEQUENCE)
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

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public String getNextAuditter() {
        return nextAuditter;
    }

    public void setNextAuditter(String nextAuditter) {
        this.nextAuditter = nextAuditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getRefuse() {
        return refuse;
    }

    public void setRefuse(Integer refuse) {
        this.refuse = refuse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Transient
    public String getTechnumid() {
        return technumid;
    }

    public void setTechnumid(String technumid) {
        this.technumid = technumid;
    }

    @Transient
    public Integer getAuditCount() {
        return auditCount;
    }

    public void setAuditCount(Integer auditCount) {
        this.auditCount = auditCount;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getLastestOperate() {
        return lastestOperate;
    }

    public void setLastestOperate(Date lastestOperate) {
        this.lastestOperate = lastestOperate;
    }

    @Transient
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Transient
    public String getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(String projectDept) {
        this.projectDept = projectDept;
    }

    @Transient
    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Transient
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Transient
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
}
