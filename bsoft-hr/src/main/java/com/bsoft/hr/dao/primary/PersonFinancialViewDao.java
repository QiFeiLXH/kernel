package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonFinancialViewDao extends JpaRepository<PersonFinancialViewDO, String>, JpaSpecificationExecutor<PersonFinancialViewDO> {

    @Query(value ="select pc from PersonFinancialViewDO pc where pc.financialTypeNow=:financialType  " )
    List<PersonFinancialViewDO> findByFinancial(@Param("financialType") Integer financialType);

}
