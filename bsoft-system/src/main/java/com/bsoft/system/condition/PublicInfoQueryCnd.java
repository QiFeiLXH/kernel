package com.bsoft.system.condition;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/8 10:02
 * @Description: 新闻查询类
 */
public class PublicInfoQueryCnd {
    private Integer type;
    private Integer pageNo;
    private Integer pageSize;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
