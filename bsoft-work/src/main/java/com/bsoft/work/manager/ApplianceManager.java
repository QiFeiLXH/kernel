package com.bsoft.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.work.condition.ApplianceNameQueryCnd;
import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.dto.ApplianceStockDTO;
import com.bsoft.work.entity.primary.ApplianceNameDO;
import com.bsoft.work.entity.primary.ApplianceStockDO;
import com.bsoft.work.entity.primary.ApplianceStoreDO;
import com.bsoft.work.entity.primary.ApplianceUseDO;
import com.bsoft.work.service.ApplianceService;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
public interface ApplianceManager {
    /**
     * 获取入库物品列表
     * @param queryCnd
     * @return
     */
    Result<ApplianceStockDO> getApplianceStockList(ApplianceQueryCnd queryCnd);

    /**
     * 保存入库物品信息
     * @param saveDO 物品入库信息
     */
    void saveApplianceStock(ApplianceStockDO saveDO);

    /**
     * 提交入库物品信息
     * @param userId 登记人
     * @param saveDO 物品入库信息
     */
    void submitApplianceStock(String userId, ApplianceStockDO saveDO);


    /**
     * 统计未支付金额
     * @param type
     * @return
     */
    Double countApplianceUnPayMoney(Integer type);

    /**
     * 获取物品库存
     * @param queryCnd
     * @return
     */
    Result<ApplianceStoreDO> getApplianceStoreList(ApplianceQueryCnd queryCnd);

    /**
     * 统计入库物品并保存到库存（用于初始化库存表数据）
     * @return
     */
    void countStore();

    /**
     * 获取物品领用列表
     * @param queryCnd
     * @return
     */
    Result<ApplianceUseDO> getApplianceUseList(ApplianceQueryCnd queryCnd);

    /**
     * 获取单个物品的领用详情
     * @param stockId
     * @return
     */
    List<ApplianceUseDO> getApplianceUseDetail(Integer stockId);

    /**
     * 获取行政物品名称列表
     * @param queryCnd
     * @return
     */
    Result<ApplianceNameDO> getApplianceNameList(ApplianceNameQueryCnd queryCnd);

    /**
     * 保存行政用品名称字典，无ID则新增，有ID则更新
     * @param saveDO
     */
    void saveApplianceName(ApplianceNameDO saveDO);
}
