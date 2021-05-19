package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.RoleMenuKey;

import javax.persistence.*;

@Entity
@IdClass(RoleMenuKey.class)
@Table(name = "KER_SYS_ROLEMENU")
public class RoleMenuDO {
    private Integer roleId;
    private Integer menuId;
    private Integer system;
    private Integer range;

    @Id
    @Column(name="roleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name="menuId")
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Id
    @Column(name="system")
    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    @Column(name="range")
    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}
