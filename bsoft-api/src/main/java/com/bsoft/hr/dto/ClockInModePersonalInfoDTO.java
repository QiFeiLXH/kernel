package com.bsoft.hr.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人打卡方式
 */
public class ClockInModePersonalInfoDTO implements Serializable {
    // 工号
    private String personId;
    // 姓名
    private String personName;
    // 部门
    private String dept;
    // 部门名称
    private String deptName;
    // 部门打卡方式
    private Integer attendFlagDept;
    // 个人打卡方式
    private Integer attendFlagPersonal;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getAttendFlagDept() {
        return attendFlagDept;
    }

    public void setAttendFlagDept(Integer attendFlagDept) {
        this.attendFlagDept = attendFlagDept;
    }

    public Integer getAttendFlagPersonal() {
        return attendFlagPersonal;
    }

    public void setAttendFlagPersonal(Integer attendFlagPersonal) {
        this.attendFlagPersonal = attendFlagPersonal;
    }

}
