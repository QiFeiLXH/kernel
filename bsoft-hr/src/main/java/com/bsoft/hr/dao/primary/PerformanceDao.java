package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.PerformanceDO;
import com.bsoft.hr.key.PerformanceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:21
 * @Description
 */
@Repository
public interface PerformanceDao extends JpaRepository<PerformanceDO, PerformanceKey>, JpaSpecificationExecutor<PerformanceDO> {
    List<PerformanceDO> findAllByYear(Integer year);
}
