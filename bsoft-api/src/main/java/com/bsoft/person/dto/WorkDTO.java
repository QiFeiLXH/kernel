package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkDTO implements Serializable {
    private Integer id;
    private Integer zpid;
    private String personId;
    private Date startDate;
    private Date endDate;
    //单位
    private String company;
    //职务
    private String post;
    //离职原因
    private String reason;
    //是否实习
    private Integer isInternship;

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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIsInternship() {
        return isInternship;
    }

    public void setIsInternship(Integer isInternship) {
        this.isInternship = isInternship;
    }
}
