package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2020/6/3
 * @Description:记录T等级情况
 */
@Entity
@Table(name = "bsoftmis.t_tjqk")
public class EmploySubmissionDO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "yggh")
    private String personId;

    @Column(name = "thdj")
    private String personClass;

    @Column(name = "tjrq")
    private Date startDate;

    @Column(name = "djry")
    private String registrant;

    @Column(name = "djrq")
    private Date registDate;

    @Column(name = "tzlx")
    private String type;

    @Column(name = "kqbz")
    private Integer flag;

    @Column(name = "xtcs")
    private Integer systemParam;

    @Column(name = "zpid")
    private Integer recruitmentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonClass() {
        return personClass;
    }

    public void setPersonClass(String personClass) {
        this.personClass = personClass;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getSystemParam() {
        return systemParam;
    }

    public void setSystemParam(Integer systemParam) {
        this.systemParam = systemParam;
    }

    public Integer getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(Integer recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
