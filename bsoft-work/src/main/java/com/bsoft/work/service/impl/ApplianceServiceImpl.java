package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.work.condition.ApplianceNameQueryCnd;
import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.dto.*;
import com.bsoft.work.entity.primary.ApplianceStockDO;
import com.bsoft.work.entity.primary.ApplianceNameDO;
import com.bsoft.work.entity.primary.ApplianceStoreDO;
import com.bsoft.work.entity.primary.ApplianceUseDO;
import com.bsoft.work.manager.ApplianceManager;
import com.bsoft.work.service.ApplianceService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
@Service
public class ApplianceServiceImpl implements ApplianceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplianceServiceImpl.class);

    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private ApplianceManager applianceManager;

    @Override
    public Result<ApplianceStockDTO> getApplianceStockList(String userId, ApplianceQueryCndDTO queryCndDTO){
        ApplianceQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ApplianceQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ApplianceStockDO> resultDO = applianceManager.getApplianceStockList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]获取入库物品列表耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, ApplianceStockDTO.class);
    }

    @Override
    public void saveApplianceStock(String userId, ApplianceStockDTO saveDTO) {
        ApplianceStockDO saveDO = iGenerator.convert(saveDTO, ApplianceStockDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        applianceManager.saveApplianceStock(saveDO);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]保存入库物品信息耗时[{}]", userId, times);
    }

    @Override
    public void submitApplianceStock(String userId, ApplianceStockDTO saveDTO) {
        ApplianceStockDO saveDO = iGenerator.convert(saveDTO, ApplianceStockDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        applianceManager.submitApplianceStock(userId, saveDO);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]提交入库物品信息耗时[{}]", userId, times);
    }

    @Override
    public Result<ApplianceUseDTO> getApplianceUseList(String userId, ApplianceQueryCndDTO queryCndDTO) {
        ApplianceQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ApplianceQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ApplianceUseDO> resultDO = applianceManager.getApplianceUseList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]获取物品领用列表耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, ApplianceUseDTO.class);
    }

    @Override
    public List<ApplianceUseDTO> getApplianceUseDetail(String userId, Integer stockId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ApplianceUseDO> resultDO = applianceManager.getApplianceUseDetail(stockId);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]获取单个物品的领用详情耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, ApplianceUseDTO.class);
    }

    @Override
    public Double countApplianceUnPayMoney(String userId ,Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Double money = applianceManager.countApplianceUnPayMoney(type);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]统计未支付金额耗时[{}]", userId, times);
        return money;
    }

    @Override
    public Result<ApplianceNameDTO> getApplianceNameList(String userId, ApplianceNameQueryCndDTO queryCndDTO) {
        ApplianceNameQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ApplianceNameQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ApplianceNameDO> resultDO = applianceManager.getApplianceNameList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]获取行政物品名称列表耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, ApplianceNameDTO.class);
    }

    @Override
    public void saveApplianceName(String userId, ApplianceNameDTO saveDTO) {
        ApplianceNameDO saveDO = iGenerator.convert(saveDTO, ApplianceNameDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        applianceManager.saveApplianceName(saveDO);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]保存物品类别信息耗时[{}]", userId, times);
    }

    @Override
    public Result<ApplianceStoreDTO> getApplianceStoreList(String userId, ApplianceQueryCndDTO queryCndDTO) {
        ApplianceQueryCnd queryCnd = iGenerator.convert(queryCndDTO, ApplianceQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ApplianceStoreDO> resultDO = applianceManager.getApplianceStoreList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("行政用品--[{}]获取行政物品库存耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, ApplianceStoreDTO.class);
    }



}
