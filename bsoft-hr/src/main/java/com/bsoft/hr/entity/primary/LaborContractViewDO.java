package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/14
 * @description 劳动合同信息
 */
@Entity
@Table(name = "HR_LABORCONTRACT_VIEW")
public class LaborContractViewDO {
    /** 主键*/
    @Id
    private Integer id;
    /** 工号*/
    private String personId;
    /** 姓名*/
    private String personName;
    /** 部门*/
    private String dept;
    /** 部门名称*/
    private String deptName;
    /** 岗位*/
    private String post;
    /** 岗位名称*/
    private String postName;
    /** 入职时间*/
    private Date inDate;
    /** 到期时间*/
    private Date endDate;
    /** 年度绩效*/
    private String evaluationGrade;
    /** 岗位序列*/
    private String sequence;
    /** 岗位序列名称*/
    private String sequenceName;
    /** 评定职级*/
    private Integer specialRank;
    /** 评定职级名称*/
    private String specialRankName;

    /** 劳动合同续签开始日期*/
    private Date renewalStartDate;
    /** 劳动合同续签结束日期*/
    private Date renewalEndDate;
    /** 签订单位*/
    private Integer signUnit;
    /** 签订单位*/
    private String signUnitName;
    /** 经办人*/
    private String dealPerson;
    /** 经办人姓名*/
    private String dealPersonName;

    /** 首续签标志*/
    private Integer renewalFlag;
    /** 离职标志'0'未离职'1'已离职*/
    private String flag;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(String evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Integer getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(Integer specialRank) {
        this.specialRank = specialRank;
    }

    public String getSpecialRankName() {
        return specialRankName;
    }

    public void setSpecialRankName(String specialRankName) {
        this.specialRankName = specialRankName;
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

    public Integer getSignUnit() {
        return signUnit;
    }

    public void setSignUnit(Integer signUnit) {
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

    public Integer getRenewalFlag() {
        return renewalFlag;
    }

    public void setRenewalFlag(Integer renewalFlag) {
        this.renewalFlag = renewalFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
