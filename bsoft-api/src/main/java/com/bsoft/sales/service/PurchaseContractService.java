package com.bsoft.sales.service;

import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.*;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 11:53
 * @Description: 采购合同service
 */
public interface PurchaseContractService {
    /**
     * 获取采购合同申请列表
     * @param cndDTO
     * @return
     */
    Result<PurchaseContractViewDTO> getPurchaseContract(PurchaseContractQueryCndDTO cndDTO);

    /**
     * 获取支付信息列表
     * @param cndDTO
     * @return
     */
    Result<PurContractPayViewDTO> getPurContractPay(PurContractPayQueryCndDTO cndDTO);

    /**
     * 获取支付信息详情
     * @param id
     * @return
     */
    PurContractPayViewDTO getPurContractPay(Integer id);

    /**
     * 保存支付信息
     * @param payViewDTO
     * @return
     */
    Integer savePurContractPay(PurContractPayViewDTO payViewDTO);

    void savePurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves, List<Integer> ids, String contractNo);

    Integer saveOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves, List<Integer> ids, String personId);

    List<PurchaseContractPaymentDTO> getPurchaseContractPaymentList(Integer purchaseContractId);

    /**
     * 生成支付申请，同步到成本信息
     * @param payViewDTO
     * @return
     */
    Integer savePaymentApplication(PurContractPayViewDTO payViewDTO);

    /**
     * 获取公司自用采购合同申请列表
     * @param cndDTO
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContract(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 获取公司自用采购合同申请所有列表
     * @param cndDTO
     * @return
     */
    List<PurchaseContractViewDTO> getAllOwnPurchaseContractList(OwnPurchaseContractQueryCndDTO cndDTO);


    /**
     * 获取采购合同
     * @param purchaseContractId 采购合同id
     * @return
     */
    PurchaseContractViewDTO getOwnPurchaseContract(Integer purchaseContractId);

    /**
     * 获取公司自用采购合同未完结的数量
     * @param signYear 签定年份
     * @return
     */
    Integer getOwnUnfinishedCount(Integer signYear,String inputContent, String userId);

    /**
     * 删除自用采购合同
     * @return
     */
    void deleteOwnPurchaseContractCount(Integer purchaseContractId);

    /**
     * 获取公司自用采购合同审核列表
     * @param cndDTO
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 获取公司自用采购合同未审核的数量
     * @param signYear 签定年份
     * @return
     */
    Integer getOwnUnreviewedCount(Integer signYear,String inputContent);

    /**
     * 审核公司采购合同
     * @param contractId 采购合同id
     * @param oldStatus 原先审核状态
     * @param personId 审核人
     * @return
     */
    void auditOwnPurchaseContract(Integer contractId, Integer oldStatus, String personId);

    /**
     * 驳回公司采购合同
     * @param contractId 采购合同id
     * @param oldStatus 原状态
     * @return
     */
    void disagreeOwnPurchaseContract(Integer contractId,Integer oldStatus);

    /**
     * 获取公司采购合同支付信息列表
     * @param purchaseContractNo 采购合同号
     * @param pageNo 页码
     * @param pageSize 单页条数
     * @return
     */
    Result<OwnPurchaseCostPaymentDTO> getOwnPurchaseCostPaymentList(String purchaseContractNo, Integer pageNo, Integer pageSize);

    /**
     * 获取公司采购合同列表（进度）
     * @param cndDTO
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 获取全部公司采购合同列表（进度）
     * @param cndDTO
     * @return
     */
    List<PurchaseContractViewDTO> getAllOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 获取公司采购合同进度列表
     * @param purchaseContractId 采购合同id
     * @return
     */
    List<PurchaseContractProgressDTO> getOwnPurchaseContractProgressList(Integer purchaseContractId);

    /**
     * 生成采购合同号
     * @param hasContract 有无合同
     * @param classification 合同分类
     * @param signDate 签订日期
     * @return
     */
    String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate);

    /**
     * 获取公司采购合同选择列表
     * @param inputContent 采购合同号
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContractSelectList(String inputContent, Integer pageNo, Integer pageSize);

    /**
     * 获取公司采购合同查找列表
     * @param purchaseContractId 采购合同id
     * @param inputContent 采购合同号
     * @param pageNo 页码
     * @param pageSize 单页条数
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContractSearchList(Integer purchaseContractId, String inputContent, Integer pageNo, Integer pageSize);

    /**
     * 保存公司采购合同进度
     * @param progressDTO 采购合同id
     * @return 进度id
     */
    Integer savePurchaseContractProgress(PurchaseContractProgressDTO progressDTO);

    /**
     * 查询公司采购合同情况列表
     * @param cndDTO 查询条件
     * @return
     */
    Result<PurchaseContractViewDTO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 查询所有公司采购合同情况列表
     * @param cndDTO 查询条件
     * @return
     */
    List<PurchaseContractViewDTO> getAllOwnPurchaseContractInfoList(OwnPurchaseContractQueryCndDTO cndDTO);

    /**
     * 查询门户待办-采购合同待审核数量
     * @param personId 员工工号
     * @return
     */
    Integer getPortalPurchaseContractAuditNeedDoCount (String personId);

    /**
     * 根据采购合同号查询公司采购合同是否存在
     * @param purchaseContractNo 采购合同号
     * @return
     */
    Boolean existPurchaseContract(String purchaseContractNo);

    /**
     * 根据采购合同id查询其已有补充协议的数量
     * @param purchaseContractId 采购合同id
     * @return
     */
    Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId);

    /**
     * 变更公司采购合同（合同金额，付款条件）
     * @param purchaseContractDTO 采购合同
     * @param saves 待保存的付款条件
     * @param personId 变更人
     * @return
     */
    void alterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves, String personId);


    /**
     * 审核变更公司采购合同
     * @param purchaseContractDTO 采购合同
     * @param saves 付款条件
     * @param personId 审核人
     * @return
     */
    void auditAlterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves,String personId);

    /**
     * 驳回变更公司采购合同
     * @param purchaseContractDTO 采购合同
     * @param saves 付款条件
     * @return
     */
    void disagreeAlterOwnPurchaseContract(PurchaseContractViewDTO purchaseContractDTO, List<PurchaseContractPaymentDTO> saves);

    List<PurchaseContractPaymentDTO> getOwnPurchaseContractPaymentList(Integer purchaseContractId, Integer alterFlag);

}
