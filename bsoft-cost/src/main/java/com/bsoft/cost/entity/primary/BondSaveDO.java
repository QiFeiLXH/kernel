package com.bsoft.cost.entity.primary;

import javax.persistence.Column;
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
@Table(name="BSOFTMIS.T_BMJK")
public class BondSaveDO {
    private String id; // 主键id  jkpz
    private String accountInfo;//账户情况信息
    private Integer loanType; //借款类别
    private Integer paymentSymbol; //发放标志
    private Integer writeOffSymbol; //冲账标志
    private Date estimatedRefundTime;// 预计退款时间 yjtksj
    private String payee;//领款人
    private Double bond;//申请金额

    @Id
    @Column(name = "jkpz")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Column(name = "jklb")
    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    @Column(name = "ffbz")
    public Integer getPaymentSymbol() {
        return paymentSymbol;
    }

    public void setPaymentSymbol(Integer paymentSymbol) {
        this.paymentSymbol = paymentSymbol;
    }

    @Column(name = "czbz")
    public Integer getWriteOffSymbol() {
        return writeOffSymbol;
    }

    public void setWriteOffSymbol(Integer writeOffSymbol) {
        this.writeOffSymbol = writeOffSymbol;
    }

    @Column(name = "yjtksj")
    public Date getEstimatedRefundTime() {
        return estimatedRefundTime;
    }

    public void setEstimatedRefundTime(Date estimatedRefundTime) {
        this.estimatedRefundTime = estimatedRefundTime;
    }

    @Column(name = "lkr")
    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    @Column(name = "sqje")
    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }
}
