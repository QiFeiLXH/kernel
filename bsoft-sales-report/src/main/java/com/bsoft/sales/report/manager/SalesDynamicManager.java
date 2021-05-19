package com.bsoft.sales.report.manager;

import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface SalesDynamicManager {
    public SalesDynamicDO saveSalesDynamic(SalesDynamicDO salesDynamic);

    public List<SalesDynamicDO> saveSalesDynamic(Map<String,SalesDynamicDO> salesDynamics);

    public Page<SalesDynamicDO> getSalesDynamic(String personId, Integer page, Integer size);

    public Page<SalesDynamicDO> getSalesDynamic(String personId, Integer page);

    public List<SalesDynamicDO> saveSalesDynamic(List<SalesDynamicDO> salesDynamics);
}
