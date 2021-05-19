package com.bsoft.hr.entity.primary;

import com.bsoft.person.dto.*;
import com.bsoft.person.entity.primary.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bsoftmis.rs_zjqk")
public class RankDO {

    private Integer year;
    private Integer id;
    private String personId;
    private Integer photoId;
    private Integer rankSequence;
    private String postSequence;
    private Date declareDate;
    private Integer grade;
    private Integer declareGrade;
    private Date evaldate;
    private Integer evalResult;
    private String leaderOpinion;
    private String expertOpinion;
    private Integer ppt;
    private Double evalScore;
    private Date execDate;
    private List<EducationDO> schools;
    private List<WorkDO> works;
    private List<KnowledgeDO> knowledge;
    private List<WorkCertificateDO> certificate;
    private List<AwardDO> award;
    private List<ContinueLearnDO> continuelearn;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "ranksequence")
    public String getPostSequence() {
        return postSequence;
    }

    public void setPostSequence(String postSequence) {
        this.postSequence = postSequence;
    }

    @Column(name = "zyzj")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Column(name = "djrq")
    public Date getEvaldate() {
        return evaldate;
    }

    public void setEvaldate(Date evaldate) {
        this.evaldate = evaldate;
    }

    @Column(name = "zjxl")
    public Integer getRankSequence() {
        return rankSequence;
    }

    public void setRankSequence(Integer rankSequence) {
        this.rankSequence = rankSequence;
    }

    @Column(name = "zxrq1")
    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
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

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
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

    public Integer getDeclareGrade() {
        return declareGrade;
    }

    public void setDeclareGrade(Integer declareGrade) {
        this.declareGrade = declareGrade;
    }

    public Integer getEvalResult() {
        return evalResult;
    }

    public void setEvalResult(Integer evalResult) {
        this.evalResult = evalResult;
    }

    public Integer getPpt() {
        return ppt;
    }

    public void setPpt(Integer ppt) {
        this.ppt = ppt;
    }

    public Double getEvalScore() {
        return evalScore;
    }

    public void setEvalScore(Double evalScore) {
        this.evalScore = evalScore;
    }

    @Transient
    public List<EducationDO> getSchools() {
        return schools;
    }

    public void setSchools(List<EducationDO> schools) {
        this.schools = schools;
    }

    @Transient
    public List<WorkDO> getWorks() {
        return works;
    }

    public void setWorks(List<WorkDO> works) {
        this.works = works;
    }

    @Transient
    public List<KnowledgeDO> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<KnowledgeDO> knowledge) {
        this.knowledge = knowledge;
    }

    @Transient
    public List<WorkCertificateDO> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<WorkCertificateDO> certificate) {
        this.certificate = certificate;
    }

    @Transient
    public List<AwardDO> getAward() {
        return award;
    }

    public void setAward(List<AwardDO> award) {
        this.award = award;
    }

    @Transient
    public List<ContinueLearnDO> getContinuelearn() {
        return continuelearn;
    }

    public void setContinuelearn(List<ContinueLearnDO> continuelearn) {
        this.continuelearn = continuelearn;
    }
}
