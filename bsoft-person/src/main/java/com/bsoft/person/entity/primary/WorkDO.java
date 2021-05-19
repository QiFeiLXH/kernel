package com.bsoft.person.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bsoftmis.T_GZQK")
public class WorkDO {
    private Integer id;
    private Integer zpid;
    private String personId;
    private Date startDate;
    private Date endDate;
    //单位
    @Length(max = 16,message = "工作单位长度不能超过16位")
    private String company;
    //职务
    @Length(max = 10,message = "岗位职务不能超过10位")
    private String post;
    //离职原因
    @Length(max = 16,message = "离职原因长度不能超过16位")
    private String reason;
    //是否实习 1是，0否
    private Integer isInternship;

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

    @Column(name = "yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    @Column(name = "gzdw")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "gwzw")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "lzyy")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "isInternship")
    public Integer getIsInternship() {
        return isInternship;
    }

    public void setIsInternship(Integer isInternship) {
        this.isInternship = isInternship;
    }
}
