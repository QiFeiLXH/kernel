package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.ManpowerCostPViewDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ManpowerCostPViewManager {
    List<ManpowerCostPViewDO> findLastYearData();
}
