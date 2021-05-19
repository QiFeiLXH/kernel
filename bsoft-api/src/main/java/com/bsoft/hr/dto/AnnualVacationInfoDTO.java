package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
public class AnnualVacationInfoDTO implements Serializable {
    // id
    private Integer id;
    // 年份
    private String year;
    // 员工工号
    private String personId;
    // 员工姓名
    private String personName;
    // 部门代码
    private String deptId;
    // 部门名称
    private String deptName;
    // 假期类型
    private Integer type;
    // 假期时长
    private Double workTimes;
    // 创建时间
    private Date createDate;
    // 开始生效时间
    private Date startDate;
    // 有效截止时间
    private Date endDate;
    // 备注
    private String remark;
    // 审核标志
    private Integer auditFlag;
    // 系统自动生成标志
    private Integer autoFlag;
    //使用标志
    private Integer useFlag;
    //加班开始时间
    private Date workStartDate;
    //加班结束时间
    private Date workEndDate;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
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
}
