package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.LastManagerRankDO;

public interface LastManagerRankManager {
    public LastManagerRankDO getLastManagerRank(String personId);
}
