package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogAuditDO;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.attendance.entity.primary.ProjectLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectLogDao extends JpaRepository<ProjectLogDO,Integer>, JpaSpecificationExecutor<ProjectLogDO> {
    List<ProjectLogDO> getByMilepostIdIn(List<Integer> milePostId);

    @Query("select a from ProjectBaseDO a,ProjectLogDO b where a.projectId = b.projectId and b.id = (select max(c.id) from ProjectLogDO c where c.submitter = :personId)")
    ProjectBaseDO getLastestProjectBase(@Param("personId") String personId);

    @Modifying
    @Query("update ProjectLogAuditDO set nextAuditter =:#{#projectLogAudit.nextAuditter},lastestOperate=:#{#projectLogAudit.lastestOperate},auditter = :#{#projectLogAudit.auditter},auditDate  = :#{#projectLogAudit.auditDate},auditFlag = :#{#projectLogAudit.auditFlag},refuse = :#{#projectLogAudit.refuse},auditType = :#{#projectLogAudit.auditType},remark = :#{#projectLogAudit.remark} where id = :#{#projectLogAudit.id}")
    void auditProjectLog(@Param("projectLogAudit") ProjectLogAuditDO projectLogAudit);

    int countBySubmitterAndAttendanceDate(String submitter, Date attendanceDate);

    @Modifying
    @Query("update ProjectLogDO set nextAuditter=null,auditType = 4 where auditType = 0 and lastestOperate < sysdate - 2")
    void endProjectLog();

    @Query("select a from ProjectLogDO a where a.auditType = 0 and a.lastestOperate < sysdate - 2")
    List<ProjectLogDO> getNeedEndProjectLog();

    @Query("select a from ProjectLogDO a where a.auditType not in (0,4) and  (a.lastestOperate < sysdate - 3 or (a.lastestOperate is null and a.submitDate < sysdate - 3))")
    List<ProjectLogDO> getNeedEndAuditProjectLog();

    @Modifying
    @Query("update ProjectLogDO set  nextAuditter=null,auditType = 4 where auditType not in (0,4) and  (lastestOperate < sysdate - 3 or (lastestOperate is null and submitDate < sysdate - 3))")
    void endAuditProjectLog();

    @Modifying
    @Query(value = "update ProjectLogDO set auditType = 2  where id in :ids")
    void setAuditTypeWithProjectManager(@Param("ids") List<Integer> ids);

    @Modifying
    @Query(value = "update ProjectLogDO set auditType = 2,nextAuditter = :nextAuditter  where id = :id")
    void setAuditTypeWithProjectManager(@Param("id") Integer id,@Param("nextAuditter")String nextAuditter);

    @Modifying
    @Query(value = "update ProjectLogDO set auditType = 1  where id in :ids")
    void setAuditTypeWithGroupLeader(@Param("ids") List<Integer> ids);

    @Modifying
    @Query(value = "update ProjectLogDO set auditType = 1,nextAuditter = :nextAuditter  where id = :id")
    void setAuditTypeWithGroupLeader(@Param("id") Integer id,@Param("nextAuditter")String nextAuditter);

    Integer countBySubmitter(String submitter);
}
