package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectWorkLogSituationDTO implements Serializable {
    private Date attendanceDate;
    private Integer flag;
    private Date submitDate;

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

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
