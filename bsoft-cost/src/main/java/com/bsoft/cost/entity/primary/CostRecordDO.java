package com.bsoft.cost.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-24 9:45
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name="BSOFTMIS.T_CBJL")
public class CostRecordDO {
    private Integer id;
    private Integer costType;//数据来源 1.对公费用 2.中标服务费 5.第三方采购支付
    private Double approvedAmount; //核准金额 hzje
    private String applicant;//申请人工号  sqgh
    private Integer creditPeriod; //挂账周期 gzzq
    private Integer billSymbol;//税票标志 spbz
    private Double billAmount;//税票金额 spje
    private Integer paymentSymbol; //发放标志 ffbz
    private Integer category;//费用类别 fylb; 5 采购，10外包
    private String accountInfo;//账户情况信息
    private Date paymentTime;//发放时间 ffsj

    private String AccountDept;//核算部门
    private String customerCode;//客户编码
    private String contractNo;//合同编号
    private String contractName;//合同名称
    private String projectId;//归属项目
    private String agentName;//代理商名称
    private Double applyAmount;//申请金额
    private Date applyDate;//申请时间
    private String remarks;//备注
    private String registrant;//登记人
    private Date accountTime;//核算时间
    private Double auditAmount;//核准基恩
    private String belonger;//归属人
    private String payee;//收款单位
    private String paybackUnit;//回款单位
    private Integer costClass;//费用分类
    private Integer accountDetails;//明细科目
    private Integer impersonal;//非个人
    private String applyDept;//申请部门
    private Integer accountCaliber;//核算口径
    private String taxNo;//税票号
    private Date taxReceiptDate;//税票接受时间
    private String taxReceiptReceiver;//税票接受人
    private Integer invoiceType;//发票类别
    private String invoiceCode;//发票代码
    private Integer invoiceID;//发票库ID

    @Column(name = "FPDM")
    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    @Column(name = "FPLB")
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Column(name = "SPJSR")
    public String getTaxReceiptReceiver() {
        return taxReceiptReceiver;
    }

    public void setTaxReceiptReceiver(String taxReceiptReceiver) {
        this.taxReceiptReceiver = taxReceiptReceiver;
    }

    @Column(name = "SPJSSJ")
    public Date getTaxReceiptDate() {
        return taxReceiptDate;
    }

    public void setTaxReceiptDate(Date taxReceiptDate) {
        this.taxReceiptDate = taxReceiptDate;
    }

    @Column(name = "sph")
    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    @Column(name = "HSKJGS")
    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    @Column(name = "DJBM")
    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    @Column(name = "FGR")
    public Integer getImpersonal() {
        return impersonal;
    }

    public void setImpersonal(Integer impersonal) {
        this.impersonal = impersonal;
    }

    @Column(name = "MXKM")
    public Integer getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(Integer accountDetails) {
        this.accountDetails = accountDetails;
    }

    @Column(name = "FYFL")
    public Integer getCostClass() {
        return costClass;
    }

    public void setCostClass(Integer costClass) {
        this.costClass = costClass;
    }

    @Column(name = "HKDW")
    public String getPaybackUnit() {
        return paybackUnit;
    }

    public void setPaybackUnit(String paybackUnit) {
        this.paybackUnit = paybackUnit;
    }

    @Column(name = "SKDW")
    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    @Column(name = "GSGH")
    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    @Column(name = "SHJE")
    public Double getAuditAmount() {
        return auditAmount;
    }

    public void setAuditAmount(Double auditAmount) {
        this.auditAmount = auditAmount;
    }

    @Column(name = "djsj")
    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    @Column(name = "djr")
    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    @Column(name = "bz")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Column(name = "sqsj")
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "sqje")
    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    @Column(name = "dlmc")
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Column(name = "gsxm")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "HTMC")
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    @Column(name = "HTBH")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Column(name = "KHBM")
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Column(name = "SQBM")
    public String getAccountDept() {
        return AccountDept;
    }

    public void setAccountDept(String accountDept) {
        AccountDept = accountDept;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    @Column(name = "hzje")
    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    @Column(name = "sqgh")
    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    @Column(name = "gzzq")
    public Integer getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Integer creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    @Column(name = "spbz")
    public Integer getBillSymbol() {
        return billSymbol;
    }

    public void setBillSymbol(Integer billSymbol) {
        this.billSymbol = billSymbol;
    }

    @Column(name = "spje")
    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    @Column(name = "ffbz")
    public Integer getPaymentSymbol() {
        return paymentSymbol;
    }

    public void setPaymentSymbol(Integer paymentSymbol) {
        this.paymentSymbol = paymentSymbol;
    }

    @Column(name = "fylb")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Column(name="ffsj")
    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }
}
