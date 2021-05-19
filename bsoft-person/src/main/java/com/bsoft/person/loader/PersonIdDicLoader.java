package com.bsoft.person.loader;

import com.bsoft.dictionary.manager.DictionaryLoader;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("PersonIdDic")
public class PersonIdDicLoader implements DictionaryLoader {

    @Autowired
    private PersonManager personManager;

    @Override
    public String getValue(String key) {
        if(StringUtils.isNumeric(key)){
            PersonDO person = personManager.getPersonWithId(Integer.valueOf(key));
            if(person != null){
                return person.getPersonName();
            }
        }
        return null;
    }

    @Override
    public String getValue(Integer type, String key) {
        return null;
    }
}
