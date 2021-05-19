package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.ProjectLevelworkloadAllDTO;
import com.bsoft.project.report.entity.primary.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 9:55
 * @Version 1.0
 * @Description
 */
public interface ProjectLevelWorkloadManager {

    Result<ProjectLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-全部-小计
    List<ProjectLevelworkloadAllDO> findAllSubTotalList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-全部-小计 列表

    Result<ProjectLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-全部-年度
    List<ProjectLevelworkloadAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-全部-年度 列表

    Result<ProjectLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-全部-月度
    List<ProjectLevelworkloadAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-全部-月度 列表

    Result<ProjectLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-按产生部门类型-小计
    List<ProjectLevelworkloadAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-按产生部门类型-小计 列表

    Result<ProjectLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-按产生部门类型-年度
    List<ProjectLevelworkloadAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-按产生部门类型-年度 列表

    Result<ProjectLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-项目级-按产生部门类型-月度
    List<ProjectLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);//人力成本-工作量-项目级-按产生部门类型-月度 列表
}
