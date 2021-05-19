package com.bsoft.dictionary.manager;

import java.util.Map;

public interface DictionaryLoader {
    public String getValue(String key);
    public String getValue(Integer type,String key);
}
