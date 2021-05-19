package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

public class UsageLogCountWithDateDO {
    private Integer menuId;//菜单ID
    private String menuName;//菜单名称
    private Long count;//点击次数
    private Long personCount;//点击人数

    public UsageLogCountWithDateDO(Integer menuId, String menuName, Long count, Long personCount) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.count = count;
        this.personCount = personCount;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Long personCount) {
        this.personCount = personCount;
    }
}
