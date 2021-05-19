package com.bsoft.sales.dao.primary;

import com.bsoft.sales.entity.primary.SalesPartnerViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Description
 */
@Repository
public interface SalesPartnerViewDao extends JpaRepository<SalesPartnerViewDO,Integer>, JpaSpecificationExecutor<SalesPartnerViewDO> {
    @Query("select a from SalesPartnerViewDO a where a.partnerName like concat(concat('%',:partnerName),'%') or a.nameCode like concat(concat('%',:partnerName),'%')")
    List<SalesPartnerViewDO> findAllByPartnerNameOrNameCodeLike(@Param("partnerName") String partnerName);
}
