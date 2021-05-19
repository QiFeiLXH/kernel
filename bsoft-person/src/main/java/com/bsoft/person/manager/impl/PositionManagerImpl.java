package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.PositionDao;
import com.bsoft.person.entity.primary.PositionDO;
import com.bsoft.person.manager.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:19
 * @Description:
 */
@Component
public class PositionManagerImpl implements PositionManager {

    @Autowired
    private PositionDao positionDao;
    @Override
    public List<PositionDO> findAllByDateAndPersonId(Date ddrq, String yggh) {
        return positionDao.findAllByDate(ddrq,yggh);
    }

    @Override
    public List<PositionDO> findAllByDateAfterAndPersonId(Date ddrq, String yggh) {
        return positionDao.findAllByDateAfter(ddrq,yggh);
    }

    @Override
    public void savePosition(PositionDO positionDO) {
        positionDao.save(positionDO);
    }

    @Override
    public void deleteAllByRecruitmentId(Integer RecruitmentId) {
        positionDao.deleteAllByRecruitmentId(RecruitmentId);
    }
}
