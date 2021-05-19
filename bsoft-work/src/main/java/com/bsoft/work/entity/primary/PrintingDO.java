package com.bsoft.work.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:07
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.WORK_PRINTING")
public class PrintingDO {
    @Id
    private Integer id;
    /** 申请人 */
    private String applicant;
    /** 申请日期 */
    private Date applyDate;
    /** 归属人 */
    private String belonger;
    /** 归属部门 */
    private String belongDept;
    /** 项目id */
    private String projectId;
    /** 费用类别 */
    private Integer costType;
    /** 核算口径 */
    private Integer accountCaliber;
    /** 申领事由 */
    private String reason;
    /** 订单编号 */
    private String orderNum;
    /** 文印日期 */
    private Date printDate;
    /** 发放标志 */
    private Integer grantFlag;
    /** 发放人 */
    private String grantter;
    /** 发放日期 */
    private Date grantDate;
    /** 流水号id */
    private String lshid;
    private Integer appid;
    /** 状态 */
    private Integer status;
    /** 核准金额 */
    private Double approval;
    /** 文印单位 */
    private Integer printUnit;
    /** 申请支付日期 */
    private Date applyPayDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public String getBelongDept() {
        return belongDept;
    }

    public void setBelongDept(String belongDept) {
        this.belongDept = belongDept;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Integer getGrantFlag() {
        return grantFlag;
    }

    public void setGrantFlag(Integer grantFlag) {
        this.grantFlag = grantFlag;
    }

    public String getGrantter() {
        return grantter;
    }

    public void setGrantter(String grantter) {
        this.grantter = grantter;
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getApproval() {
        return approval;
    }

    public void setApproval(Double approval) {
        this.approval = approval;
    }

    public Integer getPrintUnit() {
        return printUnit;
    }

    public void setPrintUnit(Integer printUnit) {
        this.printUnit = printUnit;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }
}
