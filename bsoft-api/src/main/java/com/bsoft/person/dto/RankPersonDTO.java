package com.bsoft.person.dto;

import com.bsoft.project.dto.ProjectRankDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RankPersonDTO implements Serializable {
    private String personId;
    private String personName;
    private String cardNumber;
    private String firstDepId;
    private String firstDepName;
    private String secondDepId;
    private String secondDepName;
    private String workPost;
    private String phone;
    private Date entryDate;
    private String email;
    private String education;
    private Date graduateDate;
    private String school;
    private String major;
    private String performance;
    private Double score;
    private String firstManager;
    private String secondManager;
    private String hr;
    private String leader;
    private Integer rank;
    private String rankSequence;
    private Double teach;
    private Date evalDate;
    private Integer headQuarters;

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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstDepId() {
        return firstDepId;
    }

    public void setFirstDepId(String firstDepId) {
        this.firstDepId = firstDepId;
    }

    public String getFirstDepName() {
        return firstDepName;
    }

    public void setFirstDepName(String firstDepName) {
        this.firstDepName = firstDepName;
    }

    public String getSecondDepId() {
        return secondDepId;
    }

    public void setSecondDepId(String secondDepId) {
        this.secondDepId = secondDepId;
    }

    public String getSecondDepName() {
        return secondDepName;
    }

    public void setSecondDepName(String secondDepName) {
        this.secondDepName = secondDepName;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getFirstManager() {
        return firstManager;
    }

    public void setFirstManager(String firstManager) {
        this.firstManager = firstManager;
    }

    public String getSecondManager() {
        return secondManager;
    }

    public void setSecondManager(String secondManager) {
        this.secondManager = secondManager;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRankSequence() {
        return rankSequence;
    }

    public void setRankSequence(String rankSequence) {
        this.rankSequence = rankSequence;
    }

    public Double getTeach() {
        return teach;
    }

    public void setTeach(Double teach) {
        this.teach = teach;
    }

    public Date getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    public Integer getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(Integer headQuarters) {
        this.headQuarters = headQuarters;
    }
}
