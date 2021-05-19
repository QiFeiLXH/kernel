package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 9:53
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface ProjectLevelWorkloadRepository {
    List<ProjectLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear);
    List<ProjectLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear);
    List<ProjectLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);

    List<ProjectLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
    List<ProjectLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);
    List<ProjectLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
