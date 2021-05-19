package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ProjectLevelWorkloadManager;
import com.bsoft.project.report.service.ProjectLevelWorkloadService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:30
 * @Version 1.0
 * @Description
 */
@Service
public class ProjectLevelWorkloadServiceImpl implements ProjectLevelWorkloadService {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLevelWorkloadServiceImpl.class);
    @Autowired
    private ProjectLevelWorkloadManager projectLevelWorkloadManager;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ProjectLevelworkloadAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllDO> results = projectLevelWorkloadManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllDTO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllDO> results = projectLevelWorkloadManager.findAllSubTotalList(startYear,endYear);
        List<ProjectLevelworkloadAllDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelworkloadAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllByYearDO> results = projectLevelWorkloadManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllByYearDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByYearDO> results = projectLevelWorkloadManager.findAllGroupByYearList(startYear,endYear);
        List<ProjectLevelworkloadAllByYearDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelworkloadAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllByMonthDO> results = projectLevelWorkloadManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllByMonthDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByMonthDO> results = projectLevelWorkloadManager.findAllGroupByMonthList(startYear,endYear);
        List<ProjectLevelworkloadAllByMonthDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllByDepDO> results = projectLevelWorkloadManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllByDepDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepDO> results = projectLevelWorkloadManager.findDepTypeSubTotalList(startYear,endYear);
        List<ProjectLevelworkloadAllByDepDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllByDepByYearDO> results = projectLevelWorkloadManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllByDepByYearDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepByYearDO> results = projectLevelWorkloadManager.findDepTypeGroupByYearList(startYear,endYear);
        List<ProjectLevelworkloadAllByDepByYearDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelworkloadAllByDepByMonthDO> results = projectLevelWorkloadManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelworkloadAllByDepByMonthDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepByMonthDO> results = projectLevelWorkloadManager.findDepTypeGroupByMonthList(startYear,endYear);
        List<ProjectLevelworkloadAllByDepByMonthDTO> result = generatorUtil.convert(results,ProjectLevelworkloadAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-项目级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }
}
