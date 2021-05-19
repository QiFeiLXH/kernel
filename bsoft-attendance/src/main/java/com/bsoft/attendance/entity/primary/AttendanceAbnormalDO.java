package com.bsoft.attendance.entity.primary;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 15:58
 * @Description: 考勤异常DO
 */
public class AttendanceAbnormalDO {
    private String personId;
    private String personName;
    private String rq;

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

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }
}
