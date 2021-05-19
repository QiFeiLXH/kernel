package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ApplianceUseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
@Repository
public interface ApplianceUseDao extends JpaRepository<ApplianceUseDO, Integer>, JpaSpecificationExecutor<ApplianceUseDO> {
    List<ApplianceUseDO> findAllByStockId(Integer stockId);
}
