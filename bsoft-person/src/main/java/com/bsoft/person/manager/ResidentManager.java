package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.ResidentDO;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:09
 * @Description: 驻地
 */
public interface ResidentManager {

    void deleteResident(Integer recruitmentId);

    void saveRedisent(ResidentDO residentDO);
}
