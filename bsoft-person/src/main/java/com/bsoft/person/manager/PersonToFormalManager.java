package com.bsoft.person.manager;

import com.bsoft.person.condition.PersonToFormalQueryCnd;
import com.bsoft.person.entity.primary.PersonToFormalCountDO;
import com.bsoft.person.entity.primary.PersonToFormalDO;
import com.bsoft.person.entity.primary.PersonTurViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:23
 * @Description:
 */
public interface PersonToFormalManager {

    List<PersonToFormalCountDO> getMonthCount(Integer year);

    Page<PersonToFormalDO> getMonthPersonToFormalList(PersonToFormalQueryCnd cnd);

    PersonTurViewDO getPersonTur(Integer id);
}
