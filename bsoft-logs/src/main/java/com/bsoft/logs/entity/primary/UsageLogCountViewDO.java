package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KER_SYS_USAGELOG_COUNT_VIEW")
public class UsageLogCountViewDO {
    private Integer id;//主键
    private Integer menuId;//菜单ID
    private String menuName;//菜单名称
    private Integer count;//点击次数
    private Integer personCount;//点击人数
    private Date countDate;//访问时间

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }
}
