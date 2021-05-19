package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.PersonCostLimitDao;
import com.bsoft.person.entity.primary.PersonCostLimitDO;
import com.bsoft.person.manager.PersonCostLimitManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:24
 * @Description:
 */
@Component
public class PersonCostLimitManagerImpl implements PersonCostLimitManager {

    @Autowired
    private PersonCostLimitDao personCostLimitDao;
    @Override
    public List<PersonCostLimitDO> findAll(String personId, Integer Costtype, Integer Sourceid) {
        return personCostLimitDao.findAllByPersonidAndCosttypeAndSourceid(personId,Costtype,Sourceid);
    }

    @Override
    public void savePersonCostLimit(PersonCostLimitDO personCostLimitDO) {
        personCostLimitDao.save(personCostLimitDO);
    }

    @Override
    public List<PersonCostLimitDO> getPersonCostLimitList(String personId, Integer costType, Date execuDate) {
        return personCostLimitDao.findAllByPersonidAndCosttypeAndExecudate(personId,costType,execuDate);
    }
}
