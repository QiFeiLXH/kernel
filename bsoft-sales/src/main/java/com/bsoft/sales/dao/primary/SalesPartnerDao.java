package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesPartnerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Description
 */
@Repository
public interface SalesPartnerDao extends JpaRepository<SalesPartnerDO,Integer>, JpaSpecificationExecutor<SalesPartnerDO> {

}
