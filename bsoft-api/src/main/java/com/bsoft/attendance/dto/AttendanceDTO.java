package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.Date;

public class AttendanceDTO implements Serializable {
    private Integer id; //考勤ID
    private String personId; //员工工号
    private Date attendanceDate; //考勤日期
    private Integer flag; //提交类型
    private String workLog; //工作日志
    private Date submitDate; //日志提交时间
    private Integer rentId; //租房ID
    private Integer evection; //出差标志
    private Integer stay;  //住宿情况
    private String rentName;//租房名称
    private Boolean workDay;//工作日

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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getEvection() {
        return evection;
    }

    public void setEvection(Integer evection) {
        this.evection = evection;
    }

    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }


    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public Boolean getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Boolean workDay) {
        this.workDay = workDay;
    }
}
