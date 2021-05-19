package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.OriginalAcceptanceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:45
 * @Description: 合同原件接收、归档Dao
 */
@Repository
public interface OriginalAcceptanceDao extends JpaRepository<OriginalAcceptanceDO,Integer>, JpaSpecificationExecutor<OriginalAcceptanceDO> {
}
