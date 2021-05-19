package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesContractModuleViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/17 13:47
 * @Description
 */
@Repository
public interface SalesContractModuleViewDao extends JpaRepository<SalesContractModuleViewDO,Integer>, JpaSpecificationExecutor<SalesContractModuleViewDO> {
    @Query("select count(1) from SalesContractModuleViewDO a where a.contractId = :contractId group by a.id order by a.id")
    List<Integer> getSalesContractModuleCountByContractId(@Param("contractId") String contractId);

}
