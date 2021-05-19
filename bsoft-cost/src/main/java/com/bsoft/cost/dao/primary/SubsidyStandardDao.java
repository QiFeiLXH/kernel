package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.SubsidyStandardDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:26
 * @Description:
 */
@Repository
public interface SubsidyStandardDao extends JpaRepository<SubsidyStandardDO,Integer>, JpaSpecificationExecutor<SubsidyStandardDO> {

}
