package com.bsoft.tender.manager;

import com.bsoft.tender.entity.primary.TenderDO;
import com.bsoft.tender.entity.primary.TenderViewDO;

import java.util.List;

public interface TenderManager {
    public List<TenderViewDO> getTodayTender();
}
