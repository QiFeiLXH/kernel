package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 14:34
 * @Description
 */
public class PerformanceDTO implements Serializable {
    /** 员工工号 */
    private String personId;
    /** 评价日期 */
    private Date evaluationDate;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 年份 */
    private Integer year;
    private String yearStr;
    /** 年度绩效 */
    private Double performance;
    private String performanceStr;
    /** 评价等级 */
    private String evaluationGrade;
    /** 评价内容 */
    private String evaluationContent;
    /** 登记人工号 */
    private String evaluationPerson;
    /** 登记人姓名 */
    private String evaluationPersonName;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public String getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(String evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public String getEvaluationPerson() {
        return evaluationPerson;
    }

    public void setEvaluationPerson(String evaluationPerson) {
        this.evaluationPerson = evaluationPerson;
    }

    public String getEvaluationPersonName() {
        return evaluationPersonName;
    }

    public void setEvaluationPersonName(String evaluationPersonName) {
        this.evaluationPersonName = evaluationPersonName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getYearStr() {
        return yearStr;
    }

    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }

    public String getPerformanceStr() {
        return performanceStr;
    }

    public void setPerformanceStr(String performanceStr) {
        this.performanceStr = performanceStr;
    }
}
