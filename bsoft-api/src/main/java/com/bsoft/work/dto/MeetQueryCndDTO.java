package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-12-21 13:44
 * @Version 1.0
 */
public class MeetQueryCndDTO implements Serializable {
    private String month;//例 2020-12
    private Integer pageSize;
    private Integer pageNo;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
