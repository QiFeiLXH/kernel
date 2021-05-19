package com.bsoft.project.report.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.project.report.dao.primary.ManpowerCostPDao;
import com.bsoft.project.report.entity.primary.ManpowerCostPDO;
import com.bsoft.project.report.manager.ManpowerCostPManager;
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
public class ManpowerCostPManagerImpl implements ManpowerCostPManager {

    @Autowired
    private ManpowerCostPDao manpowerCostPDao;

    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public ManpowerCostPDO saveManpowerCostP(ManpowerCostPDO manpowerCostPDO) {
        return manpowerCostPDao.save(manpowerCostPDO);
    }

    @Override
    @Transactional
    public void saveAll(List<ManpowerCostPDO> list) {
        manpowerCostPDao.saveAll(list);
    }

    @Override
    public List<ManpowerCostPDO> findLastYearData() {
        LocalDate lastYear = serverDateManager.getServerDate().toLocalDate().minus(13,ChronoUnit.MONTHS);
        return manpowerCostPDao.findByMonthGreaterThan(lastYear);
    }

    @Override
    public ManpowerCostPDO findNewest() {
        return manpowerCostPDao.findFirstByOrderByMonthDesc();
    }


}
