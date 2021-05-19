package com.bsoft.hr.dto;

import java.io.Serializable;

public class VacationReduceQueryCndDTO implements Serializable {
    private String  year;
    private Integer pageNo;
    private Integer pageSize;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
