package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.dto.PerformanceDTO;
import com.bsoft.hr.dto.PerformanceSaveResultDTO;
import com.bsoft.hr.entity.primary.PerformanceDO;
import com.bsoft.hr.entity.primary.PerformanceSaveResultDO;
import com.bsoft.hr.entity.primary.PerformanceViewDO;
import com.bsoft.hr.manager.PerformanceManager;
import com.bsoft.hr.service.PerformanceService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:22
 * @Description
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {
    private static final Logger logger = LoggerFactory.getLogger(PerformanceServiceImpl.class);

    @Autowired
    private PerformanceManager performanceManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PerformanceDTO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<PerformanceViewDO> pages = performanceManager.getPerformanceList(year, deptId, inputContent, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("年度:{},部门id:{},查询条件：{}，获取年度绩效列表耗时:{}",year,deptId,inputContent,times);
        return ResultUtils.parseResult(pages, PerformanceDTO.class);
    }

    @Override
    public PerformanceSaveResultDTO savePerformance(String personId, List<PerformanceDTO> performanceDTOS, List<PerformanceDTO> errorPerformanceDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PerformanceViewDO> savesData = iGenerator.convert(performanceDTOS, PerformanceViewDO.class);
        List<PerformanceViewDO> errorData = iGenerator.convert(errorPerformanceDTOS, PerformanceViewDO.class);
        PerformanceSaveResultDO result = performanceManager.savePerformance(personId, savesData, errorData);
        long times = timeConsumer.end();
        logger.info("工号：{}， 保存年度绩效列表耗时:{}",personId,times);
        return iGenerator.convert(result, PerformanceSaveResultDTO.class);
    }

    @Override
    public void deletePerformances(List<PerformanceDTO> performanceDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PerformanceDO> performanceDOS = iGenerator.convert(performanceDTOS, PerformanceDO.class);
        performanceManager.deletePerformances(performanceDOS);
        long times = timeConsumer.end();
        logger.info("删除年度绩效列表耗时:{}",times);
    }

    @Override
    public List<PerformanceDTO> getErrorPerformanceList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PerformanceViewDO> list = performanceManager.getErrorPerformanceList(personId);
        long times = timeConsumer.end();
        logger.info("工号:{}，获取导入年度绩效错误列表耗时:{}", personId,times);
        return iGenerator.convert(list, PerformanceDTO.class);
    }

}
