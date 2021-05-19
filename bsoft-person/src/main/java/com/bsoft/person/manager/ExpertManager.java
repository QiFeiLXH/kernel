package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.ExpertDO;
import com.bsoft.person.entity.primary.ExpertViewDO;

import java.util.List;

public interface ExpertManager {
    Boolean isExpert(String personId);

    List<ExpertViewDO> getAllExpert();

    List<ExpertDO> getExpertWithType(Integer type);

    ExpertDO saveExpert(ExpertDO expertDO);

    List<ExpertViewDO> getExperts(String context);

    void removeExpert(Integer id);
}
