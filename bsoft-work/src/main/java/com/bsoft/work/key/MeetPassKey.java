package com.bsoft.work.key;

import java.io.Serializable;

public class MeetPassKey implements Serializable {
    private String mobileNo;
    private Integer meetId;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getMeetId() {
        return meetId;
    }

    public void setMeetId(Integer meetId) {
        this.meetId = meetId;
    }
}
