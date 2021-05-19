package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.DeptReimbDateControlDO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:04
 * @Description:
 */
public interface DeptReimbDateControlManager {
    List<DeptReimbDateControlDO> getControlDate(String deptId, Integer year);
}
