package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.entity.primary
 * @Author: Xuhui Lin
 * @CreateTime: 2020-05-16 18:33
 * @Description: 项目责任书审核
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_DUTY_AUDIT_VIEW")
public class ProjectDutyAuditViewDO {
    @Id
    private Integer id;
    /** 责任书名称 */
    private String name;
    /** 工程区域 */
    private String area;
    /** 回款部门 */
    private String backMoneyDept;
    private String backMoneyDeptText;
    /** 回款一级部门 */
    private String largeBackMoneyDept;
    private String largeBackMoneyDeptText;
    /** 项目经理 */
    private String projectManager;
    private String projectManagerName;
    /** 开始时间 */
    private Date startDate;
    /** 结束时间 */
    private Date endDate;
    /** 签订日期 */
    private Date signDate;
    /** 人力成本 */
    private Double laborCost;
    /** 报销费用 */
    private Double reimburse;
    /** 奖金 */
    private Double bonus;
    /** 预算总成本 */
    private Double budgetTotalCost;
    /** 计划回款 */
    private Double planBackMoney;
    /** 审核标记 */
    private Integer auditFlag;
    private String auditFlagText;
    /** 年份 */
    private Integer year;
    /** 客户id */
    private String customerId;
    /** 客户名称 */
    private String customerName;
    /** 审核日期 */
    private Date auditDate;
    /** 是否已提交 */
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

    public String getBackMoneyDept() {
        return backMoneyDept;
    }

    public void setBackMoneyDept(String backMoneyDept) {
        this.backMoneyDept = backMoneyDept;
    }

    public String getBackMoneyDeptText() {
        return backMoneyDeptText;
    }

    public void setBackMoneyDeptText(String backMoneyDeptText) {
        this.backMoneyDeptText = backMoneyDeptText;
    }

    public String getLargeBackMoneyDept() {
        return largeBackMoneyDept;
    }

    public void setLargeBackMoneyDept(String largeBackMoneyDept) {
        this.largeBackMoneyDept = largeBackMoneyDept;
    }

    public String getLargeBackMoneyDeptText() {
        return largeBackMoneyDeptText;
    }

    public void setLargeBackMoneyDeptText(String largeBackMoneyDeptText) {
        this.largeBackMoneyDeptText = largeBackMoneyDeptText;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
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

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public Double getBudgetTotalCost() {
        return budgetTotalCost;
    }

    public void setBudgetTotalCost(Double budgetTotalCost) {
        this.budgetTotalCost = budgetTotalCost;
    }

    public Double getPlanBackMoney() {
        return planBackMoney;
    }

    public void setPlanBackMoney(Double planBackMoney) {
        this.planBackMoney = planBackMoney;
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

    public String getAuditFlagText() {
        return auditFlagText;
    }

    public void setAuditFlagText(String auditFlagText) {
        this.auditFlagText = auditFlagText;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
