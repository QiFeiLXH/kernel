package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.ProjectAllByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByYearDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:38
 * @Version 1.0
 * @Description
 */
public interface ProjectLevelManager {

    PageInfo<ProjectAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-全部-小计

    List<ProjectAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear);//项目级-全部-小计

    Page<ProjectAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-全部-年度

    List<ProjectAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear);//项目级-全部-年度

    Page<ProjectAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-全部-月度

    List<ProjectAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);//项目级-全部-月度

    PageInfo<ProjectDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-按产生部门类型-小计

    List<ProjectDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear);//项目级-按产生部门类型-小计

    Page<ProjectDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-按产生部门类型-年度

    List<ProjectDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);//项目级-按产生部门类型-年度

    Page<ProjectDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目级-按产生部门类型-月度

    List<ProjectDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);//项目级-按产生部门类型-月度
}
