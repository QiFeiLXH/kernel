package com.bsoft.cost.manager.impl;

import com.bsoft.cost.dao.primary.DeptReimbDateControlDao;
import com.bsoft.cost.entity.primary.DeptReimbDateControlDO;
import com.bsoft.cost.manager.DeptReimbDateControlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:05
 * @Description:
 */
@Component
public class DeptReimbDateControlManagerImpl implements DeptReimbDateControlManager {
    @Autowired
    private DeptReimbDateControlDao deptReimbDateControlDao;
    @Override
    public List<DeptReimbDateControlDO> getControlDate(String deptId, Integer year) {
        return deptReimbDateControlDao.findAllByDeptIdAndControlYear(deptId,year);
    }
}
