package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurchaseContractDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;


/**
 * @Author: xucl
 * @DateTime: 2020/9/23 10:48
 * @Description: 采购合同DAO
 */
@Repository
public interface PurchaseContractDao extends JpaRepository<PurchaseContractDO,Integer>, JpaSpecificationExecutor<PurchaseContractDO> {

    @Modifying
    @Query("update PurchaseContractDO a set a.signDept = :#{#contractDO.signDept}, a.suppliers = :#{#contractDO.suppliers}, a.totalAmount = :#{#contractDO.totalAmount}, a.signer = :#{#contractDO.signer}, a.signDate = :#{#contractDO.signDate}, a.originalStatus = :#{#contractDO.originalStatus},a.outpoint = :#{#contractDO.outpoint}, a.excessAmount = :#{#contractDO.excessAmount}, a.endMark = :#{#contractDO.endMark},a.purchaseNature = :#{#contractDO.purchaseNature} where a.purchaseContractId = :#{#contractDO.purchaseContractId}")
    void updatePurchaseContract(@Param("contractDO")PurchaseContractDO contractDO);

    @Modifying
    @Transactional
    @Query("update PurchaseContractDO a set a.purchaseContractNo = :#{#contractDO.purchaseContractNo}, a.signDate = :#{#contractDO.signDate}, a.classification = :#{#contractDO.classification}, a.hasContract = :#{#contractDO.hasContract}, a.totalAmount = :#{#contractDO.totalAmount}, a.finalCostAmount = :#{#contractDO.finalCostAmount},a.suppliers = :#{#contractDO.suppliers}, a.flag = :#{#contractDO.flag}, a.contractName = :#{#contractDO.contractName},a.productName = :#{#contractDO.productName},a.originalStatus = :#{#contractDO.originalStatus},a.signer = :#{#contractDO.signer},a.signDept = :#{#contractDO.signDept},a.status = :#{#contractDO.status},a.supplementFlag = :#{#contractDO.supplementFlag},a.originalContractId = :#{#contractDO.originalContractId} where a.purchaseContractId = :#{#contractDO.purchaseContractId}")
    void updateOwnPurchaseContract(@Param("contractDO")PurchaseContractDO contractDO);

    @Modifying
    @Query("update PurchaseContractDO a set a.status = :status where a.purchaseContractId = :contractId")
    void updateStatus(@Param("contractId")Integer contractId, @Param("status")Integer status);

    @Modifying
    @Query("update PurchaseContractDO a set a.status = :status,a.endMark = :endMark, a.auditDate = :auditDate, a.auditter = :auditter  where a.purchaseContractId = :contractId")
    void updateStatusAndEndMarkAuditterAndAuditDate(@Param("contractId")Integer contractId, @Param("status")Integer status, @Param("endMark")Integer endMark, @Param("auditDate")Date auditDate, @Param("auditter")String auditter);

    @Modifying
    @Query("update PurchaseContractDO a set a.progress = :progress,a.confirmDate = :confirmDate where a.purchaseContractId = :purchaseContractId")
    void updatePurchaseContractProgress(@Param("purchaseContractId")Integer purchaseContractId, @Param("progress")Double progress, @Param("confirmDate")Date confirmDate);

    Optional<PurchaseContractDO> findByPurchaseContractNo(String purchaseContractNo);

    @Modifying
    @Query("update PurchaseContractDO a set a.status = a.status - 1 where a.purchaseContractId = :contractId")
    void updateStatus(@Param("contractId")Integer contractId);

    @Query("select count(1) from PurchaseContractDO a where a.originalContractId = :originalContractId ")
    Integer getPurchaseContractSupplementCount(@Param("originalContractId")Integer originalContractId);

    @Modifying
    @Query("update PurchaseContractDO a set a.alterAmount = :alterAmount, a.alterFlag = :alterFlag, a.modifyId = :modifyId where a.purchaseContractId = :purchaseContractId")
    void updateAlterAmountAndAlterFlagAndModifyId(@Param("alterAmount")Double alterAmount, @Param("alterFlag")Integer alterFlag, @Param("purchaseContractId")Integer purchaseContractId, @Param("modifyId")Integer modifyId);

    @Modifying
    @Query("update PurchaseContractDO a set a.totalAmount = :#{#contractDO.totalAmount},  a.alterAmount = :#{#contractDO.alterAmount}, a.alterFlag = :#{#contractDO.alterFlag}, a.auditter = :#{#contractDO.auditter} , a.auditDate = :#{#contractDO.auditDate} where a.purchaseContractId = :#{#contractDO.purchaseContractId}")
    void updateAuditAlterPurchaseContract(@Param("contractDO")PurchaseContractDO contractDO);

    @Modifying
    @Query("update PurchaseContractDO a set a.status = :status, a.auditDate = :auditDate, a.auditter = :auditter where a.purchaseContractId = :contractId")
    void updateStatusAndAuditterAndAuditDate(@Param("contractId")Integer contractId, @Param("auditDate")Date auditDate, @Param("auditter")String auditter, @Param("status")Integer status);


}