package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.AttendanceViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceViewDao extends JpaRepository<AttendanceViewDO,Integer>, JpaSpecificationExecutor<AttendanceViewDO> {
    @Query(value = "SELECT a FROM AttendanceViewDO a WHERE a.attendanceDate = :attendanceDate AND a.personId = :personId")
    public AttendanceViewDO getAttendance(@Param("attendanceDate") Date attendanceDate, @Param("personId") String personId);

    @Query(value = "SELECT a FROM AttendanceViewDO a WHERE to_char(a.attendanceDate,'yyyy-mm') = :month AND a.personId = :personId  and " +
            "(a.nonWorkIngFlag = 0 or (a.nonWorkIngFlag = 1 and (a.goWorkTime != null or a.offWorkTime != null))) order by a.attendanceDate desc")
    public List<AttendanceViewDO> getMonthAttendance(@Param("month") String month, @Param("personId") String personId);

    @Query("select a from AttendanceViewDO  a where a.personId = :personId and a.attendanceDate >= sysdate - :days order by a.attendanceDate desc")
    public List<AttendanceViewDO> getAttendanceList(@Param("personId") String personid, @Param("days") Integer days);
}
