package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EducationDTO implements Serializable {
    private Integer id;
    private Integer zpid;

    //开始日期
    private Date startDate;
    //结束日期
    private Date endDate;
    //院校
    private Integer school;
    private String schoolText;

    //专业
    private Integer major;
    private String majorText;

    //职务
    private String post;
    //学历证书
    private Integer diploma;
    //学位证书
    private Integer academicDegree;
    //学历
    private Integer education;
    private String educationText;

    //学校名称
    private String schoolName;
    //专业名称
    private String majorName;
    //其他证书
    private List<CertificateDTO> others;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
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

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public String getSchoolText() {
        return schoolText;
    }

    public void setSchoolText(String schoolText) {
        this.schoolText = schoolText;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public String getMajorText() {
        return majorText;
    }

    public void setMajorText(String majorText) {
        this.majorText = majorText;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getDiploma() {
        return diploma;
    }

    public void setDiploma(Integer diploma) {
        this.diploma = diploma;
    }

    public Integer getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(Integer academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getEducationText() {
        return educationText;
    }

    public void setEducationText(String educationText) {
        this.educationText = educationText;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<CertificateDTO> getOthers() {
        return others;
    }

    public void setOthers(List<CertificateDTO> others) {
        this.others = others;
    }
}
