package com.bsoft.project.report.condition;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/12 14:21
 */
public class ProjectLogChartQueryCnd {
    // 年份
    private Integer year;
    // 开始日期
    private Date startDate;
    // 结束日期
    private Date endDate;
    // 页码
    private Integer pageNo;
    // 每页数量
    private Integer pageSize;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
