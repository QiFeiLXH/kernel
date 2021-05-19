package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/24
 * @description
 */
public class LaborContractDetailViewDTO implements Serializable {
    /** 主键*/
    private Integer id;
    /** 工号*/
    private String personId;
    /** 姓名*/
    private String personName;

    /**首续签标志0首签1续签*/
    private Integer renewalFlag;
    /**试用开始日期*/
    private Date trialStartDate;
    /**试用结束日期*/
    private Date trialEndDate;
    /** 续签年限*/
    private Integer renewalYear;
    /** 劳动合同续签开始日期*/
    private Date renewalStartDate;
    /** 劳动合同续签结束日期*/
    private Date renewalEndDate;

    /** 部门审核标志 1.同意 2.不同意*/
    private Integer deptAudit;
    /** 部门审核人*/
    private String deptAuditor;
    /** 部门审核人*/
    private String deptAuditorName;
    /** 部门审核日期*/
    private Date deptAuditDate;
    /** 部门审核人意见*/
    private String deptOpinion;

    /** 签订单位*/
    private String signUnit;
    /** 签订单位*/
    private String signUnitName;
    /** 经办人*/
    private String dealPerson;
    /** 经办人姓名*/
    private String dealPersonName;
    /** 经办时间*/
    private Date dealDate;
    /** 备注*/
    private String remark;

    /** 人事审核*/
    private Integer hrAudit;
    /** 人事审核人*/
    private String hrAuditor;
    /** 人事审核人*/
    private String hrAuditorName;
    /** 人事审核日期*/
    private Date hrAuditDate;
    /** 人事审核意见*/
    private String hrOpinion;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getRenewalYear() {
        return renewalYear;
    }

    public void setRenewalYear(Integer renewalYear) {
        this.renewalYear = renewalYear;
    }

    public Date getRenewalStartDate() {
        return renewalStartDate;
    }

    public void setRenewalStartDate(Date renewalStartDate) {
        this.renewalStartDate = renewalStartDate;
    }

    public Date getRenewalEndDate() {
        return renewalEndDate;
    }

    public void setRenewalEndDate(Date renewalEndDate) {
        this.renewalEndDate = renewalEndDate;
    }

    public String getSignUnit() {
        return signUnit;
    }

    public void setSignUnit(String signUnit) {
        this.signUnit = signUnit;
    }

    public String getSignUnitName() {
        return signUnitName;
    }

    public void setSignUnitName(String signUnitName) {
        this.signUnitName = signUnitName;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public String getDealPersonName() {
        return dealPersonName;
    }

    public void setDealPersonName(String dealPersonName) {
        this.dealPersonName = dealPersonName;
    }

    public Integer getDeptAudit() {
        return deptAudit;
    }

    public void setDeptAudit(Integer deptAudit) {
        this.deptAudit = deptAudit;
    }

    public String getDeptAuditor() {
        return deptAuditor;
    }

    public void setDeptAuditor(String deptAuditor) {
        this.deptAuditor = deptAuditor;
    }

    public Date getDeptAuditDate() {
        return deptAuditDate;
    }

    public void setDeptAuditDate(Date deptAuditDate) {
        this.deptAuditDate = deptAuditDate;
    }

    public String getDeptOpinion() {
        return deptOpinion;
    }

    public void setDeptOpinion(String deptOpinion) {
        this.deptOpinion = deptOpinion;
    }

    public Integer getHrAudit() {
        return hrAudit;
    }

    public void setHrAudit(Integer hrAudit) {
        this.hrAudit = hrAudit;
    }

    public String getHrAuditor() {
        return hrAuditor;
    }

    public void setHrAuditor(String hrAuditor) {
        this.hrAuditor = hrAuditor;
    }

    public Date getHrAuditDate() {
        return hrAuditDate;
    }

    public void setHrAuditDate(Date hrAuditDate) {
        this.hrAuditDate = hrAuditDate;
    }

    public String getHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(String hrOpinion) {
        this.hrOpinion = hrOpinion;
    }

    public String getDeptAuditorName() {
        return deptAuditorName;
    }

    public void setDeptAuditorName(String deptAuditorName) {
        this.deptAuditorName = deptAuditorName;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHrAuditorName() {
        return hrAuditorName;
    }

    public void setHrAuditorName(String hrAuditorName) {
        this.hrAuditorName = hrAuditorName;
    }

    public Integer getRenewalFlag() {
        return renewalFlag;
    }

    public void setRenewalFlag(Integer renewalFlag) {
        this.renewalFlag = renewalFlag;
    }

    public Date getTrialStartDate() {
        return trialStartDate;
    }

    public void setTrialStartDate(Date trialStartDate) {
        this.trialStartDate = trialStartDate;
    }

    public Date getTrialEndDate() {
        return trialEndDate;
    }

    public void setTrialEndDate(Date trialEndDate) {
        this.trialEndDate = trialEndDate;
    }
}
