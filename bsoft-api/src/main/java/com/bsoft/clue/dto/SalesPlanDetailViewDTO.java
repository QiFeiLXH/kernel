package com.bsoft.clue.dto;

import java.io.Serializable;
import java.util.Date;

public class SalesPlanDetailViewDTO  implements Serializable {
    private Integer id;//计划Id
    private String customerName;//客户名称
    private String salesArea;//销售区域
    private String type;//客户分类
    private String customerStatus;//客户状态
    private String hospitalLevel;//医院等级
    private String baseInfo;//基本信息
    private String newFlag;//新老客户
    private Integer bigCustomerFlag;//大客户标志
    private String province;//省份
    private String productContent;//产品内容
    private String cluesNature;//线索性质
    private String trackPerson;//跟单人
    private String trackDept;//跟单部门
    private String competitor;//竞争对手
    private String cluesSource;//线索来源
    private String entryStage;//切入阶段
    private String salesStage;//销售阶段
    private String remarkInfo;//切入说明
    private Double softwareAmount;//预计软件额
    private Double firstAmount;//预计首款额
    private Double hardwareAmount;//预计硬件额
    private Double estimateNetSales;//预计净软件额
    private Double systemSoftwareAmount;//预计系统软件额
    private Date signDate;//预计签约日期
    private Double signProbability;//预计签约概率
    private String biddingDate;//投标日期
    private Integer biddingFlag;//招投标标志
    private Date trackDate;//跟单日期
    private String trackInfo;//跟单情况

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesArea() {
        return salesArea;
    }

    public void setSalesArea(String salesArea) {
        this.salesArea = salesArea;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public Integer getBigCustomerFlag() {
        return bigCustomerFlag;
    }

    public void setBigCustomerFlag(Integer bigCustomerFlag) {
        this.bigCustomerFlag = bigCustomerFlag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
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

    public String getTrackDept() {
        return trackDept;
    }

    public void setTrackDept(String trackDept) {
        this.trackDept = trackDept;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getEntryStage() {
        return entryStage;
    }

    public void setEntryStage(String entryStage) {
        this.entryStage = entryStage;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
    }

    public Double getSoftwareAmount() {
        return softwareAmount;
    }

    public void setSoftwareAmount(Double softwareAmount) {
        this.softwareAmount = softwareAmount;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getHardwareAmount() {
        return hardwareAmount;
    }

    public void setHardwareAmount(Double hardwareAmount) {
        this.hardwareAmount = hardwareAmount;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }

    public Double getSystemSoftwareAmount() {
        return systemSoftwareAmount;
    }

    public void setSystemSoftwareAmount(Double systemSoftwareAmount) {
        this.systemSoftwareAmount = systemSoftwareAmount;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Double getSignProbability() {
        return signProbability;
    }

    public void setSignProbability(Double signProbability) {
        this.signProbability = signProbability;
    }

    public String getBiddingDate() {
        return biddingDate;
    }

    public void setBiddingDate(String biddingDate) {
        this.biddingDate = biddingDate;
    }

    public Integer getBiddingFlag() {
        return biddingFlag;
    }

    public void setBiddingFlag(Integer biddingFlag) {
        this.biddingFlag = biddingFlag;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public String getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(String trackInfo) {
        this.trackInfo = trackInfo;
    }
}
