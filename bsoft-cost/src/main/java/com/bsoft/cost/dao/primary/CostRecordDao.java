package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.CostRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-24 14:03
 * @Version 1.0
 * @Description
 */
@Repository
public interface CostRecordDao extends JpaRepository<CostRecordDO,Integer>, JpaSpecificationExecutor<CostRecordDO> {

    @Query("select a from CostRecordDO a where trunc(a.paymentTime ,'dd') = trunc(sysdate-(case when a.creditPeriod is null then 30 else a.creditPeriod end),'dd')   AND a.category = 98 and a.costType in (1,2) and a.paymentSymbol = 1 and a.billSymbol = 0 and not exists (select 1 from AccountFrozenDO b where a.id = b.originalNo)")
    List<CostRecordDO> getNeedFrozenAccount();
}
