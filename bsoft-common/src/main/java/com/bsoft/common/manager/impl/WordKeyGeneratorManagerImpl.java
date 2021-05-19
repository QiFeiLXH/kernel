package com.bsoft.common.manager.impl;


import com.bsoft.common.dao.second.WordKeyGeneratorDao;
import com.bsoft.common.entity.second.WordKeyGeneratorDO;
import com.bsoft.common.manager.WordKeyGeneratorManager;
import com.bsoft.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class WordKeyGeneratorManagerImpl implements WordKeyGeneratorManager {
    @Autowired
    private WordKeyGeneratorDao wordKeyGeneratorDao;

    @Override
    public Integer nextKey(String tableName) {
        Optional<WordKeyGeneratorDO> optional = wordKeyGeneratorDao.findById(tableName);
        optional.orElseThrow(()->new ServiceException("无该文档明细id"));
        WordKeyGeneratorDO  wordKeyGeneratorDO = optional.get();
        wordKeyGeneratorDO.setTableId(wordKeyGeneratorDO.getTableId()+1);
        wordKeyGeneratorDao.save(wordKeyGeneratorDO);
        return wordKeyGeneratorDO.getTableId();
    }
}
