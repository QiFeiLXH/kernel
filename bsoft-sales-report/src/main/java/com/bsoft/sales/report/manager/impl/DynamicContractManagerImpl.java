package com.bsoft.sales.report.manager.impl;

import com.bsoft.sales.report.dao.primary.DynamicContractDao;
import com.bsoft.sales.report.dao.primary.DynamicContractViewDao;
import com.bsoft.sales.report.entity.primary.DynamicContractDO;
import com.bsoft.sales.report.entity.primary.DynamicContractViewDO;
import com.bsoft.sales.report.manager.DynamicContractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DynamicContractManagerImpl implements DynamicContractManager {
    @Autowired
    private DynamicContractDao dynamicContractDao;
    @Autowired
    private DynamicContractViewDao dynamicContractViewDao;
    @Override
    public DynamicContractDO saveContract(DynamicContractDO dynamicContract) {
        return dynamicContractDao.save(dynamicContract);
    }

    @Override
    public List<DynamicContractDO> getContract(Integer dynamicId) {
        return dynamicContractDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicContractViewDO> getContractView(Integer dynamicId) {
        return dynamicContractViewDao.findByDynamicId(dynamicId);
    }

    @Override
    public List<DynamicContractDO> saveContract(List<DynamicContractDO> contracts) {
        return dynamicContractDao.saveAll(contracts);
    }
}
