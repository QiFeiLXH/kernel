package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 9:52
 * @Description
 */
public class InvoiceRecordDTO implements Serializable {
    private Integer id;
    /** 申请部门id */
    private String applyDeptId;
    /** 申请部门名称 */
    private String applyDeptName;
    /** 合同号 */
    private String contractNo;
    /** 客户id */
    private String customerId;
    /** 客户名称 */
    private String customerName;
    /** 客户名称拼音 */
    private String customerSimpleCode;
    /** 开票单位id */
    private String invoiceUnitId;
    /** 开票单位名称 */
    private String invoiceUnitName;
    /** 开票单位税号 */
    private String invoiceTaxNo;
    /** 开票单位地址 */
    private String invoiceAddress;
    /** 开票单位电话 */
    private String invoicePhone;
    /** 开票单位开户行 */
    private String invoiceOpeningBank;
    /** 开票单位账号 */
    private String invoiceBankAccount;
    /** 分公司id */
    private Integer companyId;
    /** 分公司名称 */
    private String companyName;
    /** 开户行 */
    private String openingBank;
    /** 银行账号 */
    private String bankAccount;
    /** 公司税号 */
    private String companyTaxNo;
    /** 公司地址 */
    private String address;
    /** 公司电话 */
    private String phone;
    /** 票据金额 */
    private Double invoiceAmount;
    /** 税率 */
    private Double taxRate;
    /** 开票人id */
    private String issuerId;
    /** 开票人姓名 */
    private String issuerName;
    /** 开票日期 */
    private Date invoiceDate;
    /** 领票人id */
    private String ticketHolderId;
    /** 领票人姓名 */
    private String ticketHolder;
    /** 流水号id */
    private String lshid;
    /** 发票pdfid */
    private Integer invoicePdfID;
    /** 发票pdf url */
    private String invoicePdfUrl;
    /** 发票类别 */
    private Integer invoiceType;
    private String invoiceTypeText;
    /** 付款款项 */
    private Integer paymentItem;
    private String paymentItemText;
    /** 款项类别 */
    private Integer noteCategory;
    private String noteCategoryText;
    /** 发票款项 */
    private Integer invoiceItem;
    private String invoiceItemText;
    /** 签约单位id */
    private Integer contractUnitId;
    /** 签约单位名称 */
    private String contractUnitName;
    /** 备注 */
    private String mark;
    /** 申请日期 */
    private Date applyDate;
    /** 领票标志 */
    private Integer acceptFlag;
    /** 开票标志 */
    private Integer invoiceFlag;
    /** 申请人 */
    private String applyer;
    private String applyerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(String applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInvoiceUnitId() {
        return invoiceUnitId;
    }

    public void setInvoiceUnitId(String invoiceUnitId) {
        this.invoiceUnitId = invoiceUnitId;
    }

    public String getInvoiceUnitName() {
        return invoiceUnitName;
    }

    public void setInvoiceUnitName(String invoiceUnitName) {
        this.invoiceUnitName = invoiceUnitName;
    }

    public String getInvoiceTaxNo() {
        return invoiceTaxNo;
    }

    public void setInvoiceTaxNo(String invoiceTaxNo) {
        this.invoiceTaxNo = invoiceTaxNo;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getInvoicePhone() {
        return invoicePhone;
    }

    public void setInvoicePhone(String invoicePhone) {
        this.invoicePhone = invoicePhone;
    }

    public String getInvoiceOpeningBank() {
        return invoiceOpeningBank;
    }

    public void setInvoiceOpeningBank(String invoiceOpeningBank) {
        this.invoiceOpeningBank = invoiceOpeningBank;
    }

    public String getInvoiceBankAccount() {
        return invoiceBankAccount;
    }

    public void setInvoiceBankAccount(String invoiceBankAccount) {
        this.invoiceBankAccount = invoiceBankAccount;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCompanyTaxNo() {
        return companyTaxNo;
    }

    public void setCompanyTaxNo(String companyTaxNo) {
        this.companyTaxNo = companyTaxNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getTicketHolderId() {
        return ticketHolderId;
    }

    public void setTicketHolderId(String ticketHolderId) {
        this.ticketHolderId = ticketHolderId;
    }

    public String getTicketHolder() {
        return ticketHolder;
    }

    public void setTicketHolder(String ticketHolder) {
        this.ticketHolder = ticketHolder;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getInvoicePdfID() {
        return invoicePdfID;
    }

    public void setInvoicePdfID(Integer invoicePdfID) {
        this.invoicePdfID = invoicePdfID;
    }

    public String getInvoicePdfUrl() {
        return invoicePdfUrl;
    }

    public void setInvoicePdfUrl(String invoicePdfUrl) {
        this.invoicePdfUrl = invoicePdfUrl;
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

    public Integer getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(Integer paymentItem) {
        this.paymentItem = paymentItem;
    }

    public String getPaymentItemText() {
        return paymentItemText;
    }

    public void setPaymentItemText(String paymentItemText) {
        this.paymentItemText = paymentItemText;
    }

    public Integer getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(Integer noteCategory) {
        this.noteCategory = noteCategory;
    }

    public String getNoteCategoryText() {
        return noteCategoryText;
    }

    public void setNoteCategoryText(String noteCategoryText) {
        this.noteCategoryText = noteCategoryText;
    }

    public Integer getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(Integer invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public String getInvoiceItemText() {
        return invoiceItemText;
    }

    public void setInvoiceItemText(String invoiceItemText) {
        this.invoiceItemText = invoiceItemText;
    }

    public Integer getContractUnitId() {
        return contractUnitId;
    }

    public void setContractUnitId(Integer contractUnitId) {
        this.contractUnitId = contractUnitId;
    }

    public String getContractUnitName() {
        return contractUnitName;
    }

    public void setContractUnitName(String contractUnitName) {
        this.contractUnitName = contractUnitName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getAcceptFlag() {
        return acceptFlag;
    }

    public void setAcceptFlag(Integer acceptFlag) {
        this.acceptFlag = acceptFlag;
    }

    public Integer getInvoiceFlag() {
        return invoiceFlag;
    }

    public void setInvoiceFlag(Integer invoiceFlag) {
        this.invoiceFlag = invoiceFlag;
    }

    public String getCustomerSimpleCode() {
        return customerSimpleCode;
    }

    public void setCustomerSimpleCode(String customerSimpleCode) {
        this.customerSimpleCode = customerSimpleCode;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }
}
