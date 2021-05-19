package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:08
 * @Description
 */
public class PrintingDTO implements Serializable {
    private Integer id;
    /** 订单编号 */
    private String orderNum;
    /** 申请人 */
    private String applicant;
    private String applicantName;
    /** 拼音码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    private String deptName;
    /** 文印日期 */
    private Date printDate;
    /** 合计金额 */
    private Double sumAmount;
    /** 核准金额 */
    private Double approval;
    private String approvalStr;
    /** 流水号id */
    private String lshid;
    /** 状态 */
    private Integer status;
    private String statusText;
    /** 申请日期 */
    private Date applyDate;
    /** 归属人 */
    private String belonger;
    private String belongerName;
    /** 归属部门 */
    private String belongDept;
    private String belongDeptName;
    /** 项目id */
    private String projectId;
    private String projectName;
    /** 费用类别 */
    private Integer costType;
    private String costTypeText;
    /** 核算口径 */
    private Integer accountCaliber;
    private String accountCaliberText;
    /** 申领事由 */
    private String reason;
    /** 文印单位 */
    private Integer printUnit;
    private String printUnitName;
    /** 申请支付日期 */
    private Date applyPayDate;
    /** 失败原因 */
    private String failureReason;
    /** 联系人 */
    private String contactPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Double getApproval() {
        return approval;
    }

    public void setApproval(Double approval) {
        this.approval = approval;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public String getBelongerName() {
        return belongerName;
    }

    public void setBelongerName(String belongerName) {
        this.belongerName = belongerName;
    }

    public String getBelongDept() {
        return belongDept;
    }

    public void setBelongDept(String belongDept) {
        this.belongDept = belongDept;
    }

    public String getBelongDeptName() {
        return belongDeptName;
    }

    public void setBelongDeptName(String belongDeptName) {
        this.belongDeptName = belongDeptName;
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

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCostTypeText() {
        return costTypeText;
    }

    public void setCostTypeText(String costTypeText) {
        this.costTypeText = costTypeText;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPrintUnit() {
        return printUnit;
    }

    public void setPrintUnit(Integer printUnit) {
        this.printUnit = printUnit;
    }

    public String getPrintUnitName() {
        return printUnitName;
    }

    public void setPrintUnitName(String printUnitName) {
        this.printUnitName = printUnitName;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getApprovalStr() {
        return approvalStr;
    }

    public void setApprovalStr(String approvalStr) {
        this.approvalStr = approvalStr;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
