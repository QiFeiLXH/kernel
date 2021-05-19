package com.bsoft.person.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/9/2 14:24
 * @Description: Sys_Person_Info DTO
 */
public class PersonInfoDTO implements Serializable {
    private String personId;
    private Integer logoff;
    private Integer rank;
    private Integer rankSequence;
    //考勤方式 1.考勤机 2.APP
    private Integer attendFlag;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

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
}
