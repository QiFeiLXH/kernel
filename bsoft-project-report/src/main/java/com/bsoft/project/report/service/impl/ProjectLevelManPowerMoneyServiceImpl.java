package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ProjectLevelManPowerMoneyManager;
import com.bsoft.project.report.service.ProjectLevelManPowerMoneyService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProjectLevelManPowerMoneyServiceImpl implements ProjectLevelManPowerMoneyService {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLevelManPowerMoneyServiceImpl.class);
    @Autowired
    private ProjectLevelManPowerMoneyManager projectLevelManPowerMoneyManager;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ProjectLevelManPowerMoneyAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllDO> results = projectLevelManPowerMoneyManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllDTO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllDO> results = projectLevelManPowerMoneyManager.findAllSubTotalList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllByYearDO> results = projectLevelManPowerMoneyManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllByYearDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByYearDO> results = projectLevelManPowerMoneyManager.findAllGroupByYearList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllByYearDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllByMonthDO> results = projectLevelManPowerMoneyManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllByMonthDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByMonthDO> results = projectLevelManPowerMoneyManager.findAllGroupByMonthList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllByMonthDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllByDepDO> results = projectLevelManPowerMoneyManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllByDepDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepDO> results = projectLevelManPowerMoneyManager.findDepTypeSubTotalList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllByDepDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllByDepByYearDO> results = projectLevelManPowerMoneyManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllByDepByYearDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepByYearDO> results = projectLevelManPowerMoneyManager.findDepTypeGroupByYearList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllByDepByYearDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectLevelManPowerMoneyAllByDepByMonthDO> results = projectLevelManPowerMoneyManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ProjectLevelManPowerMoneyAllByDepByMonthDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepByMonthDO> results = projectLevelManPowerMoneyManager.findDepTypeGroupByMonthList(startYear,endYear);
        List<ProjectLevelManPowerMoneyAllByDepByMonthDTO> result = generatorUtil.convert(results,ProjectLevelManPowerMoneyAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-项目级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }
}
