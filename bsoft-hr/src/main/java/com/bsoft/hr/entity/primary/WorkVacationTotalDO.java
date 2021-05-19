package com.bsoft.hr.entity.primary;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 16:31
 * @Description
 */
public class WorkVacationTotalDO {
    private String id;
    /** 年份 */
    private String year;
    /** 工号 */
    private String personId;
    /** 类型 */
    private Integer type;
    /** 工龄 */
    private Integer standing;
    /** 天数 */
    private Double days;
    /** 已用天数 */
    private Double daysUsed;
    /** 生成日期 */
    private Date createDate;
    /** 有效开始日期 */
    private Date startDate;
    /** 有效截止日期 */
    private Date endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStanding() {
        return standing;
    }

    public void setStanding(Integer standing) {
        this.standing = standing;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
    }

    public Double getDaysUsed() {
        return daysUsed;
    }

    public void setDaysUsed(Double daysUsed) {
        this.daysUsed = daysUsed;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
