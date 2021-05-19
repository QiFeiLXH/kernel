package com.bsoft.sales.report.processor;

import com.bsoft.sales.report.entity.primary.SalesDynamicDO;

import java.util.Map;

public interface DynamicProcessor {
    public void process(Map<String, SalesDynamicDO> dynamic);

    public void save();
}
