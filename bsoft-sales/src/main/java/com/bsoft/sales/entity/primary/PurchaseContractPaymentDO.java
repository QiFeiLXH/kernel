package com.bsoft.sales.entity.primary;

import javax.persistence.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 12:07
 * @Description 采购合同付款条件
 */
@Entity
@Table(name="CG_HTXX_FKTJ")
public class PurchaseContractPaymentDO {
    private Integer id;
    /** cg_htxx id */
    private Integer contractId;
    /** 付款科目 */
    private Integer paymentAccount;
    /** 付款金额 */
    private Double payment;
    /** 付款条件 */
    private String remarks;
    /** 变更金额 */
    private Double alterPayment;
    /** 变更类型 */
    private Integer alterType;

    @Id
    @SequenceGenerator(name="SEQ_CG_HTXX_FKTJ",allocationSize=1,sequenceName="SEQ_CG_HTXX_FKTJ")
    @GeneratedValue(generator="SEQ_CG_HTXX_FKTJ",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="htid")
    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(Integer paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getAlterPayment() {
        return alterPayment;
    }

    public void setAlterPayment(Double alterPayment) {
        this.alterPayment = alterPayment;
    }

    public Integer getAlterType() {
        return alterType;
    }

    public void setAlterType(Integer alterType) {
        this.alterType = alterType;
    }
}
