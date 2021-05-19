package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.util.List;

public class AttendanceWholeDTO implements Serializable {
    private AttendanceDTO attendanceDTO;
    private List<WorkLogDTO> workLogList;

    public AttendanceWholeDTO(){

    }

    public AttendanceWholeDTO(AttendanceDTO attendanceDTO,List<WorkLogDTO> workLogList){
        this.attendanceDTO = attendanceDTO;
        this.workLogList = workLogList;
    }

    public AttendanceDTO getAttendanceDTO() {
        return attendanceDTO;
    }

    public void setAttendanceDTO(AttendanceDTO attendanceDTO) {
        this.attendanceDTO = attendanceDTO;
    }

    public List<WorkLogDTO> getWorkLogList() {
        return workLogList;
    }

    public void setWorkLogList(List<WorkLogDTO> workLogList) {
        this.workLogList = workLogList;
    }
}
