package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.LastManagerRankDao;
import com.bsoft.person.entity.primary.LastManagerRankDO;
import com.bsoft.person.manager.LastManagerRankManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LastManagerRankManagerImpl implements LastManagerRankManager {
    @Autowired
    private LastManagerRankDao lastManagerRankDao;
    @Override
    public LastManagerRankDO getLastManagerRank(String personId) {
        return lastManagerRankDao.findByPersonId(personId);
    }
}
