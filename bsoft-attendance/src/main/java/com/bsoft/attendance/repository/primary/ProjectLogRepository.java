package com.bsoft.attendance.repository.primary;

import com.bsoft.attendance.entity.primary.*;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProjectLogRepository {
    List<ProjectLogSituationDO> getProjectWorkLogSituation(@Param("personId") String personId, @Param("days")Integer days);

    List<ProjectLogDO> getProjectWorkLogs(@Param("projectId") String projectId, @Param("submitter") String submitter, @Param("milepostId") Integer milepostId, @Param("attendanceDate") Date attendanceDate);

    List<ProjectLogDO> getProjectWorkLogsWithNoTechnum(@Param("projectId")String projectId,@Param("attendanceDate")Date attendanceDate,@Param("submitter")String submitter);

    List<ProjectBaseDO> searchProjectsWithCommon(@Param("personId") String personId,@Param("context") String context);

    List<Map<String, Object>> getRegionAuditCount();

    List<ProjectWithAuditDO> getProjectWithAudit(@Param("data") Map<String,Object> data);

    Integer getProjectWithAuditCount(String userId);

    List<ProjectLogQueryProjectDO> getProjectLogQueryProjectList(@Param("userId")String userId, @Param("startDate")String startDate, @Param("endDate")String endDate);

    List<ProjectLogNextAuditterUpdateDO> getDifferentProjectManagerFromNextAuditterLogList();
}
