package com.bsoft.auth.key;

import java.io.Serializable;

public class RoleMenuKey implements Serializable {
    private Integer roleId;
    private Integer menuId;
    private Integer system;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
