package com.bsoft.sales.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 13:59
 * @Description: 采购合同支付信息
 */
@Entity
@Table(name = "ker_sales_purchasePay_view")
public class PurContractPayViewDO {
    private Integer id;
    private String applyer;
    private String applyerText;
    private Date applyDate;
    private String contractNo;
    private String projectid;
    private String projectName;
    private String accountDept;
    private String accountDeptText;
    private Integer accountcaliber;
    private String accountcaliberText;
    private String belonger;
    private String belongerText;
    private Integer nature;
    private String natureText;
    private Integer supplier;
    private String supplierText;
    private String procurementContent;
    private String purchaseContractNo;
    private Double applyAmount;
    private String remarks;
    private Integer taxFlag;
    private Double taxAmount;
    private String invoiceCode;
    private String invoiceNumber;
    private Integer invoiceType;
    private String invoiceTypeText;
    private Double taxRate;
    private Integer voucherNo;
    private Integer htid;
    private Integer ffbz;
    private Date ffsj;
    private String registrant;
    private String registrantText;
    private Date registrantDate;
    private Double paidAmount;
    private Double totalAmount;
    private String contractName;
    private Double totalApplyAmount;
    private Integer payee;

    public Integer getPayee() {
        return payee;
    }

    public void setPayee(Integer payee) {
        this.payee = payee;
    }

    public Double getTotalApplyAmount() {
        return totalApplyAmount;
    }

    public void setTotalApplyAmount(Double totalApplyAmount) {
        this.totalApplyAmount = totalApplyAmount;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerText() {
        return applyerText;
    }

    public void setApplyerText(String applyerText) {
        this.applyerText = applyerText;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAccountDept() {
        return accountDept;
    }

    public void setAccountDept(String accountDept) {
        this.accountDept = accountDept;
    }

    public String getAccountDeptText() {
        return accountDeptText;
    }

    public void setAccountDeptText(String accountDeptText) {
        this.accountDeptText = accountDeptText;
    }

    public Integer getAccountcaliber() {
        return accountcaliber;
    }

    public void setAccountcaliber(Integer accountcaliber) {
        this.accountcaliber = accountcaliber;
    }

    public String getAccountcaliberText() {
        return accountcaliberText;
    }

    public void setAccountcaliberText(String accountcaliberText) {
        this.accountcaliberText = accountcaliberText;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public String getBelongerText() {
        return belongerText;
    }

    public void setBelongerText(String belongerText) {
        this.belongerText = belongerText;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getNatureText() {
        return natureText;
    }

    public void setNatureText(String natureText) {
        this.natureText = natureText;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public String getSupplierText() {
        return supplierText;
    }

    public void setSupplierText(String supplierText) {
        this.supplierText = supplierText;
    }

    public String getProcurementContent() {
        return procurementContent;
    }

    public void setProcurementContent(String procurementContent) {
        this.procurementContent = procurementContent;
    }

    public String getPurchaseContractNo() {
        return purchaseContractNo;
    }

    public void setPurchaseContractNo(String purchaseContractNo) {
        this.purchaseContractNo = purchaseContractNo;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(Integer taxFlag) {
        this.taxFlag = taxFlag;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Integer voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getHtid() {
        return htid;
    }

    public void setHtid(Integer htid) {
        this.htid = htid;
    }

    public Integer getFfbz() {
        return ffbz;
    }

    public void setFfbz(Integer ffbz) {
        this.ffbz = ffbz;
    }

    public Date getFfsj() {
        return ffsj;
    }

    public void setFfsj(Date ffsj) {
        this.ffsj = ffsj;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantText() {
        return registrantText;
    }

    public void setRegistrantText(String registrantText) {
        this.registrantText = registrantText;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }
}
