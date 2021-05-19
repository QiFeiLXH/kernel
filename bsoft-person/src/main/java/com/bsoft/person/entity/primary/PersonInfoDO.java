package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bsoftmis.sys_person_info")
public class PersonInfoDO {
    private String personId;
    private Integer logoff;
    private Integer rank;
    private Integer rankSequence;
    //考勤方式 1.考勤机 2.APP
    private Integer attendFlag;
    private Integer costType;

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "flag")
    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRankSequence() {
        return rankSequence;
    }

    public void setRankSequence(Integer rankSequence) {
        this.rankSequence = rankSequence;
    }

    public Integer getAttendFlag() {
        return attendFlag;
    }

    public void setAttendFlag(Integer attendFlag) {
        this.attendFlag = attendFlag;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }
}
