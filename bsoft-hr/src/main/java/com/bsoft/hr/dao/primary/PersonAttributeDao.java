package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PersonAttributeDO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface PersonAttributeDao extends JpaRepository<PersonAttributeDO, String>, JpaSpecificationExecutor<PersonAttributeDO> {

    @Transactional
    @Modifying
    @Query(value = "update PersonAttributeDO pd set pd.financialTypeNow = :financialTypeNow where pd.personId = :personId ")
    void updateInfo(@Param("personId") String personId,@Param("financialTypeNow") Integer financialTypeNow);

}
