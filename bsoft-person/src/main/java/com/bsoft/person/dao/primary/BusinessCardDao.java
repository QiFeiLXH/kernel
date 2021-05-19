package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.BusinessCardDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BusinessCardDao extends JpaRepository<BusinessCardDO,Integer>, JpaSpecificationExecutor<BusinessCardDO> {
    @Query("select a from BusinessCardDO a where a.personId = :personId and a.id = (select max(id) from BusinessCardDO where personId = :personId)")
    public BusinessCardDO getLastedCard(@Param("personId") String personId);

    @Modifying
    @Query("update BusinessCardDO a set a.status = 1, a.applyPayDate = :serverDate where a.id in (:ids)")
    void updateStatusAndApplyPayDateByIdIn(@Param("ids") List<Integer> businessCardIds, @Param("serverDate") Date serverDate);

    @Modifying
    @Query("update BusinessCardDO a set a.status = 2 where a.id in (:ids)")
    void updateStatusByIdIn(@Param("ids") List<Integer> businessCardIds);

}
