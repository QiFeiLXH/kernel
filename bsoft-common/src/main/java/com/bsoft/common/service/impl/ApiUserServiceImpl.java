package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ApiUserDTO;
import com.bsoft.common.entity.primary.ApiUserDO;
import com.bsoft.common.manager.ApiUserManager;
import com.bsoft.common.service.ApiUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private ApiUserManager apiUserManager;
    @Autowired
    private IGenerator generator;
    @Override
    public ApiUserDTO getApiUser(Integer appId) {
        ApiUserDO apiUser = apiUserManager.getApiUser(appId);
        return generator.convert(apiUser,ApiUserDTO.class);
    }
}
