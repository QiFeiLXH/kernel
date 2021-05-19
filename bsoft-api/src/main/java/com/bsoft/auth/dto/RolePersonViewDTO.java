package com.bsoft.auth.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/10/27 16:14
 * @Description:
 */
public class RolePersonViewDTO implements Serializable {
    private String personId;
    private Integer roleId;
    private String personName;
    private Integer sl;
    private Integer sl2;
    private Integer parentId;
    private String roleName;//角色名称

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getSl2() {
        return sl2;
    }

    public void setSl2(Integer sl2) {
        this.sl2 = sl2;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
