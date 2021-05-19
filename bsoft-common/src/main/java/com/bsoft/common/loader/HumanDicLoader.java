package com.bsoft.common.loader;

import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("HumanDic")
public class HumanDicLoader implements DictionaryLoader {
    @Autowired
    private HumanDicManager personDicManager;
    @Override
    public String getValue(String key) {
        return null;
    }

    @Override
    public String getValue(Integer type, String key) {
        if(StringUtils.isNumeric(key)){
            HumanDicDO human = personDicManager.getValue(type,Integer.valueOf(key));
            if(human != null){
                return human.getName();
            }

        }
        return null;
    }
}
