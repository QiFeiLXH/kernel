package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicClueDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicClueDao extends JpaRepository<DynamicClueDO,Integer>, JpaSpecificationExecutor<DynamicClueDO> {
    public List<DynamicClueDO> findByDynamicId(Integer dynamicId);
}
