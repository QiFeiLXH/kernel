package com.bsoft.sales.report.manager;

import com.bsoft.sales.report.entity.primary.DynamicTenderDO;
import com.bsoft.sales.report.entity.primary.DynamicTenderViewDO;

import java.util.List;

public interface DynamicTenderManager {
    public DynamicTenderDO saveTender(DynamicTenderDO dynamicTender);
    public List<DynamicTenderDO> getTender(Integer dynamicId);
    public List<DynamicTenderViewDO> getTenderView(Integer dynamicId);
    public List<DynamicTenderDO> saveTender(List<DynamicTenderDO> dynamicTenders);
}
