package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-17
 * @Description: 项目计划查询-日志列表
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_PLAN_QUERY_WORKLOG_VIEW")
public class ProjectPlanQueryLogDO {
    @Id
    /** id */
    private Integer id;
    /** 考勤id */
    private Integer attendanceId;
    /** 项目id */
    private String projectId;
    /** 合同编号 */
    private String contractNo;
    /** 员工id */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 阶段id */
    private Integer milepostId;
    /** 考勤日期 */
    private String attendanceDate;
    /** 工作量 */
    private Double workload;
    /** 工时占比 */
    private Double workloadRate;
    /** 角色：1、管理 2、销售 3、技术 4、工程 5、服务 6、其他 7、支持 */
    private Integer role;
    /** 类别：1、会议 2、协调 3、上线 4、培训5、验收 6、维护7、其他 */
    private Integer type;
    /** 结果0:进行中 1：已完成 */
    private Integer result;
    /** 审核状态 4为已审 其他待审 */
    private Integer auditStatus;
    /** 审核状态 4为已审 其他待审 */
    private String auditStatusText;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Double getWorkloadRate() {
        return workloadRate;
    }

    public void setWorkloadRate(Double workloadRate) {
        this.workloadRate = workloadRate;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatusText() {
        return auditStatusText;
    }

    public void setAuditStatusText(String auditStatusText) {
        this.auditStatusText = auditStatusText;
    }
}
