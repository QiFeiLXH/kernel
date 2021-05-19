package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.ManpowerCostTViewDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ManpowerCostTViewManager {
    List<ManpowerCostTViewDO> findLastYearData();
}
