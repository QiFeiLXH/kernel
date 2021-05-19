package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.ApiUserDO;

public interface ApiUserManager {
    ApiUserDO getApiUser(Integer appid);
}
