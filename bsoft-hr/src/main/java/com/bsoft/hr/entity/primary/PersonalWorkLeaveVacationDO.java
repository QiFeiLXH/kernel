package com.bsoft.hr.entity.primary;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:59
 * @Description
 */

public class PersonalWorkLeaveVacationDO {
    /** 工号 */
    private String personId;
    /** 请假类型 */
    private Integer type;
    /** 历年剩余天数 */
    private Double lastYearDaysLeft;
    /** 当年总天数 */
    private Double currentYearDays;
    /** 今年已用 */
    private Double currentYearDaysUsed;
    /** 剩余可用 */
    private Double totalDaysLeft;
    /** 即将过期天数 */
    private Double expiringDays;

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

    public Double getLastYearDaysLeft() {
        return lastYearDaysLeft;
    }

    public void setLastYearDaysLeft(Double lastYearDaysLeft) {
        this.lastYearDaysLeft = lastYearDaysLeft;
    }

    public Double getCurrentYearDays() {
        return currentYearDays;
    }

    public void setCurrentYearDays(Double currentYearDays) {
        this.currentYearDays = currentYearDays;
    }

    public Double getCurrentYearDaysUsed() {
        return currentYearDaysUsed;
    }

    public void setCurrentYearDaysUsed(Double currentYearDaysUsed) {
        this.currentYearDaysUsed = currentYearDaysUsed;
    }

    public Double getTotalDaysLeft() {
        return totalDaysLeft;
    }

    public void setTotalDaysLeft(Double totalDaysLeft) {
        this.totalDaysLeft = totalDaysLeft;
    }

    public Double getExpiringDays() {
        return expiringDays;
    }

    public void setExpiringDays(Double expiringDays) {
        this.expiringDays = expiringDays;
    }
}
