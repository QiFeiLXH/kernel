package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.RoleMenuAuthKey;

import javax.persistence.*;

@Entity
@IdClass(RoleMenuAuthKey.class)
@Table(name = "KER_SYS_ROLEMENUAUTH")
public class RoleMenuAuthDO {
    private Integer roleId;
    private Integer menuId;
    private Integer authId;
    private Integer system;

    @Id
    @Column(name = "roleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "menuId")
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Id
    @Column(name = "authId")
    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Id
    @Column(name = "system")
    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
