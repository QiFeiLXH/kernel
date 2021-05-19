package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:09
 * @Description 云学堂培训-知识学习视图
 */
public class TrainLearnDTO implements Serializable {
    private Integer id;
    /** 员工工号 */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音码 */
    private String simpleCode;
    /** 所在部门 */
    private String deptId;
    /** 所在部门名称 */
    private String deptName;
    /** 知识名称 */
    private String knowledgeName;
    /** 学习进度 */
    private Double learningRate;
    private String learningRateStr;
    /** 学习模式 */
    private String learningModel;
    /** 学习时长（存的分钟） */
    private Double learningTime;
    private String learningTimeStr;
    /** 获得学分 */
    private Double earnedCredits;
    private String earnedCreditsStr;
    /** 开始时间-取的首次学习时间 */
    private Date startDate;
    private String startDateStr;
    /** 结束时间 */
    private Date endDate;
    private String endDateStr;
    /** 登记人 */
    private String register;
    /** 登记日期 */
    private Date registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public Double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(Double learningRate) {
        this.learningRate = learningRate;
    }

    public String getLearningModel() {
        return learningModel;
    }

    public void setLearningModel(String learningModel) {
        this.learningModel = learningModel;
    }

    public Double getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(Double learningTime) {
        this.learningTime = learningTime;
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

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getEarnedCredits() {
        return earnedCredits;
    }

    public void setEarnedCredits(Double earnedCredits) {
        this.earnedCredits = earnedCredits;
    }

    public String getLearningRateStr() {
        return learningRateStr;
    }

    public void setLearningRateStr(String learningRateStr) {
        this.learningRateStr = learningRateStr;
    }

    public String getLearningTimeStr() {
        return learningTimeStr;
    }

    public void setLearningTimeStr(String learningTimeStr) {
        this.learningTimeStr = learningTimeStr;
    }

    public String getEarnedCreditsStr() {
        return earnedCreditsStr;
    }

    public void setEarnedCreditsStr(String earnedCreditsStr) {
        this.earnedCreditsStr = earnedCreditsStr;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }
}
