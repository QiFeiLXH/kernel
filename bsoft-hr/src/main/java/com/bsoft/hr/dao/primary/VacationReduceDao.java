package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.VacationReduceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationReduceDao extends JpaRepository<VacationReduceDO, Integer>, JpaSpecificationExecutor<VacationReduceDO> {
}
