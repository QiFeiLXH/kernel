package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDynamicDao extends JpaRepository<SalesDynamicDO,Integer>, JpaSpecificationExecutor<SalesDynamicDO> {
    public Page<SalesDynamicDO> findByPersonIdOrderByIdDesc(String personId, Pageable pageable);
}
