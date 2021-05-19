package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-05-25 18:07
 * @Version 1.0
 * @Description
 */
public class FinanceCostViewDTO implements Serializable {
    private String projectId; //项目id
    private String projectName; //项目名称
    private String contractNo; //合同号
    private Integer businessCategory; //业务大类
    private String businessCategoryText; //业务大类
    private Integer flag; //项目类别
    private String flagText; //项目类别
    private String area; //工程区域id
    private String areaText; //工程区域
    private Double manpowerCost; //人力成本（1.25）
    private Double hospitality; //招待费
    private Double travelCost; //差旅费
    private Double softwareCost; //软件采购
    private Double other; //其他
    private Date signDate; //签定日期

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Integer businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessCategoryText() {
        return businessCategoryText;
    }

    public void setBusinessCategoryText(String businessCategoryText) {
        this.businessCategoryText = businessCategoryText;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public Double getManpowerCost() {
        return manpowerCost;
    }

    public void setManpowerCost(Double manpowerCost) {
        this.manpowerCost = manpowerCost;
    }

    public Double getHospitality() {
        return hospitality;
    }

    public void setHospitality(Double hospitality) {
        this.hospitality = hospitality;
    }

    public Double getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(Double travelCost) {
        this.travelCost = travelCost;
    }

    public Double getSoftwareCost() {
        return softwareCost;
    }

    public void setSoftwareCost(Double softwareCost) {
        this.softwareCost = softwareCost;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
}
