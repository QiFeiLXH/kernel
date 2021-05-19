package com.bsoft.hr.entity.primary;

import com.bsoft.hr.key.PerformanceKey;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 14:53
 * @Description 年度绩效
 */
@Entity
@Table(name="BSOFTMIS.RS_YGPJ")
@IdClass(PerformanceKey.class) //定义的联合主键
public class PerformanceDO {
    /** 员工工号 */
    @Id
    @Column(name="yggh")
    private String personId;
    /** 年份 */
    @Id
    @Column(name="year")
    private Integer year;
    /** 评价日期 */
    @Column(name="pjrq")
    private Date evaluationDate;
    /** 评价人*/
    @Column(name="pjry")
    private String evaluationPerson;
    @Column(name="bmdm")
    private String deptId;
    @Column(name="gwdm")
    private Integer jobCategory;
    /** 年度绩效 */
    private Double performance;
    /** 评价等级 */
    @Column(name="pjdj")
    private String evaluationGrade;
    /** 评价内容 */
    @Column(name="pjnr")
    private String evaluationContent;
    /** 导入标记 */
    private Integer flag;

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

    public String getEvaluationPerson() {
        return evaluationPerson;
    }

    public void setEvaluationPerson(String evaluationPerson) {
        this.evaluationPerson = evaluationPerson;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
