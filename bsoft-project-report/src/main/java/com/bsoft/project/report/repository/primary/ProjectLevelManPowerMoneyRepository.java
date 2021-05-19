package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectLevelManPowerMoneyRepository {
    List<ProjectLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear);
    List<ProjectLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear);
    List<ProjectLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);

    List<ProjectLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
    List<ProjectLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);
    List<ProjectLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
