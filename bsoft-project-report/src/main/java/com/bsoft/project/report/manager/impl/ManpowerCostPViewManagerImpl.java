package com.bsoft.project.report.manager.impl;

import com.bsoft.project.report.entity.primary.ManpowerCostPViewDO;
import com.bsoft.project.report.manager.ManpowerCostPViewManager;
import com.bsoft.project.report.repository.primary.ManpowerPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Component
public class ManpowerCostPViewManagerImpl implements ManpowerCostPViewManager {

    @Autowired
    private ManpowerPRepository manpowerPRepository;

    @Override
    public List<ManpowerCostPViewDO> findLastYearData() {
        return manpowerPRepository.find();
    }

}
