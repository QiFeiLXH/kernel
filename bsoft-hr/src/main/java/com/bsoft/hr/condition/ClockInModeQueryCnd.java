package com.bsoft.hr.condition;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 考勤方式维护查询条件
 */
public class ClockInModeQueryCnd {
    // 工号
    private String personId;
    // 姓名
    private String personName;
    // 部门
    private String dept;
    /* 部门类别 */
    private String deptType;
    // 页码
    private Integer pageNo;
    // 每页条目
    private Integer pageSize;

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
