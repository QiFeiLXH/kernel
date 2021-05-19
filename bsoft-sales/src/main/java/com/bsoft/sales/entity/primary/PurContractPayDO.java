package com.bsoft.sales.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 16:06
 * @Description: 支付信息DO
 */
@Entity
@Table(name = "cg_htxx_zfxx")
public class PurContractPayDO {
    private Integer id;
    private String applyer;
    private Date applyDate;
    private String contractNo;
    private String projectid;
    private String accountDept;
    private Integer accountcaliber;
    private String belonger;
    private Integer nature;
    private Integer supplier;
    @Length(max = 150, message = "采购内容长度不能超过150位")
    private String procurementContent;
    private String purchaseContractNo;
    private Double applyAmount;
    @Length(max = 150, message = "备注信息长度不能超过150位")
    private String remarks;
    private Integer taxFlag;
    private Double taxAmount;
    private String invoiceCode;
    private String invoiceNumber;
    private Integer invoiceType;
    private Double taxRate;
    private Integer voucherNo;
    private Integer htid;
    private String registrant;
    private Date registrantDate;

    @Id
    @SequenceGenerator(name="SEQ_CG_HTXX_ZFXX",allocationSize=1,sequenceName="SEQ_CG_HTXX_ZFXX")
    @GeneratedValue(generator="SEQ_CG_HTXX_ZFXX",strategy=GenerationType.SEQUENCE)
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

    public String getAccountDept() {
        return accountDept;
    }

    public void setAccountDept(String accountDept) {
        this.accountDept = accountDept;
    }

    public Integer getAccountcaliber() {
        return accountcaliber;
    }

    public void setAccountcaliber(Integer accountcaliber) {
        this.accountcaliber = accountcaliber;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
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

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }
}
