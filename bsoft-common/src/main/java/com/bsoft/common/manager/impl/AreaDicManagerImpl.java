package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.AreaDicDao;
import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.entity.primary.AreaDicDO;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.manager.AreaDicManager;
import com.bsoft.common.manager.HumanDicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaDicManagerImpl implements AreaDicManager {
    private static final String DEFAULT_CACHENAME = "AreaDic";
    private static final String DEFAULT_CACHENAME_LEVEL = DEFAULT_CACHENAME + ":level";

    @Autowired
    private AreaDicDao areaDicDao;

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_LEVEL,key = "#level")
    public List<AreaDicDO> getAreaDic(Integer level) {
        return areaDicDao.findByCancelFlagAndLevel(0,level);
    }
}
