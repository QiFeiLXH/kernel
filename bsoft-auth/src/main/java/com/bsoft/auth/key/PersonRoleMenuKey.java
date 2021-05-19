package com.bsoft.auth.key;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:20
 * @Description:
 */
public class PersonRoleMenuKey implements Serializable {
    private String personId;
    private Integer menuId;
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

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
