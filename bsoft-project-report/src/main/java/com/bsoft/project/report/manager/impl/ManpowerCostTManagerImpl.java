package com.bsoft.project.report.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.project.report.dao.primary.ManpowerCostTDao;
import com.bsoft.project.report.entity.primary.ManpowerCostTDO;
import com.bsoft.project.report.manager.ManpowerCostTManager;
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
public class ManpowerCostTManagerImpl implements ManpowerCostTManager {

    @Autowired
    private ManpowerCostTDao manpowerCostTDao;

    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public ManpowerCostTDO saveManpowerCostT(ManpowerCostTDO manpowerCostTDO) {
        return manpowerCostTDao.save(manpowerCostTDO);
    }

    @Override
    public List<ManpowerCostTDO> findLastYearData() {
        LocalDate lastYear = serverDateManager.getServerDate().toLocalDate().minus(13,ChronoUnit.MONTHS);
        return manpowerCostTDao.findByMonthGreaterThan(lastYear);
    }

    @Override
    @Transactional
    public void saveAll(List<ManpowerCostTDO> list) {
        manpowerCostTDao.saveAll(list);
    }
}
