package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.KeyGeneratorDao;
import com.bsoft.common.dao.primary.PubKeyGeneratorDao;
import com.bsoft.common.manager.KeyGeneratorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyGeneratorManagerImpl implements KeyGeneratorManager {
    @Autowired
    private KeyGeneratorDao keyGeneratorDao;
    @Autowired
    private PubKeyGeneratorDao pubKeyGeneratorDao;
    @Override
    public Integer nextKey(String tableName) {
        return keyGeneratorDao.pd_ker_pub_keygenerator(tableName);
    }

    @Override
    public Integer pubNextKey(String tableName) {
        return pubKeyGeneratorDao.pd_ker_public_keygenerator(tableName);
    }
}
