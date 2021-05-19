package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.ReimbursementBonusDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ReimbursementBonusManager {

    ReimbursementBonusDO saveReimbursementBonus(ReimbursementBonusDO reimbursementBonusDO);

    List<ReimbursementBonusDO> findLastYearData();

    void saveAll(List<ReimbursementBonusDO> list);
}
