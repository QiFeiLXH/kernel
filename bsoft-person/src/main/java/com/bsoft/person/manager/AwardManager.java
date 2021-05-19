package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.AwardDO;

import java.util.List;

public interface AwardManager {
    AwardDO saveAward(AwardDO award);

    List<AwardDO> saveAwards(List<AwardDO> awards);

    List<AwardDO> getAwards(String personId);
}
