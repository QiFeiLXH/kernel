package com.bsoft.project.report.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2019-12-12 17:35
 * @Version 1.0
 * @Description
 */
public class ProjectAllSubTotalDTO implements Serializable {
    private Integer id;
    private Integer careerGroup; //事业群编号
    private String careerGroupText;//事业群名称
    private String largeArea;//大区编码
    private String largeAreaText;//大区名称
    private String smallArea;//小区编码
    private String smallAreaText;//小区名称
    private String moneyBackDept;//回款业绩部门编码
    private String moneyBackDeptText;//回款业绩部门名称
    private String saleDept;//销售业绩部门编码
    private String saleDeptText;//销售业绩部门名称
    private String customerCode;//客户编码
    private String customerName;//客户名称
    private String contractNo;//合同号
    private String contractName;//合同名称
    private Double contractAmount;//合同金额
    private Double contractSoftwareAmount;//合同软件金额
    private Double softwareServiceAmount;//软件与服务金额
    private Double discountRate;//折扣率
    private String contractSigningDate;//合同签订日期
    private String contractAssessmentDate;//合同考核日期
    private String projectId;//项目ID
    private String projectName;//项目名称
    private Double projectAmount;//项目金额
    private Integer projectFlag;//项目类别
    private String projectFlagText;//项目类别
    private Integer projectType;//项目类型
    private String projectTypeText;//项目类型
    private String acceptanceStamp;//验收标记
    private Double workload;//人力成本工作量
    private Double manpowerCost;//人力成本金额
    private Double expenses;//报销费用
    private Double projectBonus;//项目奖金
    private Integer year;//年份

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCareerGroup() {
        return careerGroup;
    }

    public void setCareerGroup(Integer careerGroup) {
        this.careerGroup = careerGroup;
    }

    public String getCareerGroupText() {
        return careerGroupText;
    }

    public void setCareerGroupText(String careerGroupText) {
        this.careerGroupText = careerGroupText;
    }

    public String getLargeArea() {
        return largeArea;
    }

    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea;
    }

    public String getLargeAreaText() {
        return largeAreaText;
    }

    public void setLargeAreaText(String largeAreaText) {
        this.largeAreaText = largeAreaText;
    }

    public String getSmallArea() {
        return smallArea;
    }

    public void setSmallArea(String smallArea) {
        this.smallArea = smallArea;
    }

    public String getSmallAreaText() {
        return smallAreaText;
    }

    public void setSmallAreaText(String smallAreaText) {
        this.smallAreaText = smallAreaText;
    }

    public String getMoneyBackDept() {
        return moneyBackDept;
    }

    public void setMoneyBackDept(String moneyBackDept) {
        this.moneyBackDept = moneyBackDept;
    }

    public String getMoneyBackDeptText() {
        return moneyBackDeptText;
    }

    public void setMoneyBackDeptText(String moneyBackDeptText) {
        this.moneyBackDeptText = moneyBackDeptText;
    }

    public String getSaleDept() {
        return saleDept;
    }

    public void setSaleDept(String saleDept) {
        this.saleDept = saleDept;
    }

    public String getSaleDeptText() {
        return saleDeptText;
    }

    public void setSaleDeptText(String saleDeptText) {
        this.saleDeptText = saleDeptText;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Double getContractSoftwareAmount() {
        return contractSoftwareAmount;
    }

    public void setContractSoftwareAmount(Double contractSoftwareAmount) {
        this.contractSoftwareAmount = contractSoftwareAmount;
    }

    public Double getSoftwareServiceAmount() {
        return softwareServiceAmount;
    }

    public void setSoftwareServiceAmount(Double softwareServiceAmount) {
        this.softwareServiceAmount = softwareServiceAmount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }


    public String getContractSigningDate() {
        return contractSigningDate;
    }

    public void setContractSigningDate(String contractSigningDate) {
        this.contractSigningDate = contractSigningDate;
    }

    public String getContractAssessmentDate() {
        return contractAssessmentDate;
    }

    public void setContractAssessmentDate(String contractAssessmentDate) {
        this.contractAssessmentDate = contractAssessmentDate;
    }

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

    public Double getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(Double projectAmount) {
        this.projectAmount = projectAmount;
    }

    public Integer getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(Integer projectFlag) {
        this.projectFlag = projectFlag;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectFlagText() {
        return projectFlagText;
    }

    public void setProjectFlagText(String projectFlagText) {
        this.projectFlagText = projectFlagText;
    }

    public String getProjectTypeText() {
        return projectTypeText;
    }

    public void setProjectTypeText(String projectTypeText) {
        this.projectTypeText = projectTypeText;
    }

    public String getAcceptanceStamp() {
        return acceptanceStamp;
    }

    public void setAcceptanceStamp(String acceptanceStamp) {
        this.acceptanceStamp = acceptanceStamp;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Double getManpowerCost() {
        return manpowerCost;
    }

    public void setManpowerCost(Double manpowerCost) {
        this.manpowerCost = manpowerCost;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public Double getProjectBonus() {
        return projectBonus;
    }

    public void setProjectBonus(Double projectBonus) {
        this.projectBonus = projectBonus;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
