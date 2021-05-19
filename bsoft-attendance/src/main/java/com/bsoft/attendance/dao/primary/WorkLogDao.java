package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.WorkLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkLogDao extends JpaRepository<WorkLogDO,Integer>, JpaSpecificationExecutor<WorkLogDO> {
    public List<WorkLogDO> findByAttendanceId(Integer attendanceId);

    @Query("SELECT DISTINCT A.projectId FROM WorkLogDO A,AttendanceDO B WHERE A.attendanceId = B.id AND B.personId = :personId AND B.attendanceDate >= SYSDATE - 7")
    public List<String> getUserfulProject(@Param("personId") String personId);

    @Modifying
    @Query("update WorkLogDO set verifyFlag = :verifyFlag,verifyHours = :verifyHours,verifyRemark = :verifyRemark,verifier = :verifier,verifyDate = sysdate where id = :workLogId")
    public void verifyWorkLog(@Param("workLogId") Integer workLogId,@Param("verifyFlag") Integer verifyFlag,@Param("verifyHours") Double verifyHours,@Param("verifyRemark") String verifyRemark,@Param("verifier") String verifier);
}
