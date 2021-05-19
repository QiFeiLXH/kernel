package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesPlanDetailViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalesPlanDetailViewDao  extends JpaRepository<SalesPlanDetailViewDO,Integer>, JpaSpecificationExecutor<SalesPlanDetailViewDO> {

}
