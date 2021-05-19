package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-17 11:33
 * @Version 1.0
 * @Description 保证金 履约保证金 待办列表
 */
@Entity
@Table(name="KER_BOND_INFO_VIEW")
public class BondInfoDO {
    private String id; // 主键id  jkpz
    private String payee;//领款人 lkr
    private String payeeName;//领款人姓名
    private String collectionUnit;//收款单位 skdw
    private Date applicantTime;//申请时间 sqrq
    private Double bond;//保证金 sqje
    private Double performanceBond; //履约保证金 lybzj
    private Date paymentTime;//发放时间 ffsj
    private Date estimatedRefundTime;// 预计退款时间 yjtksj
    private Integer performanceSymbol;//履约标志
    private Integer overdueDays;//逾期天数

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getCollectionUnit() {
        return collectionUnit;
    }

    public void setCollectionUnit(String collectionUnit) {
        this.collectionUnit = collectionUnit;
    }

    public Date getApplicantTime() {
        return applicantTime;
    }

    public void setApplicantTime(Date applicantTime) {
        this.applicantTime = applicantTime;
    }

    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }

    public Double getPerformanceBond() {
        return performanceBond;
    }

    public void setPerformanceBond(Double performanceBond) {
        this.performanceBond = performanceBond;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getEstimatedRefundTime() {
        return estimatedRefundTime;
    }

    public void setEstimatedRefundTime(Date estimatedRefundTime) {
        this.estimatedRefundTime = estimatedRefundTime;
    }

    public Integer getPerformanceSymbol() {
        return performanceSymbol;
    }

    public void setPerformanceSymbol(Integer performanceSymbol) {
        this.performanceSymbol = performanceSymbol;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }
}
