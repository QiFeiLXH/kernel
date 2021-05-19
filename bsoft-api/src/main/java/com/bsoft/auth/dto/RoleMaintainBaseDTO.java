package com.bsoft.auth.dto;

import java.io.Serializable;

/*
 * @author  hy
 * @date  2020/8/4 21:15
 * @description
 */
public class RoleMaintainBaseDTO implements Serializable {

    private Integer roleId;

    private String role;

    private String roleName;

    private String userId;

    private String userName;

    private String dept;

    private String userDept;

    private String userDeptName;

    private Integer id;

    private Integer sourceType;

    public RoleMaintainBaseDTO() {
    }

    public RoleMaintainBaseDTO(Integer roleId,String role, String userId, String dept,Integer id, Integer sourceType) {
        this.roleId = roleId;
        this.role = role;
        this.userId = userId;
        this.dept = dept;
        this.id = id;
        this.sourceType = sourceType;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept;
    }

    public String getUserDeptName() {
        return userDeptName;
    }

    public void setUserDeptName(String userDeptName) {
        this.userDeptName = userDeptName;
    }
}
