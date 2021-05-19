package com.bsoft.attendance.key;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 17:51
 * @Description:
 */
public class AttendanceCountKey implements Serializable {
    private Date attendanceMonth;
    private String personId;
    private Integer attendanceType;

    public Date getAttendanceMonth() {
        return attendanceMonth;
    }

    public void setAttendanceMonth(Date attendanceMonth) {
        this.attendanceMonth = attendanceMonth;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(Integer attendanceType) {
        this.attendanceType = attendanceType;
    }
}
