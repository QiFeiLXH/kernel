package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurchaseContractProgressDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/11/13
 * @Description: 采购合同进度DAO
 */
@Repository
public interface PurchaseContractProgressDao extends JpaRepository<PurchaseContractProgressDO,Integer>, JpaSpecificationExecutor<PurchaseContractProgressDO> {

    @Modifying
    @Query("update PurchaseContractProgressDO a set a.confirmDate = :#{#progressDO.confirmDate}, a.progress = :#{#progressDO.progress} where a.id = :#{#progressDO.id}")
    void updateProgress(@Param("progressDO")PurchaseContractProgressDO progressDO);
}