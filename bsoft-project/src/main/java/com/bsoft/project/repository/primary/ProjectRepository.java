package com.bsoft.project.repository.primary;

import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.project.entity.primary.ProjectLookDO;
import com.bsoft.project.entity.primary.ProjectRankDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ProjectRepository {
    ProjectLookDO getProject(String projectId);

    List<ProjectLookDO> getProjectByClueId(@Param("clueId") Integer clueId);

    List<ProjectRankDO> getRankProject(@Param("personId") String personId, @Param("evalDate") Date evalDate);

    List<ProjectBaseDO> getProjectLogCommonProjects(@Param("personId") String personId);

    List<ProjectLookDO> getProjectLookList(@Param("contractNo") String contractNo, @Param("inputContent") String inputContent);

    List<ProjectLookDO> getAllProjectList(@Param("inputContent") String inputContent);
}
