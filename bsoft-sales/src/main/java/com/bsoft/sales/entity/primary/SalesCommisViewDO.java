package com.bsoft.sales.entity.primary;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:38
 * @Description: 销售提成
 */
public class SalesCommisViewDO {
    private Integer id;
    private String htbh;
    private String contractNo;
    private String contractName;
    //销售人员
    private String salesMan;
    private String salesManText;
    //归属部门
    private String departMent;
    private String departMentText;
    //有效合同额
    private Double contractAmount;
    //提成有效期
    private Date expiryDate;
    //登记人员
    private String registrant;
    private String registrantText;
    //登记日期
    private Date registrantDate;
    //备注说明
    private String remarks;
    //可提成总额
    private Double totalRoyalty;
    //销售费用
    private Double sellingExpenses;
    //提奖标志，提成有效标志
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
    private String auditorText;
    //审核日期
    private Date auditDate;
    //核算口径归属
    private Integer accountingCaliber;
    private String accountingCaliberText;
    private Integer awardMark;//已提奖标志

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
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

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getSalesManText() {
        return salesManText;
    }

    public void setSalesManText(String salesManText) {
        this.salesManText = salesManText;
    }

    public String getDepartMent() {
        return departMent;
    }

    public void setDepartMent(String departMent) {
        this.departMent = departMent;
    }

    public String getDepartMentText() {
        return departMentText;
    }

    public void setDepartMentText(String departMentText) {
        this.departMentText = departMentText;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getTotalRoyalty() {
        return totalRoyalty;
    }

    public void setTotalRoyalty(Double totalRoyalty) {
        this.totalRoyalty = totalRoyalty;
    }

    public Double getSellingExpenses() {
        return sellingExpenses;
    }

    public void setSellingExpenses(Double sellingExpenses) {
        this.sellingExpenses = sellingExpenses;
    }

    public Integer getCommissionValidFlag() {
        return commissionValidFlag;
    }

    public void setCommissionValidFlag(Integer commissionValidFlag) {
        this.commissionValidFlag = commissionValidFlag;
    }

    public Integer getPaymentValid() {
        return paymentValid;
    }

    public void setPaymentValid(Integer paymentValid) {
        this.paymentValid = paymentValid;
    }

    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getDistributionFlag() {
        return distributionFlag;
    }

    public void setDistributionFlag(Integer distributionFlag) {
        this.distributionFlag = distributionFlag;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditorText() {
        return auditorText;
    }

    public void setAuditorText(String auditorText) {
        this.auditorText = auditorText;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAccountingCaliber() {
        return accountingCaliber;
    }

    public void setAccountingCaliber(Integer accountingCaliber) {
        this.accountingCaliber = accountingCaliber;
    }

    public String getAccountingCaliberText() {
        return accountingCaliberText;
    }

    public void setAccountingCaliberText(String accountingCaliberText) {
        this.accountingCaliberText = accountingCaliberText;
    }

    public Integer getAwardMark() {
        return awardMark;
    }

    public void setAwardMark(Integer awardMark) {
        this.awardMark = awardMark;
    }
}
