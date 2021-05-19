package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 17:36
 * @Version 1.0
 * 劳动合同记录
 */
@Entity
@Table(name="BSOFTMIS.T_LDHT")
public class LaborContractDO {

    private Integer id;//主键
    private String personId;//工号
    private Date renewalStartDate;//劳动合同续签开始日期
    private Date renewalEndDate;//劳动合同续签结束日期
    private String remark;//备注
    private String dealPerson;//经办人
    private Date registerDate;//登记日期
    private String Registrant;//登记人
    private Integer renewalFlag;//首续签标志
    private Integer signUnit;//签订单位 htqdd合同签订地
    private Integer applyId;//关联合同申请id

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name="qsrq")
    public Date getRenewalStartDate() {
        return renewalStartDate;
    }

    public void setRenewalStartDate(Date renewalStartDate) {
        this.renewalStartDate = renewalStartDate;
    }

    @Column(name="zzrq")
    public Date getRenewalEndDate() {
        return renewalEndDate;
    }

    public void setRenewalEndDate(Date renewalEndDate) {
        this.renewalEndDate = renewalEndDate;
    }

    @Column(name="bz")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name="qdry")
    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    @Column(name="djsj")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name="djry")
    public String getRegistrant() {
        return Registrant;
    }

    public void setRegistrant(String registrant) {
        Registrant = registrant;
    }

    @Column(name="sxq")
    public Integer getRenewalFlag() {
        return renewalFlag;
    }

    public void setRenewalFlag(Integer renewalFlag) {
        this.renewalFlag = renewalFlag;
    }

    @Column(name="htqdd")
    public Integer getSignUnit() {
        return signUnit;
    }

    public void setSignUnit(Integer signUnit) {
        this.signUnit = signUnit;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }
}
