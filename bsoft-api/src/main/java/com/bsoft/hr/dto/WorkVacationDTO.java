package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假DTO
 */
public class WorkVacationDTO implements Serializable {
    // id
    private Integer id;
    // 年份
    private String year;
    // 工号
    private String personId;
    // 部门
    private String dept;
    // 类型
    private Integer type;
    // 生成时间
    private Date createDate;
    // 有效开始日期
    private Date startDate;
    // 有效截止日期
    private Date endDate;
    // 登记人
    private String registrant;
    // 加班类型（1工作日加班 2节假日加班）
    private Integer workType;
    // 加班开始时间
    private Date workStartDate;
    // 加班结束时间
    private Date workEndDate;
    // 加班原因
    private String remark;
    // 加班时长（小时）
    private Double workTimes;
    // 流水号
    private String lshid;
    // 审核标志
    private Integer auditFlag;
    //系统自动生成标志
    private Integer autoFlag;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Double workTimes) {
        this.workTimes = workTimes;
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

    public Integer getAutoFlag() {
        return autoFlag;
    }

    public void setAutoFlag(Integer autoFlag) {
        this.autoFlag = autoFlag;
    }
}