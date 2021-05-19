package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/16 9:10
 * @Description
 */
@Repository
public interface SalesContractViewDao extends JpaRepository<SalesContractViewDO,String>, JpaSpecificationExecutor<SalesContractViewDO> {
}
