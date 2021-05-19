package com.bsoft.hr.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假（总览）DTO
 */
public class WorkVacationTotalViewDTO implements Serializable {
    // 年份
    private String year;
    // 员工工号
    private String personId;
    // 员工姓名
    private String personName;
    // 部门编号
    private String deptId;
    // 部门名称
    private String deptName;
    // 总调休假
    private Double workTimes;
    // 已用调休假
    private Double useTimes;
    // 未用调休假
    private Double restTimes;

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

    public Double getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Double workTimes) {
        this.workTimes = workTimes;
    }

    public Double getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Double useTimes) {
        this.useTimes = useTimes;
    }

    public Double getRestTimes() {
        return restTimes;
    }

    public void setRestTimes(Double restTimes) {
        this.restTimes = restTimes;
    }
}
