package com.bsoft.sales.report.manager.impl;

import com.bsoft.sales.report.dao.primary.DynamicClueDao;
import com.bsoft.sales.report.dao.primary.DynamicClueViewDao;
import com.bsoft.sales.report.entity.primary.DynamicClueDO;
import com.bsoft.sales.report.entity.primary.DynamicClueViewDO;
import com.bsoft.sales.report.manager.DynamicClueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DynamicClueManagerImpl implements DynamicClueManager {
    @Autowired
    private DynamicClueDao dynamicClueDao;
    @Autowired
    private DynamicClueViewDao dynamicClueViewDao;
    @Override
    public DynamicClueDO saveClue(DynamicClueDO dynamicClue) {
        return dynamicClueDao.save(dynamicClue);
    }

    @Override
    public List<DynamicClueDO> getClue(Integer dynamicId) {
        return dynamicClueDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicClueViewDO> getClueView(Integer dynamicId) {
        return dynamicClueViewDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicClueDO> save(List<DynamicClueDO> dynamicClues) {
        return dynamicClueDao.saveAll(dynamicClues);
    }
}
