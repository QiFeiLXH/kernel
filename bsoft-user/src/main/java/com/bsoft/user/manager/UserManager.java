package com.bsoft.user.manager;

import com.bsoft.user.condition.UserBoundQueryCnd;
import com.bsoft.user.entity.primary.AppBoundDO;
import com.bsoft.user.entity.primary.UserDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserManager {
    public void saveUser(UserDO userDO);
    public void deleteUser(String userId);
    public UserDO getUser(String userId);
    public List<UserDO> getAllUser();
    public List<UserDO> getValidUser();
    public Boolean validatePassword(String userId, String password);
    public Boolean validatePassword(String userId, String password,String deviceId,String model);
    public Boolean validatePassword(String userId, String password, String deviceId, String model, String phoneSystem, String address, String latitude, String longitude);
    public Page<AppBoundDO> getAppBindList(UserBoundQueryCnd queryCnd);
    void batchUnBound(List<String> ids,String unbinder);
}
