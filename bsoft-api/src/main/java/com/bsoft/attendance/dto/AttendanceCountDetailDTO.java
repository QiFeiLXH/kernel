package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/21 14:38
 * @Description:
 */
public class AttendanceCountDetailDTO implements Serializable {
    private String personId;
    private String personName;
    private Date attendanceDate;
    private Date goWorkTime;
    private Date offWorkTime;
    private String attendanceTypeAm;
    private String attendanceTypeAmText;
    private String attendanceTypeBm;
    private String attendanceTypeBmText;
    private String supplementNotes;
    private String AttendanceNotes;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getGoWorkTime() {
        return goWorkTime;
    }

    public void setGoWorkTime(Date goWorkTime) {
        this.goWorkTime = goWorkTime;
    }

    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    public String getAttendanceTypeAm() {
        return attendanceTypeAm;
    }

    public void setAttendanceTypeAm(String attendanceTypeAm) {
        this.attendanceTypeAm = attendanceTypeAm;
    }

    public String getAttendanceTypeAmText() {
        return attendanceTypeAmText;
    }

    public void setAttendanceTypeAmText(String attendanceTypeAmText) {
        this.attendanceTypeAmText = attendanceTypeAmText;
    }

    public String getAttendanceTypeBm() {
        return attendanceTypeBm;
    }

    public void setAttendanceTypeBm(String attendanceTypeBm) {
        this.attendanceTypeBm = attendanceTypeBm;
    }

    public String getAttendanceTypeBmText() {
        return attendanceTypeBmText;
    }

    public void setAttendanceTypeBmText(String attendanceTypeBmText) {
        this.attendanceTypeBmText = attendanceTypeBmText;
    }

    public String getSupplementNotes() {
        return supplementNotes;
    }

    public void setSupplementNotes(String supplementNotes) {
        this.supplementNotes = supplementNotes;
    }

    public String getAttendanceNotes() {
        return AttendanceNotes;
    }

    public void setAttendanceNotes(String attendanceNotes) {
        AttendanceNotes = attendanceNotes;
    }
}
