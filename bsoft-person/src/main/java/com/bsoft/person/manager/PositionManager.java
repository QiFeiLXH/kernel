package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.PositionDO;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:17
 * @Description:
 */
public interface PositionManager {

    List<PositionDO> findAllByDateAndPersonId(Date ddrq,String yggh);
    List<PositionDO> findAllByDateAfterAndPersonId(Date ddrq,String yggh);
    void savePosition(PositionDO positionDO);
    void deleteAllByRecruitmentId(Integer RecruitmentId);
}
