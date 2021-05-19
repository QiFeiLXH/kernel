package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.CompanySocialMeeterDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySocialMeeterDao extends JpaRepository<CompanySocialMeeterDO, Integer>, JpaSpecificationExecutor<CompanySocialMeeterDO> {
    @Modifying
    @Query("update CompanySocialMeeterDO a set a.meeter = :#{#meeterDO.meeter}, a.meeterName = :#{#meeterDO.meeterName} where a.id =  :#{#meeterDO.id}")
    void updateSocialMeeter(@Param("meeterDO")CompanySocialMeeterDO meeterDO);
}

