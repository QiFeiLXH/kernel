package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ManpowerCostTViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ManpowerCostTViewDao extends JpaRepository<ManpowerCostTViewDO,String>, JpaSpecificationExecutor<ManpowerCostTViewDO> {
    List<ManpowerCostTViewDO> findByMonthGreaterThan(LocalDate date);
}
