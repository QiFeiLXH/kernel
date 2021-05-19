package com.bsoft.auth.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/10/25 15:21
 * @Description:
 */
public class RoleMenuDTO implements Serializable {
    private Integer roleId;
    private Integer menuId;
    private Integer system;
    private Integer range;

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

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}
