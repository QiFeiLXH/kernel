package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:49
 * @Version 1.0
 * 劳动合同申请
 */
public class LaborContractApplyDTO implements Serializable {
    private Integer id;//主键
    private String personId;//工号
    private Date renewalStartDate;//劳动合同续签开始日期
    private Date renewalEndDate;//劳动合同续签结束日期
    private String remark;//备注
    private Integer areaAudit;//大区审核
    private String areaAuditor;//大区审核人
    private Date areaAuditDate;//大区审核日期
    private Integer hrAudit;//人事审核
    private String hrAuditor;//人事审核人
    private Date hrAuditDate;//人事审核日期
    private String hrOpinion;//人事审核意见
    private Integer deptAudit;//部门审核标志 1.同意 2.不同意
    private String deptAuditor;//部门审核人
    private Date deptAuditDate;//部门审核日期
    private String deptOpinion;//部门审核人意见
    private Integer signUnit;//签订单位
    private String post;//岗位
    private String dept;//部门
    private Date inDate;//入职时间
    private Date endDate;//劳动合同到期时间
    private String evaluationGrade;//年度绩效
    private String sequence;//岗位序列
    private String specialRank;//评定职级
    private String processInstanceId;//流程实例id
    private Integer status;//审核状态 1.审核中 2.已审核
    private Integer renewalYear;//续签年限
    private Integer quitApplyId;//离职申请单
    private Integer renewalFlag;//首续签标志
    private String dealPerson;//经办人
    private Date dealDate;//经办人办理日期

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAreaAudit() {
        return areaAudit;
    }

    public void setAreaAudit(Integer areaAudit) {
        this.areaAudit = areaAudit;
    }

    public String getAreaAuditor() {
        return areaAuditor;
    }

    public void setAreaAuditor(String areaAuditor) {
        this.areaAuditor = areaAuditor;
    }

    public Date getAreaAuditDate() {
        return areaAuditDate;
    }

    public void setAreaAuditDate(Date areaAuditDate) {
        this.areaAuditDate = areaAuditDate;
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

    public Integer getSignUnit() {
        return signUnit;
    }

    public void setSignUnit(Integer signUnit) {
        this.signUnit = signUnit;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(String specialRank) {
        this.specialRank = specialRank;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRenewalYear() {
        return renewalYear;
    }

    public void setRenewalYear(Integer renewalYear) {
        this.renewalYear = renewalYear;
    }

    public Integer getQuitApplyId() {
        return quitApplyId;
    }

    public void setQuitApplyId(Integer quitApplyId) {
        this.quitApplyId = quitApplyId;
    }

    public Integer getRenewalFlag() {
        return renewalFlag;
    }

    public void setRenewalFlag(Integer renewalFlag) {
        this.renewalFlag = renewalFlag;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }
}
