package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.ReimbDateControlDO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:21
 * @Description:
 */
public interface ReimbDateControlManager {
    List<ReimbDateControlDO> getReimbDateControlByYear(Integer year);
}
