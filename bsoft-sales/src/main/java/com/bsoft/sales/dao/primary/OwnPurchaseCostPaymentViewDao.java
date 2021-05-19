package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.OwnPurchaseCostPaymentViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/5 15:04
 * @Description
 */
@Repository
public interface OwnPurchaseCostPaymentViewDao extends JpaRepository<OwnPurchaseCostPaymentViewDO,Integer>, JpaSpecificationExecutor<OwnPurchaseCostPaymentViewDO> {
    Page<OwnPurchaseCostPaymentViewDO> findAllByPurchaseContractNo(String purchaseContractNo, Pageable pageable);
}
