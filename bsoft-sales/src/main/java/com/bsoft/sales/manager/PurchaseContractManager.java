package com.bsoft.sales.manager;

import com.bsoft.sales.condition.OwnPurchaseContractQueryCnd;
import com.bsoft.sales.condition.PurContractPayQueryCnd;
import com.bsoft.sales.condition.PurchaseContractQueryCnd;
import com.bsoft.sales.entity.primary.*;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 10:49
 * @Description: 采购合同Manager
 */
public interface PurchaseContractManager {
    public Page<PurchaseContractViewDO>  getPurchaseContract(PurchaseContractQueryCnd cnd);

    public Page<PurContractPayViewDO> getPurContractPay(PurContractPayQueryCnd cnd);

    PurContractPayViewDO getPurContractPay(Integer id);

    PurContractPayDO savePurContractPay(PurContractPayDO payDO);

    void savePurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS, List<Integer> ids, String contractNo);

    List<PurchaseContractPaymentViewDO> getPurchaseContractPaymentList(Integer purchaseContractId);

    Integer savePaymentApplication(PurContractPayViewDO payViewDO);

    Page<OwnPurchaseContractViewDO> getOwnPurchaseContract(OwnPurchaseContractQueryCnd cnd);

    Integer saveOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS, List<Integer> ids, String personId);

    Integer getOwnUnfinishedCount(Integer signYear,String inputContent, String userId);

    void deleteOwnPurchaseContractCount(Integer purchaseContractId);

    Page<OwnPurchaseContractViewDO> getOwnPurchaseContractAuditList(OwnPurchaseContractQueryCnd cnd);

    Integer getOwnUnreviewedCount(Integer signYear,String inputContent);

    void auditOwnPurchaseContract(Integer contractId, Integer oldStatus, String personId);

    Page<OwnPurchaseCostPaymentViewDO> getOwnPurchaseCostPaymentList(String purchaseContractNo, Integer pageNo, Integer pageSize);

    PageInfo<OwnPurchaseContractViewDO> getOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCnd cnd);

    List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractWithProgressList(OwnPurchaseContractQueryCnd cnd);

    List<OwnPurchaseContractProgressViewDO> getOwnPurchaseContractProgressList(Integer purchaseContractId);

    String getOwnPurchaseContractNo(Integer hasContract, Integer classification, String signDate);

    Page<OwnPurchaseContractViewDO> getOwnPurchaseContractSelectList(String inputContent, Integer pageNo, Integer pageSize);

    Page<OwnPurchaseContractViewDO> getOwnPurchaseContractSearchList(Integer purchaseContractId,String inputContent, Integer pageNo, Integer pageSize);

    Integer savePurchaseContractProgress(PurchaseContractProgressDO progress);

    Integer updatePurchaseContractProgress(PurchaseContractProgressDO progress);

    OwnPurchaseContractViewDO getOwnPurchaseContract(Integer purchaseContractId);

    List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractList(OwnPurchaseContractQueryCnd cnd);

    PageInfo<OwnPurchaseContractViewDO> getOwnPurchaseContractInfoList(OwnPurchaseContractQueryCnd cnd);

    List<OwnPurchaseContractViewDO> getAllOwnPurchaseContractInfoList(OwnPurchaseContractQueryCnd cnd);

    Integer getPortalPurchaseContractAuditNeedDoCount(String personId);

    boolean existPurchaseContract(String purchaseContractNo);

    void disagreeOwnPurchaseContract(Integer contractId, Integer oldStatus);

    Integer getOwnPurchaseContractSuplementCount(Integer purchaseContractId);

    void alterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentViewDO> contractPaymentViewDOS, String personId);

    void auditAlterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS,String personId);

    void disagreeAlterOwnPurchaseContract(PurchaseContractDO contractDO, List<PurchaseContractPaymentDO> contractPaymentDOS);

    List<PurchaseContractPaymentViewDO> getOwnPurchaseContractPaymentList(Integer purchaseContractId, Integer alterFlag);
}
