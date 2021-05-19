package com.bsoft.hr.entity.primary;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:59
 * @Description
 */

public class WorkLeaveVacationDO {
    /** 工号 */
    private String personId;
    /** 姓名 */
    private String personName;
    /** 拼音 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 历年年休 */
    private Double oldAnnualDays;
    /** 当年年休 */
    private Double currentAnnualDays;
    /** 已用年休 */
    private Double annualDaysUsed;
    /** 剩余年休 */
    private Double annualDaysLeft;
    /** 历年调休 */
    private Double oldRestDays;
    /** 当年调休 */
    private Double currentRestDays;
    /** 已用调休 */
    private Double restDaysUsed;
    /** 剩余调休 */
    private Double restDaysLeft;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getOldAnnualDays() {
        return oldAnnualDays;
    }

    public void setOldAnnualDays(Double oldAnnualDays) {
        this.oldAnnualDays = oldAnnualDays;
    }

    public Double getCurrentAnnualDays() {
        return currentAnnualDays;
    }

    public void setCurrentAnnualDays(Double currentAnnualDays) {
        this.currentAnnualDays = currentAnnualDays;
    }

    public Double getAnnualDaysUsed() {
        return annualDaysUsed;
    }

    public void setAnnualDaysUsed(Double annualDaysUsed) {
        this.annualDaysUsed = annualDaysUsed;
    }

    public Double getAnnualDaysLeft() {
        return annualDaysLeft;
    }

    public void setAnnualDaysLeft(Double annualDaysLeft) {
        this.annualDaysLeft = annualDaysLeft;
    }

    public Double getOldRestDays() {
        return oldRestDays;
    }

    public void setOldRestDays(Double oldRestDays) {
        this.oldRestDays = oldRestDays;
    }

    public Double getCurrentRestDays() {
        return currentRestDays;
    }

    public void setCurrentRestDays(Double currentRestDays) {
        this.currentRestDays = currentRestDays;
    }

    public Double getRestDaysUsed() {
        return restDaysUsed;
    }

    public void setRestDaysUsed(Double restDaysUsed) {
        this.restDaysUsed = restDaysUsed;
    }

    public Double getRestDaysLeft() {
        return restDaysLeft;
    }

    public void setRestDaysLeft(Double restDaysLeft) {
        this.restDaysLeft = restDaysLeft;
    }
}
