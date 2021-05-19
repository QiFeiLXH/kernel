package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.OwnPurchaseContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/5 15:04
 * @Description
 */
@Repository
public interface OwnPurchaseContractViewDao extends JpaRepository<OwnPurchaseContractViewDO,Integer>, JpaSpecificationExecutor<OwnPurchaseContractViewDO> {
    @Query("select count(1) from OwnPurchaseContractViewDO a where (a.status = 0 or a.status = 2 or a.alterFlag = 1)")
    Integer getOwnUnreviewedCount();
}
