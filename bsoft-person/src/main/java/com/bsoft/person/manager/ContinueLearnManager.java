package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.ContinueLearnDO;

import java.util.List;

public interface ContinueLearnManager {

    ContinueLearnDO saveContinueLearn(ContinueLearnDO continueLearn);

    List<ContinueLearnDO> saveContinueLearns(List<ContinueLearnDO> continueLearns);

    List<ContinueLearnDO> getContinueLearns(String personId);
}
