package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;


public class WorkCertificateDTO implements Serializable {
    private Integer id;
    private String personId;
    private Date getDate;
    private String cerName;
    private String cerNum;
    private String organ;
    private Integer enclosure;

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

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getCerName() {
        return cerName;
    }

    public void setCerName(String cerName) {
        this.cerName = cerName;
    }

    public String getCerNum() {
        return cerNum;
    }

    public void setCerNum(String cerNum) {
        this.cerNum = cerNum;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public Integer getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Integer enclosure) {
        this.enclosure = enclosure;
    }
}
