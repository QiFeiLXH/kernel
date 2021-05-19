package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfoDO,String>, JpaSpecificationExecutor<PersonInfoDO> {

    @Modifying
    @Query("update PersonInfoDO a set a.costType = :costType where a.personId = :personId")
    void updateCostType(@Param("personId") String personId,@Param("costType") Integer costType);

}
