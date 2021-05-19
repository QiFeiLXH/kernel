package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.OwnPurchaseContractProgressViewDO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/11/13
 * @Description: 采购合同进度DAO
 */
@Repository
public interface OwnPurchaseContractProgressViewDao extends JpaRepository<OwnPurchaseContractProgressViewDO,Integer>, JpaSpecificationExecutor<OwnPurchaseContractProgressViewDO> {

    List<OwnPurchaseContractProgressViewDO> findAllByPurchaseContractId(Integer purchaseContractId, Sort sort);
}