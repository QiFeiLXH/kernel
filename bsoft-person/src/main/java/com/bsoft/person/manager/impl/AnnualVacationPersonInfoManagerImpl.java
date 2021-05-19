package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.AnnualVacationPersonInfoDao;
import com.bsoft.person.entity.primary.AnnualVacationPersonInfoDO;
import com.bsoft.person.manager.AnnualVacationPersonInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnnualVacationPersonInfoManagerImpl implements AnnualVacationPersonInfoManager {
    @Autowired
    private AnnualVacationPersonInfoDao annualVacationPersonInfoDao;
    @Override
    public List<AnnualVacationPersonInfoDO> getNeedCreateAnnualPerson(List<Integer> types) {
        return annualVacationPersonInfoDao.findAllByTypeIn(types);
    }

    @Override
    public List<AnnualVacationPersonInfoDO> getNeedDeleteAnnualPerson(List<Integer> types) {
        return annualVacationPersonInfoDao.findAllByTypeIn(types);
    }
}
