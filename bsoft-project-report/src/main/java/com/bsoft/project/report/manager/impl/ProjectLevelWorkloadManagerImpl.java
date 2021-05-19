package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ProjectLevelWorkloadManager;
import com.bsoft.project.report.repository.primary.ProjectLevelWorkloadRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:21
 * @Version 1.0
 * @Description
 */
@Component
public class ProjectLevelWorkloadManagerImpl implements ProjectLevelWorkloadManager {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLevelWorkloadManagerImpl.class);
    @Autowired
    private ProjectLevelWorkloadRepository workloadRepository;
    @Override
    public Result<ProjectLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllDO> list =  workloadRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotal",times});
        Result<ProjectLevelworkloadAllDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllDO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllDO> list =  workloadRepository.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotalList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllByYearDO> list =  workloadRepository.findAllGroupByYear(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYear",times});
        Result<ProjectLevelworkloadAllByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByYearDO> list =  workloadRepository.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllByMonthDO> list =  workloadRepository.findAllGroupByMonth(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonth",times});
        Result<ProjectLevelworkloadAllByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByMonthDO> list =  workloadRepository.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonthList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllByDepDO> list =  workloadRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllByDepDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotal",times});
        Result<ProjectLevelworkloadAllByDepDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepDO> list =  workloadRepository.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotalList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllByDepByYearDO> list =  workloadRepository.findDepTypeGroupByYear(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllByDepByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYear",times});
        Result<ProjectLevelworkloadAllByDepByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepByYearDO> list =  workloadRepository.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ProjectLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLevelworkloadAllByDepByMonthDO> list =  workloadRepository.findDepTypeGroupByMonth(startYear,endYear);
        PageInfo<ProjectLevelworkloadAllByDepByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonth",times});
        Result<ProjectLevelworkloadAllByDepByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ProjectLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLevelworkloadAllByDepByMonthDO> list =  workloadRepository.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-项目级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonthList",times});
        return list;
    }
}
