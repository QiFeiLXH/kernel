package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.RelationDao;
import com.bsoft.person.manager.RelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:27
 * @Description:
 */
@Component
public class RelationManagerImpl implements RelationManager {
    @Autowired
    private RelationDao relationDao;
    @Override
    public void deleteAllByZggh(String zggh) {
        relationDao.deleteAllByZggh(zggh);
    }

    @Override
    public void deleteAllByYggh(String yggh) {
        relationDao.deleteAllByYggh(yggh);
    }
}
