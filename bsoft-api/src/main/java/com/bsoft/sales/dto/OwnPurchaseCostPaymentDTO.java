package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/9 17:31
 * @Description 公司采购合同费用支付
 */
public class OwnPurchaseCostPaymentDTO implements Serializable {
    private Integer id;
    /** 款项 */
    private Integer paymentAccount;
    private String paymentAccountText;
    /** 申请日期 */
    private Date applyDate;
    /** 申请金额 */
    private Double applyAmount;
    /** 核算部门 */
    private String checkDept;
    private String checkDeptName;
    /** 申请人 */
    private String applyer;
    private String applerName;
    /** 归属人 */
    private String belonger;
    private String belongerName;
    /** 发放日期 */
    private Date issueDate;
    /** 税票标志 */
    private Integer taxFlag;
    /** 采购合同号 */
    private String purchaseContractNo;
    /** 项目id */
    private String projectId;
    /** 项目名称 */
    private String projectName;
    /** 核算口径 */
    private Integer accountCaliber;
    private String accountCaliberText;
    /** 对方单位 */
    private Integer suppliers;
    private String suppliersText;
    /** 备注 */
    private String remark;
    /** 税票金额 */
    private Double taxAmount;
    /** 发票代码 */
    private String invoiceCode;
    /** 发票号 */
    private String invoiceNum;
    /** 发票类型 */
    private Integer invoiceType;
    private String invoiceTypeText;
    /** 登记人 */
    private String registerPersonId;
    private String registerPersonName;
    /** 凭证号 */
    private String voucher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(Integer paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getPaymentAccountText() {
        return paymentAccountText;
    }

    public void setPaymentAccountText(String paymentAccountText) {
        this.paymentAccountText = paymentAccountText;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getCheckDept() {
        return checkDept;
    }

    public void setCheckDept(String checkDept) {
        this.checkDept = checkDept;
    }

    public String getCheckDeptName() {
        return checkDeptName;
    }

    public void setCheckDeptName(String checkDeptName) {
        this.checkDeptName = checkDeptName;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplerName() {
        return applerName;
    }

    public void setApplerName(String applerName) {
        this.applerName = applerName;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(Integer taxFlag) {
        this.taxFlag = taxFlag;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
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

    public Integer getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Integer suppliers) {
        this.suppliers = suppliers;
    }

    public String getSuppliersText() {
        return suppliersText;
    }

    public void setSuppliersText(String suppliersText) {
        this.suppliersText = suppliersText;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTypeText() {
        return invoiceTypeText;
    }

    public void setInvoiceTypeText(String invoiceTypeText) {
        this.invoiceTypeText = invoiceTypeText;
    }

    public String getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(String registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public String getRegisterPersonName() {
        return registerPersonName;
    }

    public void setRegisterPersonName(String registerPersonName) {
        this.registerPersonName = registerPersonName;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
