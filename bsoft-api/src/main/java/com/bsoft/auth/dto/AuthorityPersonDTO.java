package com.bsoft.auth.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/20 17:30
 * @Description
 */
public class AuthorityPersonDTO implements Serializable {
    /** 工号 */
    private String personId;
    /** 姓名 */
    private String personName;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 角色id */
    private Integer roleId;
    /** 角色名称 */
    private String roleName;
    /** 是否在职 0在职 1离职 */
    private Integer valid;

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
