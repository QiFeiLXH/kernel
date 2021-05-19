package com.bsoft.project.report.manager.impl;

import com.bsoft.project.report.entity.primary.ManpowerCostTViewDO;
import com.bsoft.project.report.manager.ManpowerCostTViewManager;
import com.bsoft.project.report.repository.primary.ManpowerTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Component
public class ManpowerCostTViewManagerImpl implements ManpowerCostTViewManager {

    @Autowired
    private ManpowerTRepository manpowerTRepository;

    @Override
    public List<ManpowerCostTViewDO> findLastYearData() {

        return manpowerTRepository.find();
    }
}
