package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.LastSpecialRankDao;
import com.bsoft.person.entity.primary.LastSpecialRankDO;
import com.bsoft.person.manager.LastSpecialRankManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LastSpecialRankManagerImpl implements LastSpecialRankManager {
    @Autowired
    private LastSpecialRankDao lastSpecialRankDao;
    @Override
    public LastSpecialRankDO getLastSpecialRank(String personId) {
        return lastSpecialRankDao.findByPersonId(personId);
    }
}
