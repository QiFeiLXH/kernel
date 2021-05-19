package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.BusinessCardViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 16:00
 * @Description
 */
@Repository
public interface BusinessCardViewDao extends JpaRepository<BusinessCardViewDO, Integer>, JpaSpecificationExecutor<BusinessCardViewDO> {
    @Query("select nvl(sum(a.amount),0) from BusinessCardViewDO a where a.status = 0")
    Double getBusinessCardUnpaidAmount();

    @Query("select nvl(sum(a.amount),0) from BusinessCardViewDO a where a.id in (:businessCardIds)")
    Double getBusinessCardTotalAmount(@Param("businessCardIds") List<Integer> businessCardIds);

    List<BusinessCardViewDO> findAllByIdIn(List<Integer> businessCardIds);

}
