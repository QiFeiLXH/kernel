package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.FinanceCostQueryCnd;
import com.bsoft.cost.dto.FinanceCostQueryCndDTO;
import com.bsoft.cost.dto.FinanceCostViewDTO;
import com.bsoft.cost.entity.primary.FinanceCostViewDO;
import com.bsoft.cost.manager.FinanceCostManager;
import com.bsoft.cost.service.FinanceCostService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 10:37
 * @Version 1.0
 * @Description
 */
@Service
public class FinanceCostServiceImpl implements FinanceCostService {
    private static final Logger logger = LoggerFactory.getLogger(FinanceCostServiceImpl.class);
    @Autowired
    private FinanceCostManager financeCostManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<FinanceCostViewDTO> getFinanceCostList(FinanceCostQueryCndDTO financeCostQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        FinanceCostQueryCnd financeCostQueryCnd = generatorUtil.convert(financeCostQueryCndDTO,FinanceCostQueryCnd.class);
        PageInfo<FinanceCostViewDO>  pageInfo = financeCostManager.getFinanceCostList(financeCostQueryCnd);
        Result<FinanceCostViewDTO> result = ResultUtils.parseResult(pageInfo,FinanceCostViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取财务项目需求报表耗时:{}",times);
        return result;
    }

    @Override
    public List<FinanceCostViewDTO> getFinanceCostDownload(FinanceCostQueryCndDTO financeCostQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        FinanceCostQueryCnd financeCostQueryCnd = generatorUtil.convert(financeCostQueryCndDTO,FinanceCostQueryCnd.class);
        List<FinanceCostViewDO>  result = financeCostManager.getFinanceCostDownload(financeCostQueryCnd);
        long times = timeConsumer.end();
        logger.info("获取财务项目需求下载信息报表耗时:{}",times);
        return generatorUtil.convert(result,FinanceCostViewDTO.class);
    }
}
