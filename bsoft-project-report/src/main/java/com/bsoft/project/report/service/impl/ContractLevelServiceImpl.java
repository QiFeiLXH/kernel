package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.dto.ContractAllByMonthDTO;
import com.bsoft.project.report.dto.ContractAllSubTotalDTO;
import com.bsoft.project.report.dto.ContractDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ContractDepTypeByYearDTO;
import com.bsoft.project.report.entity.primary.ContractAllByMonthDO;
import com.bsoft.project.report.entity.primary.ContractAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ContractDepTypeByMonthDO;
import com.bsoft.project.report.entity.primary.ContractDepTypeByYearDO;
import com.bsoft.project.report.manager.ContractLevelManager;
import com.bsoft.project.report.service.ContractLevelService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2019-12-23 15:40
 * @Version 1.0
 * @Description
 */
@Service
public class ContractLevelServiceImpl implements ContractLevelService {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelServiceImpl.class);
    @Autowired
    private ContractLevelManager contractLevelManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<ContractAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ContractAllSubTotalDO> results = contractLevelManager.findAllSubTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractAllSubTotalDTO.class);
    }

    @Override
    public List<ContractAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractAllSubTotalDO> results = contractLevelManager.findAllSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractAllSubTotalDTO.class);
    }

    @Override
    public Result<ContractAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ContractAllSubTotalDO> results = contractLevelManager.findAllGroupByYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractAllSubTotalDTO.class);
    }

    @Override
    public List<ContractAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractAllSubTotalDO> results = contractLevelManager.findAllGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractAllSubTotalDTO.class);
    }

    @Override
    public Result<ContractAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ContractAllByMonthDO> results = contractLevelManager.findAllGroupByMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractAllByMonthDTO.class);
    }

    @Override
    public List<ContractAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractAllByMonthDO> results = contractLevelManager.findAllGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractAllByMonthDTO.class);
    }

    @Override
    public Result<ContractDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ContractDepTypeByYearDO> results = contractLevelManager.findDepTypeSubTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractDepTypeByYearDTO.class);
    }

    @Override
    public List<ContractDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractDepTypeByYearDO> results = contractLevelManager.findDepTypeSubTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractDepTypeByYearDTO.class);
    }

    @Override
    public Result<ContractDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ContractDepTypeByYearDO> results = contractLevelManager.findDepTypeGroupByYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractDepTypeByYearDTO.class);
    }

    @Override
    public List<ContractDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractDepTypeByYearDO> results = contractLevelManager.findDepTypeGroupByYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractDepTypeByYearDTO.class);
    }

    @Override
    public Result<ContractDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ContractDepTypeByMonthDO> results = contractLevelManager.findDepTypeGroupByMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(results, ContractDepTypeByMonthDTO.class);
    }

    @Override
    public List<ContractDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ContractDepTypeByMonthDO> results = contractLevelManager.findDepTypeGroupByMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取合同级-按产生部门类型-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return iGenerator.convert(results, ContractDepTypeByMonthDTO.class);
    }
}
