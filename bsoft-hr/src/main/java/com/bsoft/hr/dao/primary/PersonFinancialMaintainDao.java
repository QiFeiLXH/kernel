package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonFinancialMaintainDao extends JpaRepository<PersonFinancialMaintainDO,Integer>, JpaSpecificationExecutor<PersonFinancialMaintainDO> {

    @Query(value ="select pc from PersonFinancialMaintainDO pc where (pc.financialTypeNow=:financialType or pc.financialTypeAfter=:financialType) and pc.type = 3" )
    List<PersonFinancialMaintainDO> findByFinancial(@Param("financialType") Integer financialType);

}
