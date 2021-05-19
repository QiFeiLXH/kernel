package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurchaseContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 11:14
 * @Description: 采购列表Dao
 */
@Repository
public interface PurchaseContractViewDao extends JpaRepository<PurchaseContractViewDO,Integer>, JpaSpecificationExecutor<PurchaseContractViewDO> {
    @Query("select count(1) from PurchaseContractViewDO a where a.contractNo = :contractNo and a.purchaseContractNo is not null")
    Integer getCountByContractNo(@Param("contractNo")String contractNo);
}
