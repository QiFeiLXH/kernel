package com.bsoft.tender.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.tender.dao.primary.TenderDao;
import com.bsoft.tender.dao.primary.TenderViewDao;
import com.bsoft.tender.entity.primary.TenderDO;
import com.bsoft.tender.entity.primary.TenderViewDO;
import com.bsoft.tender.manager.TenderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class TenderManagerImpl implements TenderManager {
    @Autowired
    private TenderDao tenderDao;
    @Autowired
    private TenderViewDao tenderViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Override
    public List<TenderViewDO> getTodayTender() {
        java.sql.Date start =  serverDateManager.getServerDate();
        Date end = serverDateManager.getServerDateTime();
        return tenderViewDao.getTender(start,end);
    }
}
