package com.bsoft.payment.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.entity.primary
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:08
 * @Description: 财务流水、收益
 */
public class FlowPaymentDTO implements Serializable {
    private Integer id;
    /** 部门id */
    private String deptId;
    private String deptName;
    /** 一级部门 */
    private String parentDeptId;
    private String parentDeptName;
    /** 机构名称 */
    private String orgName;
    /** 业务条线 */
    private Integer businessLine;
    private String businessLineText;
    /** 类别 */
    private Integer type;
    private String typeText;
    /** 金额 */
    private Double amount;
    private String amountStr;
    /** 核算时间 */
    private Date accountDate;
    private String accountDateStr;
    /** 审核时间 */
    private Date auditDate;
    /** 审核标志 */
    private Integer auditFlag;
    /** 审核人 */
    private String auditter;
    /** 备注信息 */
    private String remark;
    /** 登记日期 */
    private Date registrationDate;
    /** 登记人 */
    private String register;
    private String registerName;
    /** 1.流水  2.收益 */
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(Integer businessLine) {
        this.businessLine = businessLine;
    }

    public String getBusinessLineText() {
        return businessLineText;
    }

    public void setBusinessLineText(String businessLineText) {
        this.businessLineText = businessLineText;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountStr() {
        return amountStr;
    }

    public void setAmountStr(String amountStr) {
        this.amountStr = amountStr;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
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

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getAccountDateStr() {
        return accountDateStr;
    }

    public void setAccountDateStr(String accountDateStr) {
        this.accountDateStr = accountDateStr;
    }
}
