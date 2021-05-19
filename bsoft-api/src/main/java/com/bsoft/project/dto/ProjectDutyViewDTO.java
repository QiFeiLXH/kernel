package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 12:50
 * @Description
 */
public class ProjectDutyViewDTO implements Serializable {
    /** 主键 */
    private Integer id;
    /** 责任书名称 */
    private String name;
    /** 考核开始日期 */
    private Date startDate;
    /** 考核结束日期 */
    private Date endDate;
    /** 合同编号 */
    private String contractNo;
    /** 客户编码 */
    private String customerId;
    /** 客户名称 */
    private String customerName;
    /** 人力成本 */
    private Double laborCost;
    /** 报销费用 */
    private Double reimburse;
    /** 奖金 */
    private Double bonus;
    /** 预算总成本（万元） */
    private Double budgetTotalCost;
    /** 计划回款（万元） */
    private Double expectedBackMoney;
    /** 签订日期 */
    private Date signDate;
    /** 签订人 */
    private String signner;
    private String signnerName;
    /** 审核标志 */
    private Integer auditFlag;
    /** 责任书年度 */
    private Integer year;
    /** 项目计划是否已选择里程碑 0 未选择 1已选择 */
    private Integer milepostSelectedFlag;
    /** 提交标志 0 未提交 1已提交（已提交的数据无法修改） */
    private Integer committed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Double getBudgetTotalCost() {
        return budgetTotalCost;
    }

    public void setBudgetTotalCost(Double budgetTotalCost) {
        this.budgetTotalCost = budgetTotalCost;
    }

    public Double getExpectedBackMoney() {
        return expectedBackMoney;
    }

    public void setExpectedBackMoney(Double expectedBackMoney) {
        this.expectedBackMoney = expectedBackMoney;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSignner() {
        return signner;
    }

    public void setSignner(String signner) {
        this.signner = signner;
    }

    public String getSignnerName() {
        return signnerName;
    }

    public void setSignnerName(String signnerName) {
        this.signnerName = signnerName;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public Double getReimburse() {
        return reimburse;
    }

    public void setReimburse(Double reimburse) {
        this.reimburse = reimburse;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getMilepostSelectedFlag() {
        return milepostSelectedFlag;
    }

    public void setMilepostSelectedFlag(Integer milepostSelectedFlag) {
        this.milepostSelectedFlag = milepostSelectedFlag;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }
}
