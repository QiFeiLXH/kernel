package com.bsoft.logs.dto;

import java.io.Serializable;
import java.util.Date;

public class UsageLogCountQueryCndDTO implements Serializable {
    private Integer menuId;
    private Date startDate;
    private Date endDate;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
