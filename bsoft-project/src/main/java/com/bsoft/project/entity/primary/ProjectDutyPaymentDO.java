package com.bsoft.project.entity.primary;

import javax.persistence.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:36
 * @Description 项目责任书-计划回款
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_DUTY_PAYMENT")
public class ProjectDutyPaymentDO {
    private Integer id;
    /** 责任书id */
    private Integer dutyId;
    /** 合同编号 */
    private String contractNo;
    /** 付款方式id */
    private Integer paymentId;
    /** 预计回款 */
    private Integer expected;

    @Id
    @SequenceGenerator(name="SEQ_PRO_DUTY_PAYMENT",allocationSize=1,sequenceName="SEQ_PRO_DUTY_PAYMENT")
    @GeneratedValue(generator="SEQ_PRO_DUTY_PAYMENT",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getExpected() {
        return expected;
    }

    public void setExpected(Integer expected) {
        this.expected = expected;
    }
}
