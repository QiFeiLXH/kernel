package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ApplianceStoreDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/17
 * @description 物品库存
 */
@Repository
public interface ApplianceStoreDao extends JpaRepository<ApplianceStoreDO, Integer>, JpaSpecificationExecutor<ApplianceStoreDO> {
    ApplianceStoreDO findByNameAndUnitPrice(Integer name, Double unitPrice);
}
