package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/3 12:29
 * @Description
 */
public class RankDTO implements Serializable {
    private Integer id;
    /** 员工id */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 拼音简码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 职级序列 */
    private Integer rankSequence;
    private String rankSequenceText;
    /** 专业职级 */
    private Integer grade;
    private String gradeText;
    /** 评定日期 */
    private Date evalDate;
    /** 领导意见 */
    private String leaderOpinion;
    /** 专家意见 */
    private String expertOpinion;
    /** 申报职级 */
    private Integer declareGrade;
    private String declareGradeText;
    /** 申报日期 */
    private Date declareDate;
    /** 评分 */
    private Double evalScore;
    /** 评定结果 */
    private Integer evalResult;
    /** 年度 */
    private Integer year;
    /** 文件服务器文件id */
    private Integer pptId;
    /** ppt文件名 */
    private String pptName;

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

    public Integer getRankSequence() {
        return rankSequence;
    }

    public void setRankSequence(Integer rankSequence) {
        this.rankSequence = rankSequence;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    public String getLeaderOpinion() {
        return leaderOpinion;
    }

    public void setLeaderOpinion(String leaderOpinion) {
        this.leaderOpinion = leaderOpinion;
    }

    public String getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(String expertOpinion) {
        this.expertOpinion = expertOpinion;
    }

    public Integer getDeclareGrade() {
        return declareGrade;
    }

    public void setDeclareGrade(Integer declareGrade) {
        this.declareGrade = declareGrade;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getDeclareDate() {
        return declareDate;
    }

    public void setDeclareDate(Date declareDate) {
        this.declareDate = declareDate;
    }

    public Double getEvalScore() {
        return evalScore;
    }

    public void setEvalScore(Double evalScore) {
        this.evalScore = evalScore;
    }

    public Integer getEvalResult() {
        return evalResult;
    }

    public void setEvalResult(Integer evalResult) {
        this.evalResult = evalResult;
    }

    public Integer getPptId() {
        return pptId;
    }

    public void setPptId(Integer pptId) {
        this.pptId = pptId;
    }

    public String getPptName() {
        return pptName;
    }

    public void setPptName(String pptName) {
        this.pptName = pptName;
    }

    public String getRankSequenceText() {
        return rankSequenceText;
    }

    public void setRankSequenceText(String rankSequenceText) {
        this.rankSequenceText = rankSequenceText;
    }

    public String getGradeText() {
        return gradeText;
    }

    public void setGradeText(String gradeText) {
        this.gradeText = gradeText;
    }

    public String getDeclareGradeText() {
        return declareGradeText;
    }

    public void setDeclareGradeText(String declareGradeText) {
        this.declareGradeText = declareGradeText;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }
}
