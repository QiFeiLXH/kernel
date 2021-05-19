package com.bsoft.sales.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.sales.report.dto.DynamicClueDTO;
import com.bsoft.sales.report.dto.DynamicContractDTO;
import com.bsoft.sales.report.dto.DynamicReviewDTO;
import com.bsoft.sales.report.dto.DynamicTenderDTO;
import com.bsoft.sales.report.entity.primary.*;
import com.bsoft.sales.report.manager.DynamicClueManager;
import com.bsoft.sales.report.manager.DynamicContractManager;
import com.bsoft.sales.report.manager.DynamicReviewManager;
import com.bsoft.sales.report.manager.DynamicTenderManager;
import com.bsoft.sales.report.service.DynamicDetailService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DynamicDetailServiceImpl implements DynamicDetailService {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDetailServiceImpl.class);
    @Autowired
    private DynamicClueManager dynamicClueManager;
    @Autowired
    private DynamicContractManager dynamicContractManager;
    @Autowired
    private DynamicReviewManager dynamicReviewManager;
    @Autowired
    private DynamicTenderManager dynamicTenderManager;
    @Autowired
    private IGenerator generator;

    @Override
    public List<DynamicClueDTO> getDynamicClue(Integer dynamicId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DynamicClueViewDO> results = dynamicClueManager.getClueView(dynamicId);
        long times = timeConsumer.end();
        logger.info("获取销售动态id:{}的线索信息耗时:{}",dynamicId,times);
        return generator.convert(results,DynamicClueDTO.class);
    }

    @Override
    public List<DynamicContractDTO> getDynamicContract(Integer dynamicId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DynamicContractViewDO> results = dynamicContractManager.getContractView(dynamicId);
        long times = timeConsumer.end();
        logger.info("获取销售动态id:{}的合同信息耗时:{}",dynamicId,times);
        return generator.convert(results,DynamicContractDTO.class);
    }

    @Override
    public List<DynamicReviewDTO> getDynamicReview(Integer dynamicId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DynamicReviewViewDO> results = dynamicReviewManager.getReviewView(dynamicId);
        long times = timeConsumer.end();
        logger.info("获取销售动态id:{}的合同评审信息耗时:{}",dynamicId,times);
        return generator.convert(results,DynamicReviewDTO.class);
    }

    @Override
    public List<DynamicTenderDTO> getDynamicTender(Integer dynamicId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DynamicTenderViewDO> results = dynamicTenderManager.getTenderView(dynamicId);
        long times = timeConsumer.end();
        logger.info("获取销售动态id:{}的投标信息耗时:{}",dynamicId,times);
        return generator.convert(results,DynamicTenderDTO.class);
    }
}
