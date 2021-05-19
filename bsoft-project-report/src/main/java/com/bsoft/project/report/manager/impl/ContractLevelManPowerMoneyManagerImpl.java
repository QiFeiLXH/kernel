package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ContractLevelManPowerMoneyManager;
import com.bsoft.project.report.repository.primary.ContractLevelManPowerMoneyRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContractLevelManPowerMoneyManagerImpl implements ContractLevelManPowerMoneyManager {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelManPowerMoneyManagerImpl.class);

    @Autowired
    private ContractLevelManPowerMoneyRepository contractLevelManPowerMoneyRepository;
    @Override
    public Result<ContractLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllDO> list =  contractLevelManPowerMoneyRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotal",times});
        Result<ContractLevelManPowerMoneyAllDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllDO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllDO> list =  contractLevelManPowerMoneyRepository.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-小计获取数据耗时:{}",new Object[]{"findAllSubTotalList",times});
        return list;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllByYearDO> list =  contractLevelManPowerMoneyRepository.findAllGroupByYear(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYear",times});
        Result<ContractLevelManPowerMoneyAllByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByYearDO> list =  contractLevelManPowerMoneyRepository.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-年度获取数据耗时:{}",new Object[]{"findAllGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllByMonthDO> list =  contractLevelManPowerMoneyRepository.findAllGroupByMonth(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonth",times});
        Result<ContractLevelManPowerMoneyAllByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByMonthDO> list =  contractLevelManPowerMoneyRepository.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-全部-月度获取数据耗时:{}",new Object[]{"findAllGroupByMonthList",times});
        return list;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllByDepDO> list =  contractLevelManPowerMoneyRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllByDepDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotal",times});
        Result<ContractLevelManPowerMoneyAllByDepDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepDO> list =  contractLevelManPowerMoneyRepository.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-小计获取数据耗时:{}",new Object[]{"findDepTypeSubTotalList",times});
        return list;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllByDepByYearDO> list =  contractLevelManPowerMoneyRepository.findDepTypeGroupByYear(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllByDepByYearDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYear",times});
        Result<ContractLevelManPowerMoneyAllByDepByYearDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepByYearDO> list =  contractLevelManPowerMoneyRepository.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-年度获取数据耗时:{}",new Object[]{"findDepTypeGroupByYearList",times});
        return list;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageHelper.startPage(pageNo,pageSize);
        List<ContractLevelManPowerMoneyAllByDepByMonthDO> list =  contractLevelManPowerMoneyRepository.findDepTypeGroupByMonth(startYear,endYear);
        PageInfo<ContractLevelManPowerMoneyAllByDepByMonthDO> pageInfo = new PageInfo<>(list);
        Integer count = Math.toIntExact(pageInfo.getTotal());
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonth",times});
        Result<ContractLevelManPowerMoneyAllByDepByMonthDO> result = ResultUtils.parseResult(list,count);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepByMonthDO> list =  contractLevelManPowerMoneyRepository.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("方法名:{}人力成本-金额-合同级-按产生部门类型-月度获取数据耗时:{}",new Object[]{"findDepTypeGroupByMonthList",times});
        return list;
    }
}
