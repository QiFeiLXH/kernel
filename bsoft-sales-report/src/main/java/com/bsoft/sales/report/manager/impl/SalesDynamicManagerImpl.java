package com.bsoft.sales.report.manager.impl;

import com.bsoft.sales.report.dao.primary.SalesDynamicDao;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.SalesDynamicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Component
public class SalesDynamicManagerImpl implements SalesDynamicManager {
    private static final Integer DEFAULT_SIZE = 10;
    @Autowired
    private SalesDynamicDao salesDynamicDao;
    @Override
    public SalesDynamicDO saveSalesDynamic(SalesDynamicDO salesDynamic) {
        return salesDynamicDao.save(salesDynamic);
    }

    @Override
    @Transactional
    public List<SalesDynamicDO> saveSalesDynamic(Map<String, SalesDynamicDO> salesDynamics) {
        return salesDynamicDao.saveAll(salesDynamics.values());
    }

    @Override
    public Page<SalesDynamicDO> getSalesDynamic(String personId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return salesDynamicDao.findByPersonIdOrderByIdDesc(personId,pageable);
    }

    @Override
    public Page<SalesDynamicDO> getSalesDynamic(String personId, Integer page) {
        return getSalesDynamic(personId,page,DEFAULT_SIZE);
    }

    @Override
    public List<SalesDynamicDO> saveSalesDynamic(List<SalesDynamicDO> salesDynamics) {
        return salesDynamicDao.saveAll(salesDynamics);
    }
}
