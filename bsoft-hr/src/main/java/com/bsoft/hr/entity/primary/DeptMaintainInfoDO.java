package com.bsoft.hr.entity.primary;


import java.io.Serializable;

public class DeptMaintainInfoDO implements Serializable {


    // 部门
    private String dept;
    /* 部门类别 */
    private String deptType;

    /** 维护标志 0未维护财务类别部门 1全部部门 */
    private Integer maintain;
    /** 维护状态 0未维护财务类别部门 1已维护 */
    private Integer maintainType;
    /** 部门财务类别 1,按部门 2，按岗位 */
    private Integer PersonTypeFlag;

    public Integer getPersonTypeFlag() {
        return PersonTypeFlag;
    }

    public void setPersonTypeFlag(Integer personTypeFlag) {
        PersonTypeFlag = personTypeFlag;
    }

    public Integer getMaintain() {
        return maintain;
    }

    public void setMaintain(Integer maintain) {
        this.maintain = maintain;
    }

    public Integer getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(Integer maintainType) {
        this.maintainType = maintainType;
    }


    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }


}
