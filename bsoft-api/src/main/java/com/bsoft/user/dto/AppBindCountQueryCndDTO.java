package com.bsoft.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description APP用户绑定情况查询条件
 */
public class AppBindCountQueryCndDTO implements Serializable {
    /* 开始日期 */
    private Date startDate;
    /* 结束日期 */
    private Date endDate;
    /* 页码 */
    private Integer pageNo;
    /* 每页条数 */
    private Integer pageSize;

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
