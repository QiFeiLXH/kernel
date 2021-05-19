package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ManpowerCostPDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Repository
public interface ManpowerCostPDao extends JpaRepository<ManpowerCostPDO,Integer>, JpaSpecificationExecutor<ManpowerCostPDO> {

    List<ManpowerCostPDO> findByMonthGreaterThan(LocalDate date);

    ManpowerCostPDO findFirstByOrderByMonthDesc();
}
