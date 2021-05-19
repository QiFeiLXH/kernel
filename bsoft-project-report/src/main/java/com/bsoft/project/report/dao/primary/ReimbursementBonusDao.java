package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ReimbursementBonusDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ReimbursementBonusDao extends JpaRepository<ReimbursementBonusDO,Integer>, JpaSpecificationExecutor<ReimbursementBonusDO> {
    List<ReimbursementBonusDO> findByMonthGreaterThan(LocalDate date);
}
