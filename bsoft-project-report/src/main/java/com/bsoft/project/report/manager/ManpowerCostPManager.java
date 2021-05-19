package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.ManpowerCostPDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
public interface ManpowerCostPManager {

    ManpowerCostPDO saveManpowerCostP(ManpowerCostPDO manpowerCostPDO);

    void saveAll(List<ManpowerCostPDO> list);

    List<ManpowerCostPDO> findLastYearData();

    ManpowerCostPDO findNewest();
}
