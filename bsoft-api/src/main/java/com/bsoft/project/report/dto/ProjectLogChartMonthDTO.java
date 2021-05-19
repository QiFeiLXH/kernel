package com.bsoft.project.report.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/17 13:30
 */
public class ProjectLogChartMonthDTO implements Serializable {
    /* 月份 */
    private Integer date;

    /* 平均结构化日志数量 */
    private Double projectLogCount;

    /* 平均普通日志数量 */
    private Double workLogCount;

    /* 平均APP日志数量 */
    private Double appLogCount;

    /* 平均结构化日志占比 */
    private Double projectLogRate;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getProjectLogCount() {
        return projectLogCount;
    }

    public void setProjectLogCount(Double projectLogCount) {
        this.projectLogCount = projectLogCount;
    }

    public Double getWorkLogCount() {
        return workLogCount;
    }

    public void setWorkLogCount(Double workLogCount) {
        this.workLogCount = workLogCount;
    }

    public Double getAppLogCount() {
        return appLogCount;
    }

    public void setAppLogCount(Double appLogCount) {
        this.appLogCount = appLogCount;
    }

    public Double getProjectLogRate() {
        return projectLogRate;
    }

    public void setProjectLogRate(Double projectLogRate) {
        this.projectLogRate = projectLogRate;
    }
}
