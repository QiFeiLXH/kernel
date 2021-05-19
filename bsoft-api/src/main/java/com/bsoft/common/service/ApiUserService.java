package com.bsoft.common.service;

import com.bsoft.common.dto.ApiUserDTO;

public interface ApiUserService {
    ApiUserDTO getApiUser(Integer appId);
}
