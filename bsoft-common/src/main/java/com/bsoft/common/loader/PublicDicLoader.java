package com.bsoft.common.loader;

import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("PublicDic")
public class PublicDicLoader implements DictionaryLoader {

    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public String getValue(String key) {
        return null;
    }

    @Override
    public String getValue(Integer type, String key) {
        return publicDicManager.getValue(type,key).getName();
    }
}
