package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.CustomerContactViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:24
 * @Description:
 */
@Repository
public interface CustomerContactViewDao extends JpaRepository<CustomerContactViewDO,Integer>, JpaSpecificationExecutor<CustomerContactViewDO> {
}
