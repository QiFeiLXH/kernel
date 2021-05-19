package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门财务维护
 */
@Entity
@Table(name = "hr_person_maintain_VIEW")
public class PersonDeptMaintainViewDO {
    // 一级部门
    @Id
    @Column(name = "bmdm")
    private String dept;

    // 一级部门名称
    @Column(name = "bmmc")
    private String deptName;

    // 部门考勤方式
    @Column(name = "attendflag")
    private Integer attendFlagDept;

    // 注销标志
    @Column(name = "zxbz")
    private Integer logout;

    /* 部门类别*/
    @Column(name = "bmlb")
    private Integer deptType;

    // 父部门
    @Column(name = "parentbm")
    private String parentDept;

    // 父部门
    @Column(name = "sortby")
    private Integer sortBy;


    /** 部门财务类别 1,按部门 2，按岗位 */
    @Column(name = "persontypeflag")
    private Integer personTypeFlag;

    /** 部门是否维护标志 0 未维护 1已维护 */
    @Column(name = "flag")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getPersonTypeFlag() {
        return personTypeFlag;
    }

    public void setPersonTypeFlag(Integer personTypeFlag) {
        personTypeFlag = personTypeFlag;
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

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public Integer getSortBy() { return sortBy; }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
