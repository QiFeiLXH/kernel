package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 11:08
 * @Description 部门对公费用记录（中标服务费）
 */
public class DeptPublicCostDTO implements Serializable {
    private Integer id;
    /** 申请工号 */
    private String applicationPersonId;
    /** 申请人 */
    private String applicationPerson;
    /** 申请部门代码 */
    private String applicationDeptCode;
    /** 申请部门 */
    private String applicationDept;
    /** 归属人工号 */
    private String payeeId;
    /** 归属人 */
    private String payee;
    /** 收款部门代码 */
    private String receivingDeptCode;
    /** 收款部门拼音 */
    private String receivingDeptSimpleCode;
    /** 收款部门 */
    private String receivingDept;
    /** 数据来源 1.对公费用 2.中标服务费 */
    private Integer costType;
    private String costTypeText;
    /** 招标标号 */
    private String tenderNumber;
    /** 申请金额 */
    private Double applicationAmount;
    /** 发放金额 */
    private Double amountIssued;
    /** 发放时间 */
    private Date releaseTime;
    /** 挂账周期 */
    private Integer accountingCycle;
    /** 账户情况 */
    private String accountinfo;
    /** 发票归还标志 0未归还 1归还 */
    private Integer invoiceReturnFlag;
    /** oa流水号 */
    private String lshid;
    private Date sqsj;
    private Double spje;
    private String projectName;
    private Double shje;
    /** 逾期标记 */
    private Integer overdueFlag;
    /** 逾期天数 */
    private Integer overdueDays;
    /** 超额金额 */
    private Double excessAmount;
    /** 审核标志 */
    private Integer approvalMark;
    /** 税票号 */
    private String taxReceiptNo;
    /** 备注 */
    private String remarks;
    /** 审核备注 */
    private String auditNotes;
    /** 工资系统发放 */
    private Integer isSystemRelease;
    /** 非个人 */
    private Integer impersonal;
    /** 自用 */
    private Integer selfUse;
    /** 超标 */
    private Integer exceedStandard;
    /** 核算部门名称*/
    private String accountingDepartment;
    /** 合同编号*/
    private String contractNo;
    /** 合同名称*/
    private String contractName;
    /** 客户名称*/
    private String customerName;
    /** 核算口径归属名称*/
    private String accountingCaliberName;
    /** 回款单位名称*/
    private String paybackDeptName;
    /** 子公司名称*/
    private String subsidiaryName;
    /** 票据名称*/
    private String billName;
    /** 开户银行*/
    private String depositBank;
    /** 费用分类*/
    private String classificationName;
    /** 代理商名称*/
    private String agentName;
    /** 银行账号*/
    private String bankAccount;
    /** 回款金额*/
    private Double collectionAmount;
    /** 回款日期*/
    private Date collectionDate;
    /** 明细科目*/
    private String detailedAccountName;
    /** 原始单号*/
    private String originalNo;
    /** 费用类别*/
    private String expenseCategory;
    /** 登记人*/
    private String registrant;
    /** 提成比例*/
    private Double percentage;
    /** 审核人*/
    private String reviewer;
    /** 核算时间*/
    private Date accountingTime;
    /** 发放方式*/
    private String distributionMethod;
    /** 发放人*/
    private String issuer;
    /** 审核日期*/
    private Date auditDate;
    /** 发放标志*/
    private Integer releaseMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationPersonId() {
        return applicationPersonId;
    }

    public void setApplicationPersonId(String applicationPersonId) {
        this.applicationPersonId = applicationPersonId;
    }

    public String getApplicationPerson() {
        return applicationPerson;
    }

    public void setApplicationPerson(String applicationPerson) {
        this.applicationPerson = applicationPerson;
    }

    public String getApplicationDeptCode() {
        return applicationDeptCode;
    }

    public void setApplicationDeptCode(String applicationDeptCode) {
        this.applicationDeptCode = applicationDeptCode;
    }

    public String getApplicationDept() {
        return applicationDept;
    }

