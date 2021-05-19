package com.bsoft.project.report.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/7 9:00
 */
@Entity
@Table(name="pro_logchart_view")
public class ProjectLogChartViewDO {

    /* 日期 */
    @Id
    @Column(name = "logdate")
    private Date date;

    /* 结构化日志数量 */
    @Column(name = "prologs")
    private Integer projectLogCount;

    /* 普通日志数量 */
    @Column(name = "worklogs")
    private Integer workLogCount;

    /* APP日志数量 */
    @Column(name = "applogs")
    private Integer appLogCount;

    /* 结构化日志占比 */
    @Column(name = "rate")
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