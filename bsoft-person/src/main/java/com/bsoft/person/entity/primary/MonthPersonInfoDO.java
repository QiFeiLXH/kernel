package com.bsoft.person.entity.primary;

import com.bsoft.person.key.MonthPersonInfoKey;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 14:23
 * @Description:
 */
@Entity
@IdClass(MonthPersonInfoKey.class)
@Table(name = "bsoftmis.RS_RYXX")
public class MonthPersonInfoDO {
    private Date month;
    private String personId;
    private String dept;
    private Integer deptType;
    private Integer jobCategory;
    private Date availableDate;
    private Date departureDate;
    private Integer departureFlag;
    private String departureType;
    private String departureReasons;
    private String post;
    private Integer type;
    private Date checkDate;
    private Integer companyId;
    private String departureTypeReasons;

    @Id
    @Column(name = "tjyf")
    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    @Id
    @Column(name = "yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "bmdm")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Column(name = "bmlb")
    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    @Column(name = "gwdl")
    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    @Column(name = "dzrq")
    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Column(name = "lzrq")
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Column(name = "lzbz")
    public Integer getDepartureFlag() {
        return departureFlag;
    }

    public void setDepartureFlag(Integer departureFlag) {
        this.departureFlag = departureFlag;
    }

    @Column(name = "lzlx")
    public String getDepartureType() {
        return departureType;
    }

    public void setDepartureType(String departureType) {
        this.departureType = departureType;
    }

    @Column(name = "lzyy")
    public String getDepartureReasons() {
        return departureReasons;
    }

    public void setDepartureReasons(String departureReasons) {
        this.departureReasons = departureReasons;
    }

    @Column(name = "gwdm")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "sxs")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "bdrq")
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Column(name = "ssgs")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "LZLXBZ")
    public String getDepartureTypeReasons() {
        return departureTypeReasons;
    }

    public void setDepartureTypeReasons(String departureTypeReasons) {
        this.departureTypeReasons = departureTypeReasons;
    }
}
