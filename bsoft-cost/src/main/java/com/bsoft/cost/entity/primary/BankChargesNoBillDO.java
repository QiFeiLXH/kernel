package com.bsoft.cost.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-17 11:10
 * @Version 1.0
 * @Description 对公费用，中标服务费 未收到发票  待办列表
 */
@Entity
@Table(name="KER_BANKCHARGS_NOBILL_VIEW")
public class BankChargesNoBillDO {
    private Integer id;//主键ID
    private String applicant;//申请人工号  sqgh
    private String applicantName;//申请人姓名
    private String collectionUnit;//收款单位 skdw
    private Double authorizedAmount;//核准金额  shje
    private Date applicantTime;//申请时间 sqsj
    private Date paymentTime;//发放时间 ffsj
    private String department;//归属部门 gsbm
    private String attributionItems;//归属项目 gsxm
    private Integer costType;//数据来源 1.对公费用 2.中标服务费
    private String costTypeText;//数据来源 1.对公费用 2.中标服务费
    private Integer billSymbol;//税票标志 spbz
    private Double billAmount;//税票金额 spje
    private Integer paymentSymbol; //发放标志 ffbz
    private Integer category;//费用类别 fylb

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getCollectionUnit() {
        return collectionUnit;
    }

    public void setCollectionUnit(String collectionUnit) {
        this.collectionUnit = collectionUnit;
    }

    public Double getAuthorizedAmount() {
        return authorizedAmount;
    }

    public void setAuthorizedAmount(Double authorizedAmount) {
        this.authorizedAmount = authorizedAmount;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAttributionItems() {
        return attributionItems;
    }

    public void setAttributionItems(String attributionItems) {
        this.attributionItems = attributionItems;
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

    public Integer getBillSymbol() {
        return billSymbol;
    }

    public void setBillSymbol(Integer billSymbol) {
        this.billSymbol = billSymbol;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getPaymentSymbol() {
        return paymentSymbol;
    }

    public void setPaymentSymbol(Integer paymentSymbol) {
        this.paymentSymbol = paymentSymbol;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
