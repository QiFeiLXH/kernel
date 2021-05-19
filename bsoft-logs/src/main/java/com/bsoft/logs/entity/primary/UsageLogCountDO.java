package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KER_SYS_USAGELOG_COUNT")
public class UsageLogCountDO {
    private Integer id;//主键
    private Integer menuId;//菜单ID
    private Integer count;//点击次数
    private Integer personCount;//点击人数
    private Date countDate;//访问时间

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_USAGELOG_COUNT",allocationSize=1,sequenceName="SEQ_KER_SYS_USAGELOG_COUNT")
    @GeneratedValue(generator="SEQ_KER_SYS_USAGELOG_COUNT",strategy= GenerationType.SEQUENCE)
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
