package com.bsoft.project.report.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 11:22
 * @Description: 项目奖金bean
 */
@Entity
@Table(name="BSOFT_PORTAL.KER_REPORT_PROJECTBONUS_VIEW")
public class ProjectBonusDO {
    @Id
    private String row_id;//id
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
    private Double discount;//折扣率
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
    private Integer depType;//项目奖金产生部门类别
    private String depTypeText;//项目奖金产生部门类别名称
    private Double projectBonus;//项目奖金
    private Integer projectBonusYear;//项目奖金年度
    private Integer projectBonusQuarter;//项目奖金季度
    private String projectBonusMonth;//项目奖金核算月份
    private Integer judgement;//判断条件 1项目级 2合同级

    public String getRow_id() {
        return row_id;
    }

    public void setRow_id(String row_id) {
        this.row_id = row_id;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public String getProjectFlagText() {
        return projectFlagText;
    }

    public void setProjectFlagText(String projectFlagText) {
        this.projectFlagText = projectFlagText;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
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

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public String getDepTypeText() {
        return depTypeText;
    }

    public void setDepTypeText(String depTypeText) {
        this.depTypeText = depTypeText;
    }

    public Double getProjectBonus() {
        return projectBonus;
    }

    public void setProjectBonus(Double projectBonus) {
        this.projectBonus = projectBonus;
    }

    public Integer getProjectBonusYear() {
        return projectBonusYear;
    }

    public void setProjectBonusYear(Integer projectBonusYear) {
        this.projectBonusYear = projectBonusYear;
    }

    public Integer getProjectBonusQuarter() {
        return projectBonusQuarter;
    }

    public void setProjectBonusQuarter(Integer projectBonusQuarter) {
        this.projectBonusQuarter = projectBonusQuarter;
    }

    public String getProjectBonusMonth() {
        return projectBonusMonth;
    }

    public void setProjectBonusMonth(String projectBonusMonth) {
        this.projectBonusMonth = projectBonusMonth;
    }

    public Integer getJudgement() {
        return judgement;
    }

    public void setJudgement(Integer judgement) {
        this.judgement = judgement;
    }
}
