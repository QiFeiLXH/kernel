package com.bsoft.project.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 9:17
 * @Description 项目责任书
 */
@Table(name="BSOFT_PORTAL.PRO_DUTY")
@Entity
public class ProjectDutyDO {
    /** 主键 */
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
    /** 签订日期 */
    private Date signDate;
    /** 登记日期 */
    private Date registerDate;
    /** 签订人 */
    private String signner;
    /** 审核人 */
    private String auditter;
    /** 审核日期 */
    private Date auditDate;
    /** 审核标志 */
    private Integer auditFlag;
    /** 提交标志 0 未提交 1已提交（已提交的数据无法修改） */
    private Integer committed;
    @Id
    @SequenceGenerator(name="SEQ_PRO_DUTY",allocationSize=1,sequenceName="SEQ_PRO_DUTY")
    @GeneratedValue(generator="SEQ_PRO_DUTY",strategy=GenerationType.SEQUENCE)
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

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getSignner() {
        return signner;
    }

    public void setSignner(String signner) {
        this.signner = signner;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Integer getCommitted() {
        return committed;
    }

    public void setCommitted(Integer committed) {
        this.committed = committed;
    }
}
