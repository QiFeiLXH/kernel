package com.bsoft.project.report.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/17 13:14
 */

@Entity
@Table(name="pro_logchart_m_view")
public class ProjectLogChartMonthViewDO {
    /* 月份 */
    @Id
    @Column(name = "logmonth")
    private Integer date;

    /* 平均结构化日志数量 */
    @Column(name = "prologs")
    private Double projectLogCount;

    /* 平均普通日志数量 */
    @Column(name = "worklogs")
    private Double workLogCount;

    /* 平均APP日志数量 */
    @Column(name = "applogs")
    private Double appLogCount;

    /* 平均结构化日志占比 */
    @Column(name = "rate")
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
