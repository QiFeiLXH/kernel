package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.PurContractPayDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 16:11
 * @Description: 支付信息
 */
@Repository
public interface PurContractPayDao extends JpaRepository<PurContractPayDO,Integer>, JpaSpecificationExecutor<PurContractPayDO> {
}
