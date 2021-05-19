package com.bsoft.sales.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.sales.condition.OriginalAcceptanceQueryCnd;
import com.bsoft.sales.dto.OriginalAcceptanceDTO;
import com.bsoft.sales.dto.OriginalAcceptanceQueryCndDTO;
import com.bsoft.sales.entity.primary.OriginalAcceptanceDO;
import com.bsoft.sales.manager.OriginalAcceptanceManager;
import com.bsoft.sales.service.OriginalAcceptanceService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:59
 * @Description: 合同原件Service
 */
@Service
public class OriginalAcceptanceServiceImpl implements OriginalAcceptanceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OriginalAcceptanceServiceImpl.class);
    @Autowired
    private OriginalAcceptanceManager originalAcceptanceManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<OriginalAcceptanceDTO> getOriginalAcceptance(OriginalAcceptanceQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OriginalAcceptanceQueryCnd cnd = generatorUtil.convert(cndDTO,OriginalAcceptanceQueryCnd.class);
        Page<OriginalAcceptanceDO> page = originalAcceptanceManager.getOriginalAcceptance(cnd);
        Result<OriginalAcceptanceDTO> result = ResultUtils.parseResult(page,OriginalAcceptanceDTO.class);
        long times = timeConsumer.end();
        LOGGER.info("获取合同原件接收、归档审核列表耗时[{}]！",times);
        return result;
    }

    @Override
    public void auditOriginalAcceptance(List<OriginalAcceptanceDTO> wordDTOS, String userId, Integer status) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<OriginalAcceptanceDO> words = generatorUtil.convert(wordDTOS, OriginalAcceptanceDO.class);
        originalAcceptanceManager.auditOriginalAcceptance(words,userId,status);
        long times = timeConsumer.end();
        LOGGER.info("合同原件接收、归档操作！,status=[{}],userId=[{}],耗时[{}]！",status,userId,times);
    }
}
