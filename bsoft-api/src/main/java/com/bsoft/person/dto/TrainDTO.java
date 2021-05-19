package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

public class TrainDTO implements Serializable {
    private String personId;
    private String year;
    private Double train;
    private Double teach;
    private Integer shares;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getTrain() {
        return train;
    }

    public void setTrain(Double train) {
        this.train = train;
    }

    public Double getTeach() {
        return teach;
    }

    public void setTeach(Double teach) {
        this.teach = teach;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }
}
