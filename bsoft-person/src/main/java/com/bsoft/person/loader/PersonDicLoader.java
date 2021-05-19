package com.bsoft.person.loader;

import com.bsoft.dictionary.manager.DictionaryLoader;
import com.bsoft.person.manager.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("PersonDic")
public class PersonDicLoader implements DictionaryLoader {

    @Autowired
    private PersonManager personManager;

    @Override
    public String getValue(String key) {
        return personManager.getPerson(key).getPersonName();
    }

    @Override
    public String getValue(Integer type, String key) {
        return null;
    }
}
