package com.bsoft.cost.manager.impl;

import com.bsoft.common.key.KeyGenerator;
import com.bsoft.cost.dao.primary.CostRecordDao;
import com.bsoft.cost.entity.primary.CostRecordDO;
import com.bsoft.cost.manager.CostRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2020/9/24 21:17
 * @Description:
 */
@Component
public class CostRecordManagerImpl implements CostRecordManager {
    @Autowired
    private CostRecordDao costRecordDao;
    @Autowired
    private KeyGenerator keyGenerator;
    @Override
    public Integer saveCostRecord(CostRecordDO recordDO) {
        if (recordDO.getId() == null){
            Integer key = keyGenerator.increaseCostRecord();
            recordDO.setId(key);
        }
        return costRecordDao.save(recordDO).getId();
    }

    @Override
    public CostRecordDO getCostRecord(Integer id) {
        return costRecordDao.getOne(id);
    }
}
