package com.bsoft.work.dto;

import java.io.Serializable;

public class MeetPersonDTO implements Serializable{
    private Integer id;
    private Integer meetId;
    private String mobileNo;
    private String personName;
    /** 导入失败原因（用于导入导出）*/
    private String failReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeetId() {
        return meetId;
    }

    public void setMeetId(Integer meetId) {
        this.meetId = meetId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
