package com.bsoft.sales.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 9:26
 * @Description: 销售提成
 */
@Entity
@Table(name = "bsoftmis.KH_HTTC")
public class SalesCommisDO {
    private Integer id;
    private String htbh;
    //销售人员
    private String salesMan;
    //归属部门
    private String departMent;
    //有效合同额
    private Double contractAmount;
    //提成有效期
    private Date expiryDate;
    //登记人员
    private String registrant;
    //登记日期
    private Date registrantDate;
    //备注说明
    @Length(max = 65,message = "备注说明不能超过65位")
    private String remarks;
    //可提成总额
    private Double totalRoyalty;
    //销售费用
    private Double sellingExpenses;
    //提奖标志
    private Integer commissionValidFlag;
    //回款有效
    private Integer paymentValid;
    //已提总额
    private Double totalCommission;
    //业绩分配
    private Integer distributionFlag;
    //审核标志
    private Integer auditFlag;
    //审核人员
    private String auditor;
    //审核日期
    private Date auditDate;
    //核算口径归属
    private Integer accountingCaliber;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "htbh")
    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    @Column(name = "xsry")
    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    @Column(name = "gsbm")
    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    @Column(name = "yxhte")
    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    @Column(name = "tcyxq")
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Column(name = "djry")
    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    @Column(name = "djrq")
    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    @Column(name = "bz")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Column(name = "ktcze")
    public Double getTotalRoyalty() {
        return totalRoyalty;
    }

    public void setTotalRoyalty(Double totalRoyalty) {
        this.totalRoyalty = totalRoyalty;
    }

    @Column(name = "kyfye")
    public Double getSellingExpenses() {
        return sellingExpenses;
    }

    public void setSellingExpenses(Double sellingExpenses) {
        this.sellingExpenses = sellingExpenses;
    }

    @Column(name = "tcyxbz")
    public Integer getCommissionValidFlag() {
        return commissionValidFlag;
    }

    public void setCommissionValidFlag(Integer commissionValidFlag) {
        this.commissionValidFlag = commissionValidFlag;
    }

    @Column(name = "hkyx")
    public Integer getPaymentValid() {
        return paymentValid;
    }

    public void setPaymentValid(Integer paymentValid) {
        this.paymentValid = paymentValid;
    }

    @Column(name = "ytze")
    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    @Column(name = "fpbz")
    public Integer getDistributionFlag() {
        return distributionFlag;
    }

    public void setDistributionFlag(Integer distributionFlag) {
        this.distributionFlag = distributionFlag;
    }

    @Column(name = "shbz")
    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    @Column(name = "shry")
    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    @Column(name = "shrq")
    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    @Column(name = "hskjgs")
    public Integer getAccountingCaliber() {
        return accountingCaliber;
    }

    public void setAccountingCaliber(Integer accountingCaliber) {
        this.accountingCaliber = accountingCaliber;
    }
}
