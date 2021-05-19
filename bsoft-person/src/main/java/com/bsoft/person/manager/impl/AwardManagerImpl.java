package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.AwardDao;
import com.bsoft.person.entity.primary.AwardDO;
import com.bsoft.person.manager.AwardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AwardManagerImpl implements AwardManager {
    @Autowired
    private AwardDao awardDao;
    @Override
    public AwardDO saveAward(AwardDO award) {
        return awardDao.save(award);
    }

    @Override
    public List<AwardDO> saveAwards(List<AwardDO> awards) {
        if(awards == null){return null;}
        return awardDao.saveAll(awards);
    }

    @Override
    public List<AwardDO> getAwards(String personId) {
        return awardDao.findByPersonId(personId);
    }
}
