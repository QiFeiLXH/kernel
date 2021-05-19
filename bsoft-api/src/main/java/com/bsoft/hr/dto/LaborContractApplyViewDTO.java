package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 15:51
 * @Version 1.0
 * 劳动合同续签申请视图
 */
public class LaborContractApplyViewDTO implements Serializable {
    private Integer id;//主键
    private String personId;//工号
    private Date renewalStartDate;//劳动合同续签开始日期
    private Date renewalEndDate;//劳动合同续签结束日期
    private String remark;//备注
    private Integer areaAudit;//大区审核
    private String areaAuditor;//大区审核人
    private String areaAuditorName;//大区审核人姓名
    private Date areaAuditDate;//大区审核日期
    private Integer hrAudit;//人事审核
    private String hrAuditor;//人事审核人
    private String hrAuditorName;//人事审核人姓名
    private Date hrAuditDate;//人事审核日期
    private String hrOpinion;//人事审核意见
    private Integer deptAudit;//部门审核标志 1.同意 2.不同意
    private String deptAuditor;//部门审核人
    private String deptAuditorName;//部门审核人姓名
    private Date deptAuditDate;//部门审核日期
    private String deptOpinion;//部门审核人意见
    private String personName;//姓名
    private Integer signUnit;//签订单位
    private String signUnitName;//签订单位名称
    private String post;//岗位
    private String dept;//部门
    private Date inDate;//入职时间
    private Date endDate;//劳动合同到期时间
    private Integer monthDiffer;//当前时间与到期时间 相差月份数
    private String evaluationGrade;//年度绩效
    private String sequence;//岗位序列
    private String specialRank;//评定职级
    private String processInstanceId;//流程实例id
    private Integer status;//审核状态 1.审核中 2.已审核
    private Integer quitApplyId;//离职申请单
    private String quitApplyName;//离职申请单名称
    private Integer renewalYear;//续签年限
    private String taskId;//任务id
    private Boolean readFlag;//是否已读
    private String taskDefineKey;//任务节点key
    /**是否是知会*/
    private Integer notifyFlag;
    /**经办人*/
    private String dealPerson;
    /** 经办人姓名*/
    private String dealPersonName;
    /** 经办人姓名*/
    private String dealDate;


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

    public String getAreaAuditorName() {
        return areaAuditorName;
    }

    public void setAreaAuditorName(String areaAuditorName) {
        this.areaAuditorName = areaAuditorName;
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

    public String getHrAuditorName() {
        return hrAuditorName;
    }

    public void setHrAuditorName(String hrAuditorName) {
        this.hrAuditorName = hrAuditorName;
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

    public String getDeptAuditorName() {
        return deptAuditorName;
    }

    public void setDeptAuditorName(String deptAuditorName) {
        this.deptAuditorName = deptAuditorName;
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public Integer getQuitApplyId() {
        return quitApplyId;
    }

    public void setQuitApplyId(Integer quitApplyId) {
        this.quitApplyId = quitApplyId;
    }
    
    public Integer getRenewalYear() {
        return renewalYear;
    }

    public void setRenewalYear(Integer renewalYear) {
        this.renewalYear = renewalYear;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getTaskDefineKey() {
        return taskDefineKey;
    }

    public void setTaskDefineKey(String taskDefineKey) {
        this.taskDefineKey = taskDefineKey;
    }

    public Integer getNotifyFlag() {
        return notifyFlag;
    }

    public void setNotifyFlag(Integer notifyFlag) {
        this.notifyFlag = notifyFlag;
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

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public Integer getMonthDiffer() {
        return monthDiffer;
    }

    public void setMonthDiffer(Integer monthDiffer) {
        this.monthDiffer = monthDiffer;
    }

    public String getQuitApplyName() {
        return quitApplyName;
    }

    public void setQuitApplyName(String quitApplyName) {
        this.quitApplyName = quitApplyName;
    }
}
