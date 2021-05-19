package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesPlanDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPlanDao extends JpaRepository<SalesPlanDO,Integer>, JpaSpecificationExecutor<SalesPlanDO> {

}
