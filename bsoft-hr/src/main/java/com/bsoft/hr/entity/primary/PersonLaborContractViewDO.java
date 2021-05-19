package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/12/11
 * @description 人员劳动合同信息
 */
@Entity
@Table(name = "hr_person_laborcontract_view")
public class PersonLaborContractViewDO {
    /** 工号*/
    @Id
    private String personId;

    /** 姓名*/
    private String personName;

    /** 岗位*/
    private String post;

    /** 部门编号*/
    private String dept;

    /** 入职时间*/
    private Date inDate;

    /** 劳动合同到期时间*/
    private Date endDate;

    /** 年度绩效*/
    private String evaluationGrade;

    /** 岗位序列*/
    private String sequence;

    /** 评定职级*/
    private String specialRank;

    /** 注销标志*/
    private String flag;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(String evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(String specialRank) {
        this.specialRank = specialRank;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
