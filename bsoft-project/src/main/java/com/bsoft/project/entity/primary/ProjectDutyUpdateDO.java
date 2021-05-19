package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/21 14:00
 * @Description
 */
@Table(name="BSOFT_PORTAL.PRO_DUTY")
@Entity
public class ProjectDutyUpdateDO {
    /** 主键 */
    @Id
    private Integer id;
    /** 客户编码 */
    private String customerId;
    /** 责任书名称 */
    private String name;
    /** 考核开始日期 */
    private Date startDate;
    /** 考核结束日期 */
    private Date endDate;
    /** 人力成本 */
    private Double laborCost;
    /** 报销费用 */
    private Double reimburse;
    /** 奖金 */
    private Double bonus;
    /** 提交标志 0 未提交 1已提交（已提交的数据无法修改） */
    private Integer committed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }
}
