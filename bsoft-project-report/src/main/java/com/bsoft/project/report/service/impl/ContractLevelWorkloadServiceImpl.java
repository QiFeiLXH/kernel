package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ContractLevelWorkloadManager;
import com.bsoft.project.report.service.ContractLevelWorkloadService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:30
 * @Version 1.0
 * @Description
 */
@Service
public class ContractLevelWorkloadServiceImpl implements ContractLevelWorkloadService {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelWorkloadServiceImpl.class);
    @Autowired
    private ContractLevelWorkloadManager contractLevelWorkloadManager;
    @Autowired
    GeneratorUtil generatorUtil;
    @Override
    public Result<ContractLevelworkloadAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllDO> results = contractLevelWorkloadManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllDTO> findAllSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllDO> results = contractLevelWorkloadManager.findAllSubTotalList(startYear,endYear);
        List<ContractLevelworkloadAllDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelworkloadAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllByYearDO> results = contractLevelWorkloadManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllByYearDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByYearDO> results = contractLevelWorkloadManager.findAllGroupByYearList(startYear,endYear);
        List<ContractLevelworkloadAllByYearDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelworkloadAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllByMonthDO> results = contractLevelWorkloadManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllByMonthDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByMonthDO> results = contractLevelWorkloadManager.findAllGroupByMonthList(startYear,endYear);
        List<ContractLevelworkloadAllByMonthDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-全部-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllByDepDO> results = contractLevelWorkloadManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllByDepDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepDO> results = contractLevelWorkloadManager.findDepTypeSubTotalList(startYear,endYear);
        List<ContractLevelworkloadAllByDepDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-小计列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllByDepByYearDO> results = contractLevelWorkloadManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllByDepByYearDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepByYearDO> results = contractLevelWorkloadManager.findDepTypeGroupByYearList(startYear,endYear);
        List<ContractLevelworkloadAllByDepByYearDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepByYearDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-年度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public Result<ContractLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ContractLevelworkloadAllByDepByMonthDO> results = contractLevelWorkloadManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        Result<ContractLevelworkloadAllByDepByMonthDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }

    @Override
    public List<ContractLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractLevelworkloadAllByDepByMonthDO> results = contractLevelWorkloadManager.findDepTypeGroupByMonthList(startYear,endYear);
        List<ContractLevelworkloadAllByDepByMonthDTO> result = generatorUtil.convert(results,ContractLevelworkloadAllByDepByMonthDTO.class);
        long times = timeConsumer.end();
        logger.info("获取人力成本-工作量-合同级-按产生部门类型-月度列表详情耗时:{}",times);
        return result;
    }
}
