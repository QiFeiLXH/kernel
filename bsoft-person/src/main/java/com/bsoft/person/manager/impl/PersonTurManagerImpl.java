package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.PersonTurViewDao;
import com.bsoft.person.entity.primary.PersonTurViewDO;
import com.bsoft.person.manager.PersonTurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 15:36
 * @Description:
 */
@Component
public class PersonTurManagerImpl implements PersonTurManager {
    @Autowired
    private PersonTurViewDao personTurViewDao;

    @Override
    public PersonTurViewDO getPersonTur(Integer id) {
        return personTurViewDao.getOne(id);
    }
}
