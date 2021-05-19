package com.bsoft.project.entity.primary;

import java.util.Date;

public class ProjectWorkLogSituationDO {
    private Date attendanceDate;
    private Integer flag;

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
}
