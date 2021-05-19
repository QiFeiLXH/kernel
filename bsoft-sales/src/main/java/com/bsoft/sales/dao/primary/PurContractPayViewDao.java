package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurContractPayViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 14:11
 * @Description: 采购合同的支付信息
 */
@Repository
public interface PurContractPayViewDao extends JpaRepository<PurContractPayViewDO,Integer>, JpaSpecificationExecutor<PurContractPayViewDO> {
}
