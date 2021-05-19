package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.ContinueLearnDao;
import com.bsoft.person.entity.primary.ContinueLearnDO;
import com.bsoft.person.manager.ContinueLearnManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContinueLearnManagerImpl implements ContinueLearnManager {
    @Autowired
    private ContinueLearnDao continueLearnDao;
    @Override
    public ContinueLearnDO saveContinueLearn(ContinueLearnDO continueLearn) {
        return continueLearnDao.save(continueLearn);
    }

    @Override
    public List<ContinueLearnDO> saveContinueLearns(List<ContinueLearnDO> continueLearns) {
        if(continueLearns == null){return null;}
        return continueLearnDao.saveAll(continueLearns);
    }

    @Override
    public List<ContinueLearnDO> getContinueLearns(String personId) {
        return continueLearnDao.findByPersonId(personId);
    }
}
