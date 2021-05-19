package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PerformanceViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:20
 * @Description
 */
@Repository
public interface PerformanceViewDao extends JpaRepository<PerformanceViewDO, String>, JpaSpecificationExecutor<PerformanceViewDO> {
}
