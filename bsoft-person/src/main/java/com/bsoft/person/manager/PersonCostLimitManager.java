package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.PersonCostLimitDO;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:24
 * @Description:
 */
public interface PersonCostLimitManager {

    List<PersonCostLimitDO> findAll(String personId, Integer Costtype, Integer Sourceid);

    void savePersonCostLimit(PersonCostLimitDO personCostLimitDO);

    List<PersonCostLimitDO> getPersonCostLimitList(String personId, Integer costType, Date execuDate);
}
