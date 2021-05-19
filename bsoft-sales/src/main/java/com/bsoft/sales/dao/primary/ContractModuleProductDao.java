package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.ContractModuleProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:49
 * @Description
 */
@Repository
public interface ContractModuleProductDao extends JpaRepository<ContractModuleProductDO,Integer>, JpaSpecificationExecutor<ContractModuleProductDO> {
    void deleteByProductIdAndModuleId(Integer productId, Integer moduleId);
}
