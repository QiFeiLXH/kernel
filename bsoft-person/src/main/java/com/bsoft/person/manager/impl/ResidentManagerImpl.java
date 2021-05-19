package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.ResidentDao;
import com.bsoft.person.entity.primary.ResidentDO;
import com.bsoft.person.manager.ResidentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:10
 * @Description:
 */
@Component
public class ResidentManagerImpl implements ResidentManager {

    @Autowired
    private ResidentDao residentDao;

    @Override
    public void deleteResident(Integer recruitmentId) {
        residentDao.deleteAllByRecruitmentId(recruitmentId);
    }

    @Override
    public void saveRedisent(ResidentDO residentDO) {
        residentDao.save(residentDO);
    }


}
