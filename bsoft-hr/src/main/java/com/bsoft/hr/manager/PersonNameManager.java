package com.bsoft.hr.manager;

import com.bsoft.hr.entity.primary.PersonNameDO;

public interface PersonNameManager {
    PersonNameDO  findById (String id);
}
