package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByYearDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:44
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface ProjectLevelRepository {
    List<ProjectAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear);

    List<ProjectDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
}
