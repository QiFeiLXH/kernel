package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.PersonRoleMenuAuthKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:22
 * @Description:
 */
@Entity
@IdClass(PersonRoleMenuAuthKey.class)
@Table(name = "KER_SYS_ROLEMENUAUTH_P")
public class PersonRoleMenuAuthDO {
    private String personId;
    private Integer menuId;
    private Integer authId;
    private Integer system;

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Id
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Id
    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Id
    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
