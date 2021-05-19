package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ContractLevelWorkloadManager;
import com.bsoft.project.report.repository.primary.ContractLevelWorkloadRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:21
 * @Version 1.0
 * @Description
 */
@Component
public class ContractLevelWorkloadManagerImpl implements ContractLevelWorkloadManager {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelWorkloadManagerImpl.class);
    @Autowired
    private ContractLevelWorkloadRepository workloadRepository;
    @Override
    public Result<ContractLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllDO> list =  workloadRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ContractLevelworkloadAllDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotal",times});
        Result<ContractLevelworkloadAllDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllDO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllDO> list =  workloadRepository.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotalList",times});
        return list;
    }

    @Override
    public Result<ContractLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllByYearDO> list =  workloadRepository.findAllGroupByYear(startYear,endYear);
        PageInfo<ContractLevelworkloadAllByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYear",times});
        Result<ContractLevelworkloadAllByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByYearDO> list =  workloadRepository.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ContractLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllByMonthDO> list =  workloadRepository.findAllGroupByMonth(startYear,endYear);
        PageInfo<ContractLevelworkloadAllByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonth",times});
        Result<ContractLevelworkloadAllByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByMonthDO> list =  workloadRepository.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonthList",times});
        return list;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllByDepDO> list =  workloadRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ContractLevelworkloadAllByDepDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotal",times});
        Result<ContractLevelworkloadAllByDepDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepDO> list =  workloadRepository.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotalList",times});
        return list;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllByDepByYearDO> list =  workloadRepository.findDepTypeGroupByYear(startYear,endYear);
        PageInfo<ContractLevelworkloadAllByDepByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYear",times});
        Result<ContractLevelworkloadAllByDepByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepByYearDO> list =  workloadRepository.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelworkloadAllByDepByMonthDO> list =  workloadRepository.findDepTypeGroupByMonth(startYear,endYear);
        PageInfo<ContractLevelworkloadAllByDepByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonth",times});
        Result<ContractLevelworkloadAllByDepByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepByMonthDO> list =  workloadRepository.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-工作量-合同级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonthList",times});
        return list;
    }
}
