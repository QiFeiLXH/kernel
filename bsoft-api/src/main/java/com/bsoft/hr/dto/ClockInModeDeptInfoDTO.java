package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门打卡方式
 */
public class ClockInModeDeptInfoDTO implements Serializable {
    // 一级部门
    private String dept;
    // 一级部门名称
    private String deptName;
    // 部门打卡方式
    private Integer attendFlagDept;
    // 父部门
    private String parentDept;
    // 子部门
    private List<ClockInModeDeptInfoDTO> children;

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

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public List<ClockInModeDeptInfoDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ClockInModeDeptInfoDTO> children) {
        this.children = children;
    }
}
