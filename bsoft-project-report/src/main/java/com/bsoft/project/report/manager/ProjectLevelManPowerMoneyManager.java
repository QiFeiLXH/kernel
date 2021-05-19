package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.*;

import java.util.List;

public interface ProjectLevelManPowerMoneyManager {
    Result<ProjectLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllDO> findAllSubTotalList(Integer startYear, Integer endYear);

    Result<ProjectLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear);

    Result<ProjectLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    Result<ProjectLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    Result<ProjectLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);


    Result<ProjectLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ProjectLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
