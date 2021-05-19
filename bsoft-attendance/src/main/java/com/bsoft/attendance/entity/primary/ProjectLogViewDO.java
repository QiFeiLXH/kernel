package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2020/7/17
 * @Description:
 */
@Entity
@Table(name="bsoft_portal.ker_plam_projectlog_view")
public class ProjectLogViewDO {

    @Id
    private Integer id;

    private Integer attendanceId;

    private Integer milepostId;

    private String milepostName;

    private Integer range;

    private Integer plan;

    private Integer role;

    private String roleText;

    private Integer model;

    private String modelText;

    private Integer type;

    private String typeText;

    private String workLog;

    private Integer workLogId;

    private String projectId;

    private String projectName;

    private Integer result;

    private String resultText;

    private String contractNo;

    private Date attendanceDate;

    private String submitter;

    private String technumid;

    private Integer auditCount;

    private Double workload;

    private String projectType;
    private String projectDept;
    private Integer sourceType;
    private Integer auditType;

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

    public String getMilepostName() {
        return milepostName;
    }

    public void setMilepostName(String milepostName) {
        this.milepostName = milepostName;
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

    public String getRoleText() {
        return roleText;
    }

    public void setRoleText(String roleText) {
        this.roleText = roleText;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getModelText() {
        return modelText;
    }

    public void setModelText(String modelText) {
        this.modelText = modelText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getTechnumid() {
        return technumid;
    }

    public void setTechnumid(String technumid) {
        this.technumid = technumid;
    }

    public Integer getAuditCount() {
        return auditCount;
    }

    public void setAuditCount(Integer auditCount) {
        this.auditCount = auditCount;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
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

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }
}
