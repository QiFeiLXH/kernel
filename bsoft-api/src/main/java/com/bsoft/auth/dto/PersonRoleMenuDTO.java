package com.bsoft.auth.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/10/25 15:24
 * @Description:
 */
public class PersonRoleMenuDTO implements Serializable {
    private String personId;
    private Integer menuId;
    private Integer system;
    private Integer range;

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
