package com.bsoft.attendance.manager;

import com.bsoft.attendance.entity.primary.*;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.project.entity.primary.ProjectDO;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface AttendanceManager {
    public AttendanceDO getAttendance(String personId);

    public AttendanceViewDO getAttendanceView(String personId, java.sql.Date attendanceDate);

    public AttendanceDO getAttendance(String personId, java.sql.Date attendanceDate);

    public List<WorkLogViewDO> getWorkLogViewList(Integer attendanceId);

    public List<WorkLogViewDO> getWorkLogViewListWithout(Integer attendanceId,Integer workLogId);

    public AttendanceDO saveAttendance(AttendanceDO attendance);

    public WorkLogDO saveWorkLog(WorkLogDO workLog);

    public List<WorkLogDO> saveWorkLog(List<WorkLogDO> workLogs);

    public void deleteWorkLog(Integer id);

    public void deleteWorkLogWithoutTransactional(Integer id);

    public List<ProjectDO>  getUsefulProject(String personId);

    public List<HouseDO> getUsefulHouse(String personId);

    public AttendanceWholeDO saveAttendanceWhole(AttendanceDO attendance, List<WorkLogDO> workLogs);

    public AttendanceViewDO getAttendanceView(String personId);

    public WorkLogDO saveWorkLog(String personid,WorkLogDO workLog,java.sql.Date attendanceDate);

    public List<WorkLogDO> getWorkLogList(Integer attendanceId);

    public WorkLogDO saveWorkLog(String personid,WorkLogDO workLog);

    public WorkLogDO saveWorkLog(AttendanceDO attendance,WorkLogDO workLog);

    public WorkLogDO saveWorkLogWithTransactional(AttendanceDO attendance,WorkLogDO workLog);

    public List<AttendanceDO> getAttendanceList(String personId,Integer days);

    public Page<AttendanceViewDO> getAttendanceList(String personId, Date start, Date end, Integer page, Integer size);

    public WorkLogDO getWorkLog(Integer id);

    void generateAttendance();

    List<AttendanceViewDO> getMonthAttendance(String personId);

    void updateAttendance(AttendanceViewDO attendanceViewDO);

    List<AttendanceViewDO> getAttendanceByDays(String personId,Integer days);

    List<AttendanceDO> getNeedUpdateAttendanceRecord(List<String> personIds,java.sql.Date attenanceDate);

    List<AttendanceDO> getNeedUpdateLactationAttendanceRecord(List<String> personIds, java.sql.Date attenanceDate);

    void saveAll(List<AttendanceDO> attendanceDOS);

    //人员调动，更新考勤的部门信息
    void updateDept(String bmdm, String yggh, Date kqrq);
}
