package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.CostRecordDO;

/**
 * @Author: xucl
 * @DateTime: 2020/9/24 21:16
 * @Description:
 */
public interface CostRecordManager {
    Integer saveCostRecord(CostRecordDO recordDO);

    CostRecordDO getCostRecord(Integer id);
}
