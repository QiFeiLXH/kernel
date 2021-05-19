package com.bsoft.hr.condition;

public class DeptMaintainInfoQueryCnd {


    // 部门
    private String dept;
    /* 部门类别 */
    private String deptType;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;

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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
