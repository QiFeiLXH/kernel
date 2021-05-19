package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ProjectLevelManPowerMoneyManager;
import com.bsoft.project.report.repository.primary.ProjectLevelManPowerMoneyRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectLevelManPowerMoneyManagerImpl implements ProjectLevelManPowerMoneyManager {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLevelManPowerMoneyManagerImpl.class);

    @Autowired
    private ProjectLevelManPowerMoneyRepository projectLevelManPowerMoneyRepository;

    @Override
    public Result<ProjectLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllDO> list =  projectLevelManPowerMoneyRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotal",times});
        Result<ProjectLevelManPowerMoneyAllDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllDO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllDO> list =  projectLevelManPowerMoneyRepository.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotalList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllByYearDO> list =  projectLevelManPowerMoneyRepository.findAllGroupByYear(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYear",times});
        Result<ProjectLevelManPowerMoneyAllByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByYearDO> list =  projectLevelManPowerMoneyRepository.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllByMonthDO> list =  projectLevelManPowerMoneyRepository.findAllGroupByMonth(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonth",times});
        Result<ProjectLevelManPowerMoneyAllByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByMonthDO> list =  projectLevelManPowerMoneyRepository.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonthList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllByDepDO> list =  projectLevelManPowerMoneyRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllByDepDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotal",times});
        Result<ProjectLevelManPowerMoneyAllByDepDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepDO> list =  projectLevelManPowerMoneyRepository.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotalList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllByDepByYearDO> list =  projectLevelManPowerMoneyRepository.findDepTypeGroupByYear(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllByDepByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYear",times});
        Result<ProjectLevelManPowerMoneyAllByDepByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepByYearDO> list =  projectLevelManPowerMoneyRepository.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelManPowerMoneyAllByDepByMonthDO> list =  projectLevelManPowerMoneyRepository.findDepTypeGroupByMonth(startYear,endYear);
        PageInfo<ProjectLevelManPowerMoneyAllByDepByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonth",times});
        Result<ProjectLevelManPowerMoneyAllByDepByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelManPowerMoneyAllByDepByMonthDO> list =  projectLevelManPowerMoneyRepository.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-项目级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonthList",times});
        return list;
    }
}
