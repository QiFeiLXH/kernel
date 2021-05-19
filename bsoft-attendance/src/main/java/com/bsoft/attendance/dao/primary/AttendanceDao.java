package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceDao extends JpaRepository<AttendanceDO,Integer>, JpaSpecificationExecutor<AttendanceDO> {
    @Query(value = "SELECT a FROM AttendanceDO a WHERE a.attendanceDate = :attendanceDate AND a.personId = :personId")
    public AttendanceDO getAttendance(@Param("attendanceDate") Date attendanceDate, @Param("personId") String personId);

    @Query("select a from AttendanceDO  a where a.personId = :personId and a.attendanceDate >= sysdate - :days order by a.id desc")
    public List<AttendanceDO> getAttendanceList(@Param("personId") String personid,@Param("days") Integer days);

    @Query("SELECT distinct a.rentId FROM AttendanceDO a WHERE a.personId = :personId AND a.attendanceDate >= SYSDATE - 7")
    public List<Integer> getUsefulHouse(@Param("personId") String personId);

    @Procedure(procedureName = "pd_ker_attendance")
    void generateAttendance();

    @Modifying
    @Query("update AttendanceDO a set a.dept = :bmdm where a.personId = :yggh and a.attendanceDate >= :kqrq")
    void updateDept(@Param("bmdm") String bmdm,@Param("yggh") String yggh,@Param("kqrq") Date kqrq);
}
