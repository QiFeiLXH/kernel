package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.ContractProducViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:50
 * @Description
 */
@Repository
public interface ContractProductViewDao extends JpaRepository<ContractProducViewDO,Integer>, JpaSpecificationExecutor<ContractProducViewDO> {
    @Query("select a from ContractProducViewDO a where a.contractId = :contractId and a.moduleIds is null")
    List<ContractProducViewDO> findAllUnrelatedProductByContractId(@Param("contractId") String contractId);
}
