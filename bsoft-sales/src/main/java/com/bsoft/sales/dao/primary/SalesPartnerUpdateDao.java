package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesPartnerUpdateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Description
 */
@Repository
public interface SalesPartnerUpdateDao extends JpaRepository<SalesPartnerUpdateDO,Integer>, JpaSpecificationExecutor<SalesPartnerUpdateDO> {

}
