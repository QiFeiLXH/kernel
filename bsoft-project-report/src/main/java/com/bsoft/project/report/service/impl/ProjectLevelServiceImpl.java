package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.dto.ProjectAllByMonthDTO;
import com.bsoft.project.report.dto.ProjectAllSubTotalDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByYearDTO;
import com.bsoft.project.report.entity.primary.ProjectAllByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByYearDO;
import com.bsoft.project.report.manager.ProjectLevelManager;
import com.bsoft.project.report.service.ProjectLevelService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:18
 * @Version 1.0
 * @Description
 */
@Service
public class ProjectLevelServiceImpl implements ProjectLevelService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectLevelServiceImpl.class);
    @Autowired
    private ProjectLevelManager projectLevelManager;
    @Autowired
    private IGenerator iGenerator;

    //项目级-全部-小计
    @Override
    public Result<ProjectAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectAllSubTotalDO> results = projectLevelManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectAllSubTotalDTO.class);
    }

    //项目级-全部-小计
    @Override
    public List<ProjectAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectAllSubTotalDO> results = projectLevelManager.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectAllSubTotalDTO.class);
    }

    //项目级-全部-年度
    @Override
    public Result<ProjectAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectAllSubTotalDO> results = projectLevelManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectAllSubTotalDTO.class);
    }

    //项目级-全部-小计
    @Override
    public List<ProjectAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectAllSubTotalDO> results = projectLevelManager.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectAllSubTotalDTO.class);
    }

    //项目级-全部-月度
    @Override
    public Result<ProjectAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectAllByMonthDO> results = projectLevelManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectAllByMonthDTO.class);
    }

    @Override
    public List<ProjectAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectAllByMonthDO> results = projectLevelManager.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectAllByMonthDTO.class);
    }

    //项目级-按产生部门类型-小计
    @Override
    public Result<ProjectDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectDepTypeByYearDO> results = projectLevelManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectDepTypeByYearDTO.class);
    }

    @Override
    public List<ProjectDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDepTypeByYearDO> results = projectLevelManager.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectDepTypeByYearDTO.class);
    }

    //项目级-按产生部门类型-年度
    @Override
    public Result<ProjectDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDepTypeByYearDO> results = projectLevelManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectDepTypeByYearDTO.class);
    }

    @Override
    public List<ProjectDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDepTypeByYearDO> results = projectLevelManager.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectDepTypeByYearDTO.class);
    }

    //项目级-按产生部门类型-月度
    @Override
    public Result<ProjectDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDepTypeByMonthDO> results = projectLevelManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ProjectDepTypeByMonthDTO.class);
    }

    @Override
    public List<ProjectDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDepTypeByMonthDO> results = projectLevelManager.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目级-按产生部门类型-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ProjectDepTypeByMonthDTO.class);
    }
}
