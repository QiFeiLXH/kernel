package com.bsoft.common.loader;

import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SystemDic")
public class SystemDicLoader implements DictionaryLoader {

    @Autowired
    private SystemDicManager systemDicManager;

    @Override
    public String getValue(String key) {
        return null;
    }

    @Override
    public String getValue(Integer type, String key) {
        SystemDicDO systemDicDO = systemDicManager.getValue(type,key);
        return systemDicDO != null ? systemDicDO.getName() : null;
    }
}
