package com.bsoft.contract.loader;

import com.bsoft.contract.manager.ContractSubjectManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ContractSubjectDic")
public class ContractSubjectLoader implements DictionaryLoader {
    @Autowired
    private ContractSubjectManager contractSubjectManager;

    @Override
    public String getValue(String key) {
        return contractSubjectManager.getValue(Integer.valueOf(key)).getName();
    }

    @Override
    public String getValue(Integer type, String key) {
        return null;
    }
}
