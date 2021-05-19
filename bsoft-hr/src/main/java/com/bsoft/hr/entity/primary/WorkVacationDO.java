package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 假期库（加班，年假）
 */
@Entity
@Table(name="hr_work_vacation")
public class  WorkVacationDO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 年份
     */
    private String year;
    /**
     * 员工工号
     */
    private String personId;
    /**
     * 部门id
     */
    private String dept;
    /**
     * 累计工龄
     */
    private Double standing;
    /**
     * 请假类型
     */
    private Integer type;
    /**
     * 加班时长/年休时间
     */
    private Double workTimes;
    /**
     * 生成日期/加班日期
     */
    private Date createDate;
    /**
     * 有效开始日期
     */
    private Date startDate;
    /**
     * 有效截止日期
     */
    private Date endDate;
    /**
     * 登记人
     */
    private String registrant;
    /**
     * 备注 加班原因
     */
    private String remark;
    /**
     * 加班开始日期
     */
    private Date workStartDate;
    /**
     * 加班结束日期
     */
    private Date workEndDate;
    /**
     * 流水号id
     */
    private String lshid;
    /**
     * appid
     */
    private String appid;
    /**
     * 加班类型
     */
    private Integer workType;
    /**
     * 审核标志
     */
    private Integer auditFlag;
    /**
     * 系统自动生成标志
     */
    private Integer autoFlag;
    /**
     * 明细集合
     */
    private List<WorkVacationDetailDO> workVacationDetails;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getStanding() {
        return standing;
    }

    public void setStanding(Double standing) {
        this.standing = standing;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Double workTimes) {
        this.workTimes = workTimes;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public Date getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(Date workEndDate) {
        this.workEndDate = workEndDate;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }


    public Integer getAutoFlag() {
        return autoFlag;
    }

    public void setAutoFlag(Integer autoFlag) {
        this.autoFlag = autoFlag;
    }

    @Transient
    public List<WorkVacationDetailDO> getWorkVacationDetails() {
        return workVacationDetails;
    }

    public void setWorkVacationDetails(List<WorkVacationDetailDO> workVacationDetails) {
        this.workVacationDetails = workVacationDetails;
    }
}
