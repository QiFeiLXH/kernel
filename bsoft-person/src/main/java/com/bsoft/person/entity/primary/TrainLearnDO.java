package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:09
 * @Description 云学堂培训-知识学习
 */
@Entity
@Table(name="HR_TRAIN_LEARN")
public class TrainLearnDO {
    private Integer id;
    /** 员工工号 */
    private String personId;
    /** 所在部门 */
    private String deptId;
    /** 知识名称 */
    private String knowledgeName;
    /** 学习进度 */
    private Double learningRate;
    /** 学习模式 */
    private String learningModel;
    /** 学习时长（存的分钟） */
    private Double learningTime;
    /** 获得学分 */
    private Double earnedCredits;
    /** 开始时间-取的首次学习时间 */
    private Date startDate;
    /** 结束时间 */
    private Date endDate;
    /** 登记人 */
    private String register;
    /** 登记日期 */
    private Date registrationDate;

    @Id
    @SequenceGenerator(name="SEQ_HR_TRAIN_LEARN",allocationSize=1,sequenceName="SEQ_HR_TRAIN_LEARN")
    @GeneratedValue(generator="SEQ_HR_TRAIN_LEARN",strategy=GenerationType.SEQUENCE)
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
}
