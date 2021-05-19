package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "ker_person_base_view")
public class PersonViewDO implements Serializable {
    private String personId;
    private String personName;
    private String deptId;
    private String deptIdText;
    private String restype;
    private String restypeText;
    private String mobile;
    private String email;
    private Integer userId;
    private String isValid;
    private Integer company;
    private Integer sequence;
    private String sequenceText;
    private Integer specialRank;
    private String specialRankText;
    private Integer managerRank;
    private String managerRankText;
    private String simpleCode;
    private String evaluationGrade;
    private String evaluationContent;
    private Integer year;
    private Double probationSalary;
    private Double regularSalary;

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptIdText() {
        return deptIdText;
    }

    public void setDeptIdText(String deptIdText) {
        this.deptIdText = deptIdText;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getRestypeText() {
        return restypeText;
    }

    public void setRestypeText(String restypeText) {
        this.restypeText = restypeText;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }


    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }


    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    @Transient
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Transient
    public String getSequenceText() {
        return sequenceText;
    }

    public void setSequenceText(String sequenceText) {
        this.sequenceText = sequenceText;
    }

    @Transient
    public Integer getSpecialRank() {
        return specialRank;
    }

    public void setSpecialRank(Integer specialRank) {
        this.specialRank = specialRank;
    }

    @Transient
    public String getSpecialRankText() {
        return specialRankText;
    }

    public void setSpecialRankText(String specialRankText) {
        this.specialRankText = specialRankText;
    }

    @Transient
    public Integer getManagerRank() {
        return managerRank;
    }

    public void setManagerRank(Integer managerRank) {
        this.managerRank = managerRank;
    }

    @Transient
    public String getManagerRankText() {
        return managerRankText;
    }

    public void setManagerRankText(String managerRankText) {
        this.managerRankText = managerRankText;
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

    @Transient
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getProbationSalary() {
        return probationSalary;
    }

    public void setProbationSalary(Double probationSalary) {
        this.probationSalary = probationSalary;
    }

    public Double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(Double regularSalary) {
        this.regularSalary = regularSalary;
    }
}
