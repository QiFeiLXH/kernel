package com.bsoft.cost.manager.impl;

import com.bsoft.cost.dao.primary.ReimbDateControlDao;
import com.bsoft.cost.entity.primary.ReimbDateControlDO;
import com.bsoft.cost.manager.ReimbDateControlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:22
 * @Description:
 */
@Component
public class ReimbDateControlManagerImpl implements ReimbDateControlManager {
    @Autowired
    private ReimbDateControlDao reimbDateControlDao;
    @Override
    public List<ReimbDateControlDO> getReimbDateControlByYear(Integer year) {
        return reimbDateControlDao.findAllByYear(year);
    }
}
