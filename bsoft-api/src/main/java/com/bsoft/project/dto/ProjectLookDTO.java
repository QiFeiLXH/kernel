package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectLookDTO implements Serializable {
    private String projectId;
    private String projectName;
    private Double contractAmount;
    private String area;
    private String areaText;
    private String flag;
    private String flagText;
    private Date signDate;
    private String projectManager;
    private String projectManagerText;
    private String contractNo;
    private String contractid;
    private String customerName;
    private String pinyin;
    private String region;
    private String classification;
    private String grade;
    private Integer finshed;
    private Integer clueId;
    private Integer accountCaliber;
    private String accountCaliberText;

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

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerText() {
        return projectManagerText;
    }

    public void setProjectManagerText(String projectManagerText) {
        this.projectManagerText = projectManagerText;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getFinshed() {
        return finshed;
    }

    public void setFinshed(Integer finshed) {
        this.finshed = finshed;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }
}
