package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.CommunicationSubsidyDao;
import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.common.manager.CommunicationSubsidyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:20
 * @Description:
 */
@Component
public class CommunicationSubsidyManagerImpl implements CommunicationSubsidyManager {
    @Autowired
    private CommunicationSubsidyDao communicationSubsidyDao;
    @Override
    public List<CommunicationSubsidyDO> getCommunicationSubsidy() {
        return communicationSubsidyDao.findAll();
    }

    @Override
    public CommunicationSubsidyDO getCommunicationSubsidy(Integer id) {
        return communicationSubsidyDao.getOne(id);
    }
}
