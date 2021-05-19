package com.bsoft.hr.dto;

import com.bsoft.person.dto.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RankBaseDTO implements Serializable {
    private Integer year;
    private String personId;
    private Integer photoId;
    private String postSequence;
    private Integer grade;
    private Integer declareGrade;
    private Date declareDate;
    private Integer evalResult;
    private Date evaldate;
    private String leaderOpinion;
    private String expertOpinion;
    private Integer ppt;
    private Double evalScore;
    private List<EducationDTO> schools;
    private List<WorkDTO> works;
    private List<KnowledgeDTO> knowledge;
    private List<WorkCertificateDTO> certificate;
    private List<AwardDTO> award;
    private List<ContinueLearnDTO> continuelearn;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPostSequence() {
        return postSequence;
    }

    public void setPostSequence(String postSequence) {
        this.postSequence = postSequence;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getEvaldate() {
        return evaldate;
    }

    public void setEvaldate(Date evaldate) {
        this.evaldate = evaldate;
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

    public List<EducationDTO> getSchools() {
        return schools;
    }

    public void setSchools(List<EducationDTO> schools) {
        this.schools = schools;
    }

    public List<WorkDTO> getWorks() {
        return works;
    }

    public void setWorks(List<WorkDTO> works) {
        this.works = works;
    }

    public List<KnowledgeDTO> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<KnowledgeDTO> knowledge) {
        this.knowledge = knowledge;
    }

    public List<WorkCertificateDTO> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<WorkCertificateDTO> certificate) {
        this.certificate = certificate;
    }

    public List<AwardDTO> getAward() {
        return award;
    }

    public void setAward(List<AwardDTO> award) {
        this.award = award;
    }

    public List<ContinueLearnDTO> getContinuelearn() {
        return continuelearn;
    }

    public void setContinuelearn(List<ContinueLearnDTO> continuelearn) {
        this.continuelearn = continuelearn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDeclareGrade() {
        return declareGrade;
    }

    public void setDeclareGrade(Integer declareGrade) {
        this.declareGrade = declareGrade;
    }

    public Date getDeclareDate() {
        return declareDate;
    }

    public void setDeclareDate(Date declareDate) {
        this.declareDate = declareDate;
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
}
