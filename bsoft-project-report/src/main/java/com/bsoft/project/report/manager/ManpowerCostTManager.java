package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.ManpowerCostTDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ManpowerCostTManager {

    ManpowerCostTDO saveManpowerCostT(ManpowerCostTDO manpowerCostTDO);

    List<ManpowerCostTDO> findLastYearData();

    void saveAll(List<ManpowerCostTDO> list);
}
