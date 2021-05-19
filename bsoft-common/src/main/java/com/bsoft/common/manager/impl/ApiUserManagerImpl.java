package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.ApiUserDao;
import com.bsoft.common.entity.primary.ApiUserDO;
import com.bsoft.common.manager.ApiUserManager;
import com.bsoft.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApiUserManagerImpl implements ApiUserManager {
    @Autowired
    private ApiUserDao apiUserDao;

    @Override
    public ApiUserDO getApiUser(Integer appid) {
        Optional<ApiUserDO> apiUser = apiUserDao.findById(appid);
        apiUser.orElseThrow(()->new ServiceException("没有该api用户"));
        return apiUser.get();
    }
}
