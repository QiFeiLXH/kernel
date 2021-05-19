package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.DeptPublicCostDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/21 9:27
 * @Description
 */
@Repository
public interface DeptPublicCostDao extends JpaRepository<DeptPublicCostDO,Integer>, JpaSpecificationExecutor<DeptPublicCostDO> {
}
