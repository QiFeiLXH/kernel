package com.bsoft.work.service;

import com.bsoft.common.result.Result;
import com.bsoft.work.dto.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
public interface ApplianceService {
    /**
     * 获取入库物品列表
     * @param userId
     * @param queryCndDTO
     * @return
     */
    Result<ApplianceStockDTO> getApplianceStockList(String userId, ApplianceQueryCndDTO queryCndDTO);

    /**
     * 保存入库物品信息
     * @param saveDTO 物品入库信息
     */
    void saveApplianceStock(String userId, ApplianceStockDTO saveDTO);

    /**
     * 提交入库物品信息
     * @param userId
     * @param saveDTO 物品入库信息
     */
    void submitApplianceStock(String userId, ApplianceStockDTO saveDTO);

    /**
     * 获取物品领用列表
     * @param userId
     * @param queryCndDTO
     * @return
     */
    Result<ApplianceUseDTO> getApplianceUseList(String userId, ApplianceQueryCndDTO queryCndDTO);

    /**
     * 获取单个物品的领用详情
     * @param userId
     * @param stockId
     * @return
     */
    List<ApplianceUseDTO> getApplianceUseDetail(String userId, Integer stockId);

    /**
     * 统计未支付金额
     * @param userId
     * @param type
     * @return
     */
    Double countApplianceUnPayMoney(String userId, Integer type);

    /**
     * 获取行政物品名称列表
     * @param userId 操作工号
     * @param queryCndDTO 查询参数
     * @return
     */
    Result<ApplianceNameDTO> getApplianceNameList(String userId, ApplianceNameQueryCndDTO queryCndDTO);
    /**
     * 保存行政物品名称字典
     * @param userId 操作工号
     * @param saveDTO 名称信息
     * @return
     */
    void saveApplianceName(String userId, ApplianceNameDTO saveDTO);

    /**
     * 获取物品库存
     * @param userId
     * @param queryCndDTO 查询参数
     * @return
     */
    Result<ApplianceStoreDTO> getApplianceStoreList(String userId, ApplianceQueryCndDTO queryCndDTO);
}
