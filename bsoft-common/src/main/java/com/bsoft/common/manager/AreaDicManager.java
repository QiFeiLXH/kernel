package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.AreaDicDO;
import com.bsoft.common.entity.primary.HumanDicDO;

import java.util.List;

public interface AreaDicManager {
    public List<AreaDicDO> getAreaDic(Integer level);
}
