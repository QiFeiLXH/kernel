package com.bsoft.attendance.entity.primary;

import com.bsoft.attendance.key.AttendanceCountKey;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 17:45
 * @Description:
 */
@Entity
@IdClass(AttendanceCountKey.class)
@Table(name = "bsoftmis.T_KQQK")
public class AttendanceCountDO {
    @Id
    @Column(name = "KQYF")
    private Date attendanceMonth;
    @Id
    @Column(name = "YGGH")
    private String personId;
    @Id
    @Column(name = "KQDM")
    private Integer attendanceType;
    @Column(name = "BMDM")
    private String dept;
    @Column(name = "KQTS")
    private Double attendanceDays;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(Double attendanceDays) {
        this.attendanceDays = attendanceDays;
    }
}
