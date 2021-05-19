package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicTenderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicTenderDao extends JpaRepository<DynamicTenderDO,Integer>, JpaSpecificationExecutor<DynamicTenderDO> {
    public List<DynamicTenderDO> findByDynamicId(Integer dynamicId);
}
