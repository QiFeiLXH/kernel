package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.BankChargesNoBillDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-17 14:41
 * @Version 1.0
 * @Description
 */
@Repository
public interface BankChargesNoBillDao extends JpaRepository<BankChargesNoBillDO,Integer>, JpaSpecificationExecutor<BankChargesNoBillDO> {
    Page<BankChargesNoBillDO> findByApplicant(String userId, Pageable pageable);

    List<BankChargesNoBillDO> findByApplicant(String userId);
}
