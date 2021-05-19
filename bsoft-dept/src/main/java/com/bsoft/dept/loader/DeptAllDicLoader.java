package com.bsoft.dept.loader;

import com.bsoft.dept.manager.DeptManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("DeptAllDic")
public class DeptAllDicLoader implements DictionaryLoader {
    @Autowired
    private DeptManager deptManager;

    @Override
    public String getValue(String key) {
        return deptManager.getDept(key).getDeptName();
    }

    @Override
    public String getValue(Integer type, String key) {
        return null;
    }
}
