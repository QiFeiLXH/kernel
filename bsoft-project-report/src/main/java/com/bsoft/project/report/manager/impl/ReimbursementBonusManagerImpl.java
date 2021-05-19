package com.bsoft.project.report.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.project.report.dao.primary.ReimbursementBonusDao;
import com.bsoft.project.report.entity.primary.ReimbursementBonusDO;
import com.bsoft.project.report.manager.ReimbursementBonusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Component
public class ReimbursementBonusManagerImpl implements ReimbursementBonusManager {

    @Autowired
    private ReimbursementBonusDao reimbursementBonusDao;

    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public ReimbursementBonusDO saveReimbursementBonus(ReimbursementBonusDO reimbursementBonusDO) {
        return reimbursementBonusDao.save(reimbursementBonusDO);
    }

    @Override
    public List<ReimbursementBonusDO> findLastYearData() {
        LocalDate lastYear = serverDateManager.getServerDate().toLocalDate().minus(13,ChronoUnit.MONTHS);
        return reimbursementBonusDao.findByMonthGreaterThan(lastYear);
    }

    @Transactional
    @Override
    public void saveAll(List<ReimbursementBonusDO> list) {
        reimbursementBonusDao.saveAll(list);
    }
}
