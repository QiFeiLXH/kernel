package com.bsoft.clue.dto;

import java.io.Serializable;
import java.util.Date;

public class SalesPlanViewDTO implements Serializable {
    /** 主键*/
    private Integer id;

    /** 客户编码*/
    private String customer;

    /** 计划月份*/
    private Date planDate;

    /** 客户名称*/
    private String customerName;

    /** 产品内容 项目内容*/
    private String content;

    /** 业务归属*/
    private String businessBelong;

    /** 线索性质*/
    private String cluesNature;

    /** 跟单人*/
    private String trackPerson;

    /** 跟单人姓名*/
    private String trackPersonName;

    /** 跟单部门*/
    private String trackDept;

    /** 跟单部门名称*/
    private String trackDeptName;

    /** 一级部门编号*/
    private String parentDept;

    /** 一级部门名称*/
    private String parentDeptName;

    /** 跟单日期*/
    private Date trackDate;

    /** 最新进展（跟单情况）*/
    private String latestDevelopment;

    /** 线索来源*/
    private String cluesSource;

    /** 项目阶段*/
    private String stage;

    /** 销售阶段*/
    private String salesStage;

    /** 预计软件额*/
    private Double estimateSoftware;

    /** 预计首款额*/
    private Double estimateFirstAmount;

    /** 预计硬件额*/
    private Double estimateHardware;

    /** 预计净销售额软件*/
    private Double estimateNetSales;

    /** 预计系统软件额*/
    private Double estimateSysSoftware;

    /** 预计签约时间*/
    private Date signDate;

    /** 预计月份*/
    private String estimateMonth;

    /** 签约概率*/
    private Double signProbability;

    /** 计划来源*/
    private String planSource;

    /** 开标时间*/
    private String openingDate;

    /** 上报日期*/
    private Date reportDate;

    /** 状态 1.审核中 2.已审核*/
    private Integer status;

    /** 线索编号*/
    private Integer clueId;

    /** 流程实例id*/
    private String processInstanceId;

    /** 已读标志*/
    private Boolean readFlag;

    /** 任务ID*/
    private String taskId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBusinessBelong() {
        return businessBelong;
    }

    public void setBusinessBelong(String businessBelong) {
        this.businessBelong = businessBelong;
    }

    public String getCluesNature() {
        return cluesNature;
    }

    public void setCluesNature(String cluesNature) {
        this.cluesNature = cluesNature;
    }

    public String getTrackPerson() {
        return trackPerson;
    }

    public void setTrackPerson(String trackPerson) {
        this.trackPerson = trackPerson;
    }

    public String getTrackPersonName() {
        return trackPersonName;
    }

    public void setTrackPersonName(String trackPersonName) {
        this.trackPersonName = trackPersonName;
    }

    public String getTrackDept() {
        return trackDept;
    }

    public void setTrackDept(String trackDept) {
        this.trackDept = trackDept;
    }

    public String getTrackDeptName() {
        return trackDeptName;
    }

    public void setTrackDeptName(String trackDeptName) {
        this.trackDeptName = trackDeptName;
    }

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public String getLatestDevelopment() {
        return latestDevelopment;
    }

    public void setLatestDevelopment(String latestDevelopment) {
        this.latestDevelopment = latestDevelopment;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public Double getEstimateSoftware() {
        return estimateSoftware;
    }

    public void setEstimateSoftware(Double estimateSoftware) {
        this.estimateSoftware = estimateSoftware;
    }

    public Double getEstimateFirstAmount() {
        return estimateFirstAmount;
    }

    public void setEstimateFirstAmount(Double estimateFirstAmount) {
        this.estimateFirstAmount = estimateFirstAmount;
    }

    public Double getEstimateHardware() {
        return estimateHardware;
    }

    public void setEstimateHardware(Double estimateHardware) {
        this.estimateHardware = estimateHardware;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }

    public Double getEstimateSysSoftware() {
        return estimateSysSoftware;
    }

    public void setEstimateSysSoftware(Double estimateSysSoftware) {
        this.estimateSysSoftware = estimateSysSoftware;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getEstimateMonth() {
        return estimateMonth;
    }

    public void setEstimateMonth(String estimateMonth) {
        this.estimateMonth = estimateMonth;
    }

    public Double getSignProbability() {
        return signProbability;
    }

    public void setSignProbability(Double signProbability) {
        this.signProbability = signProbability;
    }

    public String getPlanSource() {
        return planSource;
    }

    public void setPlanSource(String planSource) {
        this.planSource = planSource;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
