package com.bsoft.sales.report.manager.impl;

import com.bsoft.sales.report.dao.primary.DynamicTenderDao;
import com.bsoft.sales.report.dao.primary.DynamicTenderViewDao;
import com.bsoft.sales.report.entity.primary.DynamicTenderDO;
import com.bsoft.sales.report.entity.primary.DynamicTenderViewDO;
import com.bsoft.sales.report.manager.DynamicTenderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamicTenderManagerImpl implements DynamicTenderManager {
    @Autowired
    private DynamicTenderDao dynamicTenderDao;
    @Autowired
    private DynamicTenderViewDao dynamicTenderViewDao;
    @Override
    public DynamicTenderDO saveTender(DynamicTenderDO dynamicTender) {
        return dynamicTenderDao.save(dynamicTender);
    }

    @Override
    public List<DynamicTenderDO> getTender(Integer dynamicId) {
        return dynamicTenderDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicTenderViewDO> getTenderView(Integer dynamicId) {
        return dynamicTenderViewDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicTenderDO> saveTender(List<DynamicTenderDO> dynamicTenders) {
        return dynamicTenderDao.saveAll(dynamicTenders);
    }
}
