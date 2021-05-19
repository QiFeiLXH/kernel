package com.bsoft.person.manager.impl;

import com.bsoft.exception.ServiceException;
import com.bsoft.person.dao.primary.PersonInfoDao;
import com.bsoft.person.entity.primary.PersonInfoDO;
import com.bsoft.person.manager.PersonInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonInfoManagerImpl implements PersonInfoManager {
    @Autowired
    private PersonInfoDao personInfoDao;
    @Override
    public PersonInfoDO getPersonInfo(String personId) {
        Optional<PersonInfoDO> personInfo = personInfoDao.findById(personId);
        personInfo.orElseThrow(()->new ServiceException("无工号信息"));
        return personInfo.get();
    }

    @Override
    public PersonInfoDO savePersonInfo(PersonInfoDO personInfo) {
        return personInfoDao.save(personInfo);
    }
}
