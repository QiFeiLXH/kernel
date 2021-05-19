package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @CreateTime: 2020-04-10
 * @Description: 项目日志查询-日志明细
 */
@Entity
@Table(name="bsoft_portal.ker_logquery_detail_view")
public class ProjectLogQueryDetailDO {
    @Id
    private Integer id;
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 项目计划阶段id */
    private Integer milepostId;
    /** 项目计划阶段名称 */
    private String milepostName;
    /** 项目比例 */
    private Double projectRate;
    /** 员工id */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音简码 */
    private String personSimpleCode;
    /** 部门代码 */
    private String deptCode;
    /** 部门名称 */
    private String deptName;
    /** 部门名称拼音简码 */
    private String deptSimpleCode;
    /** 项目日志 */
    private String worklog;
    /** 范围：1、合同内 2、合同外 */
    private Integer range;
    /** 计划：1、计划内 2、计划外 */
    private Integer plan;
    /** 角色：1、管理 2、销售 3、技术 4、工程 5、服务 6、其他 7、支持 */
    private Integer role;
    /** 方式：1、现场2、远程 */
    private Integer model;
    /** 类别：1、会议 2、协调 3、上线 4、培训5、验收 6、维护7、其他 */
    private Integer type;
    /** 工时 */
    private Double workload;
    /** 结果0:进行中 1：已完成 */
    private Integer result;
    /** 审核状态 */
    private Integer auditStatus;
    /** 审核状态名称 */
    private String auditStatusText;
    /** 考勤日期 */
    private String attendanceDate;
    /** 项目经理id */
    private String projectManager;
    /** 项目经理名称 */
    private String projectManagerText;
    /** 签订日期 */
    private Date signDate;
    /** 工程区域代码 */
    private String area;
    /** 工程区域名称 */
    private String areaText;
    /** 合同金额 */
    private Double hte;
    /** 客户编号 */
    private String customerCode;
    /** 客户名称 */
    private String customerName;
    /** 客户分类 */
    private String classificationCode;
    /** 客户分类 */
    private String classification;
    /** 客户等级 */
    private String gradeCode;
    /** 客户等级 */
    private String grade;
    /** 所属区域代码 */
    private String regionCode;
    /** 所属区域文本 */
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getProjectRate() {
        return projectRate;
    }

    public void setProjectRate(Double projectRate) {
        this.projectRate = projectRate;
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

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getWorklog() {
        return worklog;
    }

    public void setWorklog(String worklog) {
        this.worklog = worklog;
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

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerText() {
        return projectManagerText;
    }

    public void setProjectManagerText(String projectManagerText) {
        this.projectManagerText = projectManagerText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public Double getHte() {
        return hte;
    }

    public void setHte(Double hte) {
        this.hte = hte;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPersonSimpleCode() {
        return personSimpleCode;
    }

    public void setPersonSimpleCode(String personSimpleCode) {
        this.personSimpleCode = personSimpleCode;
    }

    public String getDeptSimpleCode() {
        return deptSimpleCode;
    }

    public void setDeptSimpleCode(String deptSimpleCode) {
        this.deptSimpleCode = deptSimpleCode;
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

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
