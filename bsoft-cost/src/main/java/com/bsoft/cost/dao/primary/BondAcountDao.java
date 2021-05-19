package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.BondAccountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-09 18:35
 * @Version 1.0
 * @Description
 */
@Repository
public interface BondAcountDao extends JpaRepository<BondAccountDO,String>, JpaSpecificationExecutor<BondAccountDO> {
    List<BondAccountDO> findByCostType(Integer costType);
}
