package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicClueViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicClueViewDao extends JpaRepository<DynamicClueViewDO,Integer>, JpaSpecificationExecutor<DynamicClueViewDO> {
    public List<DynamicClueViewDO> findByDynamicId(Integer dynamicId);
}
