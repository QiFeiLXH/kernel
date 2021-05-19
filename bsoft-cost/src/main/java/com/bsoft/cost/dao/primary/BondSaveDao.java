package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.BondSaveDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-17 14:41
 * @Version 1.0
 * @Description
 */
@Repository
public interface BondSaveDao extends JpaRepository<BondSaveDO,String>, JpaSpecificationExecutor<BondSaveDO> {

    @Query("select a from BondSaveDO a where trunc(a.estimatedRefundTime ,'dd') = trunc(sysdate - 30 ,'dd')  AND  a.loanType in (5,7,9) and a.paymentSymbol = 1 and a.writeOffSymbol = 0 and not exists (select 1 from AccountFrozenDO b where a.id = b.originalNo)")
    List<BondSaveDO> getNeedFrozenAccount();
}
