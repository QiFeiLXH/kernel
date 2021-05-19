package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.ContractModuleViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:49
 * @Description
 */
@Repository
public interface ContractModuleViewDao extends JpaRepository<ContractModuleViewDO,Integer>, JpaSpecificationExecutor<ContractModuleViewDO> {
    @Query("select a from ContractModuleViewDO a where a.contractId = :contractId and a.count = 0")
    List<ContractModuleViewDO> findAllUnrelatedModuleByContractId(@Param("contractId") String contractId);
}
