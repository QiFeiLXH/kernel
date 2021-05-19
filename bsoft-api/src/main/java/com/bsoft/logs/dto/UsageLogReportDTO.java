package com.bsoft.logs.dto;

import java.io.Serializable;

public class UsageLogReportDTO implements Serializable {
    private Integer menuId;
    private String name;
    private Long sl;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSl() {
        return sl;
    }

    public void setSl(Long sl) {
        this.sl = sl;
    }
}
