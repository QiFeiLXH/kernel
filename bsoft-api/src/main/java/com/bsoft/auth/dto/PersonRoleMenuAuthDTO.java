package com.bsoft.auth.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/10/25 15:25
 * @Description:
 */
public class PersonRoleMenuAuthDTO implements Serializable {
    private String personId;
    private Integer menuId;
    private Integer authId;
    private Integer system;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
