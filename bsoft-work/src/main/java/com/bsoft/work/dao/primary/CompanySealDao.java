package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.CompanySealDO;
import com.bsoft.work.entity.primary.CompanySealViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySealDao extends JpaRepository<CompanySealDO, Integer>, JpaSpecificationExecutor<CompanySealDO> {
}
