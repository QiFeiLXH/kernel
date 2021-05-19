package com.bsoft.payment.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.entity.primary
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:08
 * @Description: 财务流水、收益
 */
@Entity
@Table(name="fin_payment_flow")
public class FlowPaymentDO {
    private Integer id;
    /** 部门id */
    private String deptId;
    /** 机构名称 */
    private String orgName;
    /** 业务条线 */
    private Integer businessLine;
    /** 类别 */
    private Integer type;
    /** 金额 */
    private Double amount;
    /** 核算时间 */
    private Date accountDate;
    /** 审核时间 */
    private Date auditDate;
    /** 审核标志 */
    private Integer auditFlag;
    /** 审核人 */
    private String auditter;
    /** 备注信息 */
    private String remark;
    /** 登记日期 */
    private Date registrationDate;
    /** 登记人 */
    private String register;
    /** 1.流水  2.收益 */
    private Integer flag;

    @Id
    @SequenceGenerator(name="SEQ_FIN_PAYMENT_FLOW",allocationSize=1,sequenceName="SEQ_FIN_PAYMENT_FLOW")
    @GeneratedValue(generator="SEQ_FIN_PAYMENT_FLOW",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(Integer businessLine) {
        this.businessLine = businessLine;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
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

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }
}
