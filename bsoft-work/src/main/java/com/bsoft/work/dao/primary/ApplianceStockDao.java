package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ApplianceStockDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
@Repository
public interface ApplianceStockDao extends JpaRepository<ApplianceStockDO, Integer>, JpaSpecificationExecutor<ApplianceStockDO> {
}
