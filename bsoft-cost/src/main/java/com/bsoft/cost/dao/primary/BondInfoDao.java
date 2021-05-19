package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.BondInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface BondInfoDao extends JpaRepository<BondInfoDO,String>, JpaSpecificationExecutor<BondInfoDO> {
    Page<BondInfoDO> findByPayeeAndPerformanceSymbol(String userId,Integer performanceSymbol, Pageable pageable);

    List<BondInfoDO> findByPayeeAndPerformanceSymbol(String userId,Integer performanceSymbol);

    @Query("select a from BondInfoDO a where a.overdueDays = 30 and not exists (select 1 from AccountFrozenDO b where a.id = b.originalNo)")
    List<BondInfoDO> getNeedFrozenAccount();
}