    public void setApplicationDept(String applicationDept) {
        this.applicationDept = applicationDept;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getReceivingDeptCode() {
        return receivingDeptCode;
    }

    public void setReceivingDeptCode(String receivingDeptCode) {
        this.receivingDeptCode = receivingDeptCode;
    }

    public String getReceivingDeptSimpleCode() {
        return receivingDeptSimpleCode;
    }

    public void setReceivingDeptSimpleCode(String receivingDeptSimpleCode) {
        this.receivingDeptSimpleCode = receivingDeptSimpleCode;
    }

    public String getReceivingDept() {
        return receivingDept;
    }

    public void setReceivingDept(String receivingDept) {
        this.receivingDept = receivingDept;
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

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public Double getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(Double applicationAmount) {
        this.applicationAmount = applicationAmount;
    }

    public Double getAmountIssued() {
        return amountIssued;
    }

    public void setAmountIssued(Double amountIssued) {
        this.amountIssued = amountIssued;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getAccountingCycle() {
        return accountingCycle;
    }

    public void setAccountingCycle(Integer accountingCycle) {
        this.accountingCycle = accountingCycle;
    }

    public String getAccountinfo() {
        return accountinfo;
    }

    public void setAccountinfo(String accountinfo) {
        this.accountinfo = accountinfo;
    }

    public Integer getInvoiceReturnFlag() {
        return invoiceReturnFlag;
    }

    public void setInvoiceReturnFlag(Integer invoiceReturnFlag) {
        this.invoiceReturnFlag = invoiceReturnFlag;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Date getSqsj() {
        return sqsj;
    }

    public void setSqsj(Date sqsj) {
        this.sqsj = sqsj;
    }

    public Double getSpje() {
        return spje;
    }

    public void setSpje(Double spje) {
        this.spje = spje;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getShje() {
        return shje;
    }

    public void setShje(Double shje) {
        this.shje = shje;
    }

    public Integer getOverdueFlag() {
        return overdueFlag;
    }

    public void setOverdueFlag(Integer overdueFlag) {
        this.overdueFlag = overdueFlag;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Double getExcessAmount() {
        return excessAmount;
    }

    public void setExcessAmount(Double excessAmount) {
        this.excessAmount = excessAmount;
    }

    public Integer getApprovalMark() {
        return approvalMark;
    }

    public void setApprovalMark(Integer approvalMark) {
        this.approvalMark = approvalMark;
    }

    public String getTaxReceiptNo() {
        return taxReceiptNo;
    }

    public void setTaxReceiptNo(String taxReceiptNo) {
        this.taxReceiptNo = taxReceiptNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAuditNotes() {
        return auditNotes;
    }

    public void setAuditNotes(String auditNotes) {
        this.auditNotes = auditNotes;
    }

    public Integer getIsSystemRelease() {
        return isSystemRelease;
    }

    public void setIsSystemRelease(Integer isSystemRelease) {
        this.isSystemRelease = isSystemRelease;
    }

    public Integer getImpersonal() {
        return impersonal;
    }

    public void setImpersonal(Integer impersonal) {
        this.impersonal = impersonal;
    }

    public Integer getSelfUse() {
        return selfUse;
    }

    public void setSelfUse(Integer selfUse) {
        this.selfUse = selfUse;
    }

    public Integer getExceedStandard() {
        return exceedStandard;
    }

    public void setExceedStandard(Integer exceedStandard) {
        this.exceedStandard = exceedStandard;
    }

    public String getAccountingDepartment() {
        return accountingDepartment;
    }

    public void setAccountingDepartment(String accountingDepartment) {
        this.accountingDepartment = accountingDepartment;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountingCaliberName() {
        return accountingCaliberName;
    }

    public void setAccountingCaliberName(String accountingCaliberName) {
        this.accountingCaliberName = accountingCaliberName;
    }

    public String getPaybackDeptName() {
        return paybackDeptName;
    }

    public void setPaybackDeptName(String paybackDeptName) {
        this.paybackDeptName = paybackDeptName;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(Double collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getDetailedAccountName() {
        return detailedAccountName;
    }

    public void setDetailedAccountName(String detailedAccountName) {
        this.detailedAccountName = detailedAccountName;
    }

    public String getOriginalNo() {
        return originalNo;
    }

    public void setOriginalNo(String originalNo) {
        this.originalNo = originalNo;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getAccountingTime() {
        return accountingTime;
    }

    public void setAccountingTime(Date accountingTime) {
        this.accountingTime = accountingTime;
    }

    public String getDistributionMethod() {
        return distributionMethod;
    }

    public void setDistributionMethod(String distributionMethod) {
        this.distributionMethod = distributionMethod;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getReleaseMark() {
        return releaseMark;
    }

    public void setReleaseMark(Integer releaseMark) {
        this.releaseMark = releaseMark;
    }
}
