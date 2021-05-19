package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 14:54
 * @Description 个人培训情况
 */
@Entity
@Table(name = "hr_train_personaltrain_view")
public class PersonalTrainViewDO {
    @Id
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音简码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 年份 */
    private Integer year;
    /** 总授课课时 */
    private Double totalTeachingHours;
    /** 总参训课时 */
    private Double totalTrainingHours;
    /** eoffice在职培训课时 */
    private Double eofficeHours;
    /** 云学堂自主学习课时 */
    private Double yxtLearnSelfHours;
    /** 云学堂指派学习课时 */
    private Double yxtLearnAssignedHours;
    /** 知识分享数 */
    private Integer shareCount;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTotalTeachingHours() {
        return totalTeachingHours;
    }

    public void setTotalTeachingHours(Double totalTeachingHours) {
        this.totalTeachingHours = totalTeachingHours;
    }

    public Double getTotalTrainingHours() {
        return totalTrainingHours;
    }

    public void setTotalTrainingHours(Double totalTrainingHours) {
        this.totalTrainingHours = totalTrainingHours;
    }

    public Double getEofficeHours() {
        return eofficeHours;
    }

    public void setEofficeHours(Double eofficeHours) {
        this.eofficeHours = eofficeHours;
    }

    public Double getYxtLearnSelfHours() {
        return yxtLearnSelfHours;
    }

    public void setYxtLearnSelfHours(Double yxtLearnSelfHours) {
        this.yxtLearnSelfHours = yxtLearnSelfHours;
    }

    public Double getYxtLearnAssignedHours() {
        return yxtLearnAssignedHours;
    }

    public void setYxtLearnAssignedHours(Double yxtLearnAssignedHours) {
        this.yxtLearnAssignedHours = yxtLearnAssignedHours;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }
}
