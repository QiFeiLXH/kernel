package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.PrimaryKeyDao;
import com.bsoft.common.entity.primary.PrimaryKeyDO;
import com.bsoft.common.manager.PrimaryKeyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class PrimaryKeyManagerImpl implements PrimaryKeyManager {

    @Autowired
    private PrimaryKeyDao primaryKeyDao;
    @Override
    @Transactional
    public Integer increase(String table) {
        Optional<PrimaryKeyDO> primaryKeyOp = primaryKeyDao.findById(table);
        if(primaryKeyOp.isPresent()){
            return increase(primaryKeyOp.get());
        }else{
            doSaveTable(table);
            return 1;
        }
    }

    @Override
    @Transactional
    public Integer increaseWithSize(String table, Integer size) {
        Optional<PrimaryKeyDO> primaryKeyOp = primaryKeyDao.findById(table);
        if(primaryKeyOp.isPresent()){
            return increaseWithSize(primaryKeyOp.get(),size);
        }else{
            doSaveTable(table);
            return 1;
        }
    }

    private void doSaveTable(String table){
        PrimaryKeyDO primaryKey = new PrimaryKeyDO();
        primaryKey.setName(table);
        primaryKey.setValue(1);
        primaryKey.setOrigin(1);
        primaryKey.setInc(1);
        primaryKeyDao.save(primaryKey);
    }

    private Integer increase(PrimaryKeyDO primaryKey){
        Integer key = primaryKey.getValue();
        key++;
        primaryKey.setValue(key);
        primaryKeyDao.save(primaryKey);
        return key;
    }

    private Integer increaseWithSize(PrimaryKeyDO primaryKey,Integer size){
        Integer key = primaryKey.getValue();
        Integer saveKey = key+size;
        primaryKey.setValue(saveKey);
        primaryKeyDao.save(primaryKey);
        return key;
    }
}
