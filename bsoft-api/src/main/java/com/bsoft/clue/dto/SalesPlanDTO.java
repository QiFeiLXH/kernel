package com.bsoft.clue.dto;

import java.io.Serializable;
import java.util.Date;

public class SalesPlanDTO implements Serializable {
    private Integer id;//主键
    private String customer;//客户编码
    private String customerName;//客户名称
    private String content;//产品内容 项目内容
    private Double estimateSoftware;//预计软件额
    private Double estimateNetSales;//预计净销售额软件
    private Double estimateHardware;//预计硬件额
    private String estimateMonth;//预计月份
    private Integer status;//状态 1.审核中 2.已审核
    private String trackPerson;//跟单人
    private String trackPersonName;//跟单人姓名
    private String trackDept;//跟单部门
    private String trackDeptName;//跟单部门名称
    private Integer clueId;//线索编号
    private String businessBelong;//业务归属
    private String stage;//项目阶段
    private String cluesNature;//线索性质
    private String cluesSource;//线索来源
    private String planSource;//线索来源
    private String latestDevelopment;//最新进展
    private String openingDate;//开标时间
    private Date reportDate;//上报日期
    private String processInstanceId;//流程实例id
    private Date planDate;//计划日期
    private Date trackDate;//跟单日期
    private String salesStage;//销售阶段
    private Double signProbability;//签约概率
    private Date signDate;//预计签约日期
    private Double estimateFirstAmount;//预计首款额
    private Double estimateSysSoftware;//预计系统软件额
    private String remarkInfo;//切入说明

    /** 计划月份（用于导入导出）*/
    private String planDateStr;
    /** 预计签约时间（用于导入导出）*/
    private String signDateStr;
    /** 预计软件额（用于导入导出）*/
    private String estimateSoftwareStr;
    /** 预计净销售额软件（用于导入导出）*/
    private String estimateNetSalesStr;
    /** 预计硬件额（用于导入导出）*/
    private String estimateHardwareStr;
    /** 导入失败原因（用于导入导出）*/
    private String failReason;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getEstimateSoftware() {
        return estimateSoftware;
    }

    public void setEstimateSoftware(Double estimateSoftware) {
        this.estimateSoftware = estimateSoftware;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }

    public Double getEstimateHardware() {
        return estimateHardware;
    }

    public void setEstimateHardware(Double estimateHardware) {
        this.estimateHardware = estimateHardware;
    }

    public String getEstimateMonth() {
        return estimateMonth;
    }

    public void setEstimateMonth(String estimateMonth) {
        this.estimateMonth = estimateMonth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTrackPerson() {
        return trackPerson;
    }

    public void setTrackPerson(String trackPerson) {
        this.trackPerson = trackPerson;
    }

    public String getTrackDept() {
        return trackDept;
    }

    public void setTrackDept(String trackDept) {
        this.trackDept = trackDept;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getBusinessBelong() {
        return businessBelong;
    }

    public void setBusinessBelong(String businessBelong) {
        this.businessBelong = businessBelong;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCluesNature() {
        return cluesNature;
    }

    public void setCluesNature(String cluesNature) {
        this.cluesNature = cluesNature;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getPlanSource() {
        return planSource;
    }

    public void setPlanSource(String planSource) {
        this.planSource = planSource;
    }

    public String getLatestDevelopment() {
        return latestDevelopment;
    }

    public void setLatestDevelopment(String latestDevelopment) {
        this.latestDevelopment = latestDevelopment;
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

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTrackPersonName() {
        return trackPersonName;
    }

    public void setTrackPersonName(String trackPersonName) {
        this.trackPersonName = trackPersonName;
    }

    public String getTrackDeptName() {
        return trackDeptName;
    }

    public void setTrackDeptName(String trackDeptName) {
        this.trackDeptName = trackDeptName;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public Double getSignProbability() {
        return signProbability;
    }

    public void setSignProbability(Double signProbability) {
        this.signProbability = signProbability;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Double getEstimateFirstAmount() {
        return estimateFirstAmount;
    }

    public void setEstimateFirstAmount(Double estimateFirstAmount) {
        this.estimateFirstAmount = estimateFirstAmount;
    }

    public Double getEstimateSysSoftware() {
        return estimateSysSoftware;
    }

    public void setEstimateSysSoftware(Double estimateSysSoftware) {
        this.estimateSysSoftware = estimateSysSoftware;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
    }

    public String getPlanDateStr() {
        return planDateStr;
    }

    public void setPlanDateStr(String planDateStr) {
        this.planDateStr = planDateStr;
    }

    public String getSignDateStr() {
        return signDateStr;
    }

    public void setSignDateStr(String signDateStr) {
        this.signDateStr = signDateStr;
    }

    public String getEstimateSoftwareStr() {
        return estimateSoftwareStr;
    }

    public void setEstimateSoftwareStr(String estimateSoftwareStr) {
        this.estimateSoftwareStr = estimateSoftwareStr;
    }

    public String getEstimateNetSalesStr() {
        return estimateNetSalesStr;
    }

    public void setEstimateNetSalesStr(String estimateNetSalesStr) {
        this.estimateNetSalesStr = estimateNetSalesStr;
    }

    public String getEstimateHardwareStr() {
        return estimateHardwareStr;
    }

    public void setEstimateHardwareStr(String estimateHardwareStr) {
        this.estimateHardwareStr = estimateHardwareStr;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
