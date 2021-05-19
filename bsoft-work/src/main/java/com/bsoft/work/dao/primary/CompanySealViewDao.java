package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ApplianceUseDO;
import com.bsoft.work.entity.primary.CompanySealDO;
import com.bsoft.work.entity.primary.CompanySealViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySealViewDao extends JpaRepository<CompanySealViewDO, Integer>, JpaSpecificationExecutor<CompanySealViewDO> {

    @Query(value = "select a from CompanySealViewDO a  where a.companyId =:companyId")
    CompanySealViewDO getCompanySealView (@Param("companyId") Integer companyId);
}
