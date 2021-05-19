package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ContractLevelManPowerMoneyManager;
import com.bsoft.project.report.service.ContractLevelManPowerMoneyService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContractLevelManPowerMoneyServiceImpl implements ContractLevelManPowerMoneyService {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelManPowerMoneyServiceImpl.class);
    @Autowired
    private ContractLevelManPowerMoneyManager contractLevelManPowerMoneyManager;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ContractLevelManPowerMoneyAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllDO> results = contractLevelManPowerMoneyManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllDTO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllDO> results = contractLevelManPowerMoneyManager.findAllSubTotalList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllByYearDO> results = contractLevelManPowerMoneyManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllByYearDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByYearDO> results = contractLevelManPowerMoneyManager.findAllGroupByYearList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllByYearDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllByMonthDO> results = contractLevelManPowerMoneyManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllByMonthDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByMonthDO> results = contractLevelManPowerMoneyManager.findAllGroupByMonthList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllByMonthDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllByDepDO> results = contractLevelManPowerMoneyManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllByDepDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepDO> results = contractLevelManPowerMoneyManager.findDepTypeSubTotalList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllByDepDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllByDepByYearDO> results = contractLevelManPowerMoneyManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllByDepByYearDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepByYearDO> results = contractLevelManPowerMoneyManager.findDepTypeGroupByYearList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllByDepByYearDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelManPowerMoneyAllByDepByMonthDO> results = contractLevelManPowerMoneyManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelManPowerMoneyAllByDepByMonthDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelManPowerMoneyAllByDepByMonthDO> results = contractLevelManPowerMoneyManager.findDepTypeGroupByMonthList(startYear,endYear);
        List<ContractLevelManPowerMoneyAllByDepByMonthDTO> result = generatorUtil.convert(results,ContractLevelManPowerMoneyAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-金额-合同级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }
}
