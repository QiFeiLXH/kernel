package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurchaseContractPaymentViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 12:13
 * @Description
 */
@Repository
public interface PurchaseContractPaymentViewDao extends JpaRepository<PurchaseContractPaymentViewDO,Integer>, JpaSpecificationExecutor<PurchaseContractPaymentViewDO> {
    List<PurchaseContractPaymentViewDO> findAllByContractIdOrderByPaymentAccountAsc(Integer contractId);
}
