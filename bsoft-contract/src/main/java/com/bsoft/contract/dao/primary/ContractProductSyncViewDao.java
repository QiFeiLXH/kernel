package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractProductSyncViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/27 14:34
 * @Description
 */
@Repository
public interface ContractProductSyncViewDao extends JpaRepository<ContractProductSyncViewDO, String>, JpaSpecificationExecutor<ContractProductSyncViewDO> {
}
