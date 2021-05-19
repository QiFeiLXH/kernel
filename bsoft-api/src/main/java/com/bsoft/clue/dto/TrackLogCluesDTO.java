package com.bsoft.clue.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/26 12:49
 * @Description: 跟单日志的销售线索列表
 */
public class TrackLogCluesDTO implements Serializable {
    private Integer clueId; //线索编号
    private String customerId; //客户编码
    private String area; //市场区域
    private Integer stage; //目前阶段
    private String tracker; //跟单人员
    private Integer status; //线索状态
    private Date signDate; //预计签约时间
    private Date trackDate; //跟踪日期
    private Integer projectFlag; //立项标志
    private Integer closed; //关闭标志
    private String customerName;//客户名称
    private String productContent;//产品内容
    private String areaText;//市场区域名称
    private String statusText;//线索状态名称
    private String stageText;//目前阶段名称
    private String trackerText;//跟单人员姓名
    private Integer flag;//需更新日志标志
    private Integer trackerId; //跟单人员ID
    private Double software;  //预计软件额
    private Double hardware; //预计硬件额
    private Double firstAmount; //预计首款金额
    private Double sysSoftware; //预计系统软件金额
    private Double signChance; //签约概率
    private Integer clueNature; //线索性质
    private String clueNatureText;//线索性质名称

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public Integer getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(Integer projectFlag) {
        this.projectFlag = projectFlag;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStageText() {
        return stageText;
    }

    public void setStageText(String stageText) {
        this.stageText = stageText;
    }

    public String getTrackerText() {
        return trackerText;
    }

    public void setTrackerText(String trackerText) {
        this.trackerText = trackerText;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Integer trackerId) {
        this.trackerId = trackerId;
    }

    public Double getSoftware() {
        return software;
    }

    public void setSoftware(Double software) {
        this.software = software;
    }

    public Double getHardware() {
        return hardware;
    }

    public void setHardware(Double hardware) {
        this.hardware = hardware;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getSysSoftware() {
        return sysSoftware;
    }

    public void setSysSoftware(Double sysSoftware) {
        this.sysSoftware = sysSoftware;
    }

    public Double getSignChance() {
        return signChance;
    }

    public void setSignChance(Double signChance) {
        this.signChance = signChance;
    }

    public Integer getClueNature() {
        return clueNature;
    }

    public void setClueNature(Integer clueNature) {
        this.clueNature = clueNature;
    }

    public String getClueNatureText() {
        return clueNatureText;
    }

    public void setClueNatureText(String clueNatureText) {
        this.clueNatureText = clueNatureText;
    }
}
