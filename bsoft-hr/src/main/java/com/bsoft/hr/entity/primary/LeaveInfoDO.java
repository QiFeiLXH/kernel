package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 17:50
 * @Description
 */
@Entity
@Table(name="hr_leave_info_view")
public class LeaveInfoDO {
    @Id
    private Integer id;
    /** 工号 */
    private String personId;
    /** 请假类型 */
    private Integer type;
    /** 申请日期 */
    private Date applyDate;
    /** 请假开始日期 */
    private Date startDate;
    /** 请假结束日期 */
    private Date endDate;
    /** 年份 */
    private String year;
    /** 请假天数 */
    private Double leaveDays;
    /** 其中年份用的 */
    private Double someDays;
    /** 备注/原因 */
    private String remark;
    /** 流水号 */
    private String lshid;
    private Integer auditFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Double leaveDays) {
        this.leaveDays = leaveDays;
    }

    public Double getSomeDays() {
        return someDays;
    }

    public void setSomeDays(Double someDays) {
        this.someDays = someDays;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }
}
