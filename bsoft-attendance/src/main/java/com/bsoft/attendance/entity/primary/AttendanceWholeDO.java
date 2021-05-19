package com.bsoft.attendance.entity.primary;
import java.util.List;

public class AttendanceWholeDO {
    private AttendanceDO attendanceDO;
    private List<WorkLogDO> workLogList;

    public AttendanceWholeDO(){

    }

    public AttendanceWholeDO(AttendanceDO attendanceDO, List<WorkLogDO> workLogList){
        this.attendanceDO = attendanceDO;
        this.workLogList = workLogList;
    }

    public AttendanceDO getAttendanceDO() {
        return attendanceDO;
    }

    public void setAttendanceDTO(AttendanceDO attendanceDO) {
        this.attendanceDO = attendanceDO;
    }

    public List<WorkLogDO> getWorkLogList() {
        return workLogList;
    }

    public void setWorkLogList(List<WorkLogDO> workLogList) {
        this.workLogList = workLogList;
    }
}
