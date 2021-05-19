package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDTO implements Serializable {
    private String projectId;
    private String contractNo;
    private String projectName;
    private String projectManager;
    private String area;
    private String flag;
    private String projectManagerText;
    private String flagText;
    private String areaText;
    private String finshed;
    private Integer businessCategory;
    /** 终验日期*/
    private Date finalCheckDate;
    /** 合同编号、合同ID、htbh*/
    private String contractId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getProjectManagerText() {
        return projectManagerText;
    }

    public void setProjectManagerText(String projectManagerText) {
        this.projectManagerText = projectManagerText;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getFinshed() {
        return finshed;
    }

    public void setFinshed(String finshed) {
        this.finshed = finshed;
    }

    public Integer getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Integer businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Date getFinalCheckDate() {
        return finalCheckDate;
    }

    public void setFinalCheckDate(Date finalCheckDate) {
        this.finalCheckDate = finalCheckDate;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
