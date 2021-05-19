package com.bsoft.person.manager;

import com.bsoft.person.entity.primary.PersonInfoDO;

public interface PersonInfoManager {
    PersonInfoDO getPersonInfo(String personId);

    PersonInfoDO savePersonInfo(PersonInfoDO personInfo);
}
