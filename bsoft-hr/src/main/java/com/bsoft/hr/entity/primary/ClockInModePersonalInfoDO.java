package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人打卡方式
 */
@Entity
@Table(name = "hr_person_attend_info_view")
public class ClockInModePersonalInfoDO {
    // 工号
    @Id
    private String personId;
    // 姓名
    private String personName;
    // 姓名拼音码
    private String nameCode;
    // 部门
    private String dept;
    // 部门名称
    private String deptName;
    // 部门考勤方式
    private Integer attendFlagDept;
    // 个人考勤方式
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

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
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
