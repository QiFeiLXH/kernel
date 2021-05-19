package com.bsoft.hr.manager.impl;

import com.bsoft.hr.dao.primary.PersonNameDao;
import com.bsoft.hr.entity.primary.PersonNameDO;
import com.bsoft.hr.manager.PersonNameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonNameManagerImpl  implements PersonNameManager {
    @Autowired
    private PersonNameDao personNameDao;
    @Override
    public PersonNameDO findById(String id) {
        Optional<PersonNameDO> byId = personNameDao.findById(id);
        if(byId!=null){
            return byId.get();
        }
        return null;
    }
}
