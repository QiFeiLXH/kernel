package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门打卡方式
 */
public class DeptMaintainInfoDTO implements Serializable {
    // 一级部门
    private String dept;
    // 一级部门名称
    private String deptName;
    // 父部门
    private String parentDept;
    // 子部门
    private List<DeptMaintainInfoDTO> children;
    /** 维护标志 0未维护财务类别部门 1全部部门 */
    private Integer maintain;
//    /** 维护状态 0未维护财务类别部门 1已维护 */
//    private Integer maintainType;
    /** 部门财务类别 1,按部门 2，按岗位 */
    private Integer PersonTypeFlag;

    /** 部门是否维护标志 0 未维护 1已维护 */
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

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


    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public List<DeptMaintainInfoDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptMaintainInfoDTO> children) {
        this.children = children;
    }
}
