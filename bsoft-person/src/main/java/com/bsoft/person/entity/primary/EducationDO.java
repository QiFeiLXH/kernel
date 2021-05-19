package com.bsoft.person.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 教育经历
 */
@Entity
@Table(name = "bsoftmis.T_XXQK")
public class EducationDO {
    private Integer id;
    private Integer zpid;

    //开始日期
    private Date startDate;
    //结束日期
    private Date endDate;
    //院校
    private Integer school;
    //专业
    private Integer major;
    //职务
    @Length(max = 10, message = "担任职务长度不能超过10位")
    private String post;
    //学历证书
    private Integer diploma;
    //学位证书
    private Integer academicDegree;
    //学历
    private Integer education;
    //学校名称
    @Length(max = 30, message = "学校名称长度不能超过30位")
    private String schoolName;
    //专业名称
    @Length(max = 30, message = "专业名称长度不能超过30位")
    private String majorName;

    @Id
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

    @Column(name = "qsrq")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "jsrq")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "yxmc")
    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    @Column(name = "sxzy")
    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Column(name = "drzw")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "xlzs")
    public Integer getDiploma() {
        return diploma;
    }

    public void setDiploma(Integer diploma) {
        this.diploma = diploma;
    }

    @Column(name = "xwzs")
    public Integer getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(Integer academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Column(name = "xl")
    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    @Column(name = "yxmcbz")
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(name = "sxzybz")
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
