package com.bsoft.project.repository.primary;

import com.bsoft.project.condition.ProjectPlanQueryCnd;
import com.bsoft.project.entity.primary.ProjectLogPlanDetailDO;
import com.bsoft.project.entity.primary.ProjectWithPlanDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ProjectPlanRepository {
   List<ProjectLogPlanDetailDO> getProjectLogPlanDetail(@Param("projectId") String projectId,@Param("personId") String personId, @Param("attendanceDate") Date attendanceDate,@Param("part") Integer part);
   Integer getProjectLogPlanCount(@Param("projectId") String projectId);
   List<ProjectLogPlanDetailDO> getProjectLogPlanDetailQuery(@Param("contractNo") String contractNo, @Param("part")Integer part);
   List<ProjectWithPlanDO> getProjectWithPlansAndAuth(@Param("cnds") ProjectPlanQueryCnd cnds);
}
