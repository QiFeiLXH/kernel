package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/20 13:09
 * @Description
 */
public class BondOverdueInfoDTO implements Serializable {
    private String id;
    /** 申请人员id */
    private String applicationPersonId;
    /** 申请人员 */
    private String applicationPerson;
    /** 申请人拼音码 */
    private String applicationPersonSimpleCode;
    /** 申请部门代码 */
    private String applicationDeptCode;
    /** 申请部门 */
    private String applicationDept;
    /** 领款人id */
    private String payeeId;
    /** 领款人 */
    private String payee;
    /** 收款单位 */
    private String receivingDeptCode;
    /** 收款单位 */
    private String receivingDept;
    /** 收款部门拼音 */
    private String receivingDeptSimpleCode;
    /** 招标标号 */
    private String tenderNumber;
    /** 申请金额 */
    private Double applicationAmount;
    /** 履约标志 0未履约 1履约 */
    private Integer performanceFlag;
    /** 预计退款时间 */
    private Date estimatedRefundTime;
    /** 合同号 */
    private String contractNo;
    /** 合同名称 */
    private String contractName;
    /** 借款类别 */
    private Integer loanType;
    /** 借款类别名称 */
    private String loanTypeText;
    /** 逾期标记 */
    private Integer overdueFlag;
    /** 逾期天数 */
    private Integer overdueDays;
    /** 账户情况 */
    private String accountInfo;
    /** oa流水号 */
    private String lshid;
    /** 登记日期 */
    private Date applicationDate;
    /** 归属人 */
    private String attributorId;
    private String attributor;
    /** 支付方式 */
    private String paymentWay;
    private String paymentWayText;
    /** 申请付款时间 */
    private Date applicationPaymentTime;
    /** 合同编号 */
    private String contractCode;
    /** 销售主导 */
    private Integer salesLead;
    private String salesLeadText;
    /** 税票标志 */
    private Integer taxFlag;
    /** 税票号 */
    private String taxNo;
    /** 税票金额 */
    private Double taxAmount;
    /** 客户名称 */
    private String clientName;
    /** 使用说明 */
    private String useInstructions;
    /** 具体条款 */
    private String specificTerms;
    /** 到款日期 */
    private Date paymentDate;
    /** 到款银行 */
    private String paymentBank;
    /** 备注信息 */
    private String markInfo;
    /** 审核人员 */
    private String auditId;
    private String auditor;
    /** 审核标志 */
    private Integer auditFlag;
    /** 审核时间 */
    private Date auditDate;
    /** 发放人员 */
    private String issuerId;
    private String issuer;
    /** 发放标志 */
    private Integer issueFlag;
    /** 发放日期 */
    private Date issueDate;
    /** 冲账人员 */
    private String chargePersonId;
    private String chargePerson;
    /** 冲账标志 */
    private Integer chargeFlag;
    /** 冲账日期 */
    private Date chargeDate;
    /** 登记人员 */
    private String registerPersonId;
    private String registerPerson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getApplicationPersonSimpleCode() {
        return applicationPersonSimpleCode;
    }

    public void setApplicationPersonSimpleCode(String applicationPersonSimpleCode) {
        this.applicationPersonSimpleCode = applicationPersonSimpleCode;
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

    public String getReceivingDept() {
        return receivingDept;
    }

    public void setReceivingDept(String receivingDept) {
        this.receivingDept = receivingDept;
    }

    public String getReceivingDeptSimpleCode() {
        return receivingDeptSimpleCode;
    }

    public void setReceivingDeptSimpleCode(String receivingDeptSimpleCode) {
        this.receivingDeptSimpleCode = receivingDeptSimpleCode;
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

    public Integer getPerformanceFlag() {
        return performanceFlag;
    }

    public void setPerformanceFlag(Integer performanceFlag) {
        this.performanceFlag = performanceFlag;
    }

    public Date getEstimatedRefundTime() {
        return estimatedRefundTime;
    }

    public void setEstimatedRefundTime(Date estimatedRefundTime) {
        this.estimatedRefundTime = estimatedRefundTime;
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

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public String getLoanTypeText() {
        return loanTypeText;
    }

    public void setLoanTypeText(String loanTypeText) {
        this.loanTypeText = loanTypeText;
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

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getAttributorId() {
        return attributorId;
    }

    public void setAttributorId(String attributorId) {
        this.attributorId = attributorId;
    }

    public String getAttributor() {
        return attributor;
    }

    public void setAttributor(String attributor) {
        this.attributor = attributor;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getPaymentWayText() {
        return paymentWayText;
    }

    public void setPaymentWayText(String paymentWayText) {
        this.paymentWayText = paymentWayText;
    }

    public Date getApplicationPaymentTime() {
        return applicationPaymentTime;
    }

    public void setApplicationPaymentTime(Date applicationPaymentTime) {
        this.applicationPaymentTime = applicationPaymentTime;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Integer getSalesLead() {
        return salesLead;
    }

    public void setSalesLead(Integer salesLead) {
        this.salesLead = salesLead;
    }

    public String getSalesLeadText() {
        return salesLeadText;
    }

    public void setSalesLeadText(String salesLeadText) {
        this.salesLeadText = salesLeadText;
    }

    public Integer getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(Integer taxFlag) {
        this.taxFlag = taxFlag;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUseInstructions() {
        return useInstructions;
    }

    public void setUseInstructions(String useInstructions) {
        this.useInstructions = useInstructions;
    }

    public String getSpecificTerms() {
        return specificTerms;
    }

    public void setSpecificTerms(String specificTerms) {
        this.specificTerms = specificTerms;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    public String getMarkInfo() {
        return markInfo;
    }

    public void setMarkInfo(String markInfo) {
        this.markInfo = markInfo;
    }

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Integer getIssueFlag() {
        return issueFlag;
    }

    public void setIssueFlag(Integer issueFlag) {
        this.issueFlag = issueFlag;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getChargePersonId() {
        return chargePersonId;
    }

    public void setChargePersonId(String chargePersonId) {
        this.chargePersonId = chargePersonId;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public Integer getChargeFlag() {
        return chargeFlag;
    }

    public void setChargeFlag(Integer chargeFlag) {
        this.chargeFlag = chargeFlag;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(String registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public String getRegisterPerson() {
        return registerPerson;
    }

    public void setRegisterPerson(String registerPerson) {
        this.registerPerson = registerPerson;
    }
}
