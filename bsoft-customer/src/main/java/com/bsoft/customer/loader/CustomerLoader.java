package com.bsoft.customer.loader;

import com.bsoft.customer.manager.CustomerManager;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CustomerDic")
public class CustomerLoader implements DictionaryLoader {
    @Autowired
    private CustomerManager customerManager;
    @Override
    public String getValue(String key) {
        return customerManager.getCustomer(key).getName();
    }

    @Override
    public String getValue(Integer type, String key) {
        return null;
    }
}
