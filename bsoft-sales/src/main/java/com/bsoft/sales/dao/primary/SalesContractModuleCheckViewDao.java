package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesContractModuleCheckViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 11:04
 * @Description
 */
@Repository
public interface SalesContractModuleCheckViewDao extends JpaRepository<SalesContractModuleCheckViewDO,Integer>, JpaSpecificationExecutor<SalesContractModuleCheckViewDO> {
    Page<SalesContractModuleCheckViewDO> findAllByContractId(String contractId, Pageable pageable);
}
