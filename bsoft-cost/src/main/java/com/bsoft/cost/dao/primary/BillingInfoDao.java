package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.BillingInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:25
 * @Description: 开票信息Dao
 */
@Repository
public interface BillingInfoDao extends JpaRepository<BillingInfoDO,Integer>, JpaSpecificationExecutor<BillingInfoDO> {
    @Query("select a from BillingInfoDO a where a.invoiceApplyId is not null and a.invoicePdfUrl is null")
    List<BillingInfoDO> findAllNeedUpdateInvoice();
}
