package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/28 13:29
 * @Description
 */
@Repository
public interface ContractProductDao extends JpaRepository<ContractProductDO, Integer>, JpaSpecificationExecutor<ContractProductDO> {
    @Modifying
    @Query("update ContractProductDO a set a.updateFlag = :updateFlag where a.id = :id")
    void updateContractProductUpdateFlag(@Param("id") Integer id, @Param("updateFlag") Integer updateFlag);
}
