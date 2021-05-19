package com.bsoft.project.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组组长为自身的列表数据dto
 */
public class ProjectGroupLeaderSelfViewDTO implements Serializable {
    /** 项目ID */
    private String projectId;
    /** 组别id */
    private String leaderGroupIds;
    /** 组名 */
    private String leaderGroups;
    /** 项目名称 */
    private String projectName;
    /** 合同名称 */
    private String contractName;
    /** 合同编号 */
    private String contractNo;
    /** 项目经理ID */
    private String managerId;
    /** 项目经理名字 */
    private String managerText;
    /** 签订时间 */
    private String signDate;
    /** 立项时间 */
    private String establishedDate;
    /** 工程区域 */
    private String area;
    /** 工程区域文本 */
    private String areaText;
    /** 合同金额 */
    private String amount;
    /** 客户编码 */
    private String customerCode;
    /** 客户名称 */
    private String customerName;
    /** 客户类别 */
    private String customerClassCode;
    /** 客户类别文本 */
    private String customerClass;
    /** 客户级别 */
    private String customerStateCode;
    /** 客户级别文本 */
    private String customerState;
    /** 客户所属区域 */
    private String respectiveRegionCode;
    /** 客户所属区域文本 */
    private String respectiveRegion;
    /** 组长ID */
    private String leaderId;
    /** 组长名字 */
    private String leaderName;
    /** 组员人数 */
    private Integer membersNumber;

    public String getLeaderGroupIds() {
        return leaderGroupIds;
    }

    public void setLeaderGroupIds(String leaderGroupIds) {
        this.leaderGroupIds = leaderGroupIds;
    }

    public String getLeaderGroups() {
        return leaderGroups;
    }

    public void setLeaderGroups(String leaderGroups) {
        this.leaderGroups = leaderGroups;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerText() {
        return managerText;
    }

    public void setManagerText(String managerText) {
        this.managerText = managerText;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getCustomerClassCode() {
        return customerClassCode;
    }

    public void setCustomerClassCode(String customerClassCode) {
        this.customerClassCode = customerClassCode;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public String getCustomerStateCode() {
        return customerStateCode;
    }

    public void setCustomerStateCode(String customerStateCode) {
        this.customerStateCode = customerStateCode;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getRespectiveRegionCode() {
        return respectiveRegionCode;
    }

    public void setRespectiveRegionCode(String respectiveRegionCode) {
        this.respectiveRegionCode = respectiveRegionCode;
    }

    public String getRespectiveRegion() {
        return respectiveRegion;
    }

    public void setRespectiveRegion(String respectiveRegion) {
        this.respectiveRegion = respectiveRegion;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getMembersNumber() {
        return membersNumber;
    }

    public void setMembersNumber(Integer membersNumber) {
        this.membersNumber = membersNumber;
    }
}
