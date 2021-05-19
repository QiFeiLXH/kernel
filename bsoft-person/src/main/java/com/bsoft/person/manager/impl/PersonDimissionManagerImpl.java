package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.PersonQuitSyncDao;
import com.bsoft.person.entity.primary.PersonQuitSyncDO;
import com.bsoft.person.manager.PersonDimissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonDimissionManagerImpl implements PersonDimissionManager {

    @Autowired
    private PersonQuitSyncDao personQuitSyncDao;

    @Override
    public List<PersonQuitSyncDO> getPersonDimissions() {
        return personQuitSyncDao.findAll();
    }
}
