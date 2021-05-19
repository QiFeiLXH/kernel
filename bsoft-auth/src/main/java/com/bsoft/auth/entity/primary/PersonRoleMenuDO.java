package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.PersonRoleMenuKey;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:17
 * @Description:
 */
@Entity
@IdClass(PersonRoleMenuKey.class)
@Table(name = "KER_SYS_ROLEMENU_P")
public class PersonRoleMenuDO {
    private String personId;
    private Integer menuId;
    private Integer system;
    private Integer range;

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
