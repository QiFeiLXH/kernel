package com.bsoft.sales.report.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.report.dto.SalesDynamicDTO;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.SalesDynamicManager;
import com.bsoft.sales.report.service.SalesDynamicService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
@Service
public class SalesDynamicServiceImpl implements SalesDynamicService {
    private static final Logger logger = LoggerFactory.getLogger(SalesDynamicServiceImpl.class);
    @Autowired
    private SalesDynamicManager salesDynamicManager;

    @Override
    public Result<SalesDynamicDTO> getSalesDynamic(String personId, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<SalesDynamicDO> result = salesDynamicManager.getSalesDynamic(personId,page,size);
        long times = timeConsumer.end();
        logger.info("获取工号:{}，条数:{}，页数{}的销售动态列表耗时:{}",new Object[]{personId,size,page,times});
        return ResultUtils.parseResult(result,SalesDynamicDTO.class);
    }

    @Override
    public Result<SalesDynamicDTO> getSalesDynamic(String personId, Integer page) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<SalesDynamicDO> result = salesDynamicManager.getSalesDynamic(personId,page);
        long times = timeConsumer.end();
        logger.info("获取工号:{}，条数:{}，页数{}的销售动态列表耗时:{}",new Object[]{personId,10,page,times});
        return ResultUtils.parseResult(result,SalesDynamicDTO.class);
    }
}
