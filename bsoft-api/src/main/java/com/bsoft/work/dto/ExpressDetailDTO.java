package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 14:53
 * @Description
 */
public class ExpressDetailDTO implements Serializable {
    private Integer id;
    /** 快递单号 */
    private String expressNo;
    /** 申请人 */
    private String applicant;
    private String applicantName;
    /** 部门id */
    private String deptId;
    private String deptName;
    /** 申请日期 */
    private Date applyDate;
    /** 金额 */
    private Double amount;
    /** 核准金额 */
    private Double approval;
    private String approvalStr;
    /** 流水号id */
    private String lshid;
    /** 状态 */
    private Integer status;
    private String statusText;
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
    /** 申领理由 */
    private String reason;
    /** 快递内容 */
    private String context;
    /** 收件人 */
    private String recipient;
    /** 收件地区 */
    private String area;
    /** 收件地址 */
    private String address;
    /** 重量 */
    private String weight;
    /** 寄件日期 */
    private Date shipmentDate;
    /** 寄件人 */
    private String sender;
    /** 失败原因 */
    private String failureReason;
    /** 申请支付日期 */
    private Date applyPayDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getApprovalStr() {
        return approvalStr;
    }

    public void setApprovalStr(String approvalStr) {
        this.approvalStr = approvalStr;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }
}
