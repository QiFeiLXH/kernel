package com.bsoft.person.entity.primary;

import com.bsoft.person.key.TrainKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(TrainKey.class)
@Table(name = "hr_rank_traininfo_view")
public class TrainDO {
    private String personId;
    private String year;
    private Double train;
    private Double teach;
    private Integer shares;

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Id
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
