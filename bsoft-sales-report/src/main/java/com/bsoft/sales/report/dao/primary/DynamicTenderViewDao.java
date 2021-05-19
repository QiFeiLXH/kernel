package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicTenderViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicTenderViewDao extends JpaRepository<DynamicTenderViewDO,Integer>, JpaSpecificationExecutor<DynamicTenderViewDO> {
    public List<DynamicTenderViewDO> findByDynamicId(Integer dynamicId);
}
