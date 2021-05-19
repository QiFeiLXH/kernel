package com.bsoft.project.report.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/7 8:55
 */
public class ProjectLogChartDTO implements Serializable {
    /* 日期 */
    private Date date;

    /* 结构化日志数量 */
    private Integer projectLogCount;

    /* 普通日志数量 */
    private Integer workLogCount;

    /* APP日志数量 */
    private Integer appLogCount;

    /* 结构化日志占比 */
    private Double projectLogRate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProjectLogCount() {
        return projectLogCount;
    }

    public void setProjectLogCount(Integer projectLogCount) {
        this.projectLogCount = projectLogCount;
    }

    public Integer getWorkLogCount() {
        return workLogCount;
    }

    public void setWorkLogCount(Integer workLogCount) {
        this.workLogCount = workLogCount;
    }

    public Integer getAppLogCount() {
        return appLogCount;
    }

    public void setAppLogCount(Integer appLogCount) {
        this.appLogCount = appLogCount;
    }

    public Double getProjectLogRate() {
        return projectLogRate;
    }

    public void setProjectLogRate(Double projectLogRate) {
        this.projectLogRate = projectLogRate;
    }
}

