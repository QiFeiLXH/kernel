package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;

import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;

import com.bsoft.work.entity.primary.CompanySealDO;
import com.bsoft.work.entity.primary.CompanySealViewDO;
import com.bsoft.work.manager.CompanySealManager;
import com.bsoft.work.service.CompanySealService;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


@Service
public class CompanySealServiceImpl implements CompanySealService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanySealServiceImpl.class);
    @Autowired
    private CompanySealManager companySealManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Result<CompanySealDTO> getCompanySealList(CompanySealQueryCnd companySealQueryCnd) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<CompanySealViewDO> result = companySealManager.getCompanySealList(companySealQueryCnd);
        long times = timeConsumer.end();
        LOGGER.info("查询条件为：{}的公司印章列表列表耗时[{}]", JSONUtils.toString(companySealQueryCnd), times);
        return ResultUtils.parseResult(result, CompanySealDTO.class);
    }

    @Override
    public void saveCompanySeal(CompanySealDTO companySealDTO) {
        CompanySealDO convert = iGenerator.convert(companySealDTO, CompanySealDO.class);
        companySealManager.saveCompanySeal(convert);
    }

    @Override
    public CompanySealDTO getCompanySealView(Integer id) {
        CompanySealViewDO companySealView = companySealManager.getCompanySealView(id);
        return  iGenerator.convert(companySealView, CompanySealDTO.class);
    }
}
