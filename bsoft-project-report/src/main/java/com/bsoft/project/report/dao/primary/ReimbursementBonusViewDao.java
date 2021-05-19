package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ReimbursementBonusViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ReimbursementBonusViewDao extends JpaRepository<ReimbursementBonusViewDO,String>, JpaSpecificationExecutor<ReimbursementBonusViewDO> {
    List<ReimbursementBonusViewDO> findByMonthGreaterThan(LocalDate date);

}
