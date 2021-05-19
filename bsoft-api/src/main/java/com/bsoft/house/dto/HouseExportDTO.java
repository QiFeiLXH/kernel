package com.bsoft.house.dto;

import java.io.Serializable;
import java.util.Date;

public class HouseExportDTO implements Serializable {
    private Integer id;
    private Integer status;
    private Date stratDate;
    private Date endDate;
    private String person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStratDate() {
        return stratDate;
    }

    public void setStratDate(Date stratDate) {
        this.stratDate = stratDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
