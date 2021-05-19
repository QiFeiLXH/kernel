package com.bsoft.user.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.user.condition.UserBoundQueryCnd;
import com.bsoft.user.dto.AppBoundDTO;
import com.bsoft.user.dto.UnbindViewDTO;
import com.bsoft.user.dto.UserBoundQueryCndDTO;
import com.bsoft.user.dto.UserDTO;
import com.bsoft.user.entity.primary.AppBoundDO;
import com.bsoft.user.entity.primary.UserDO;
import com.bsoft.user.manager.BinderManager;
import com.bsoft.user.manager.UserManager;
import com.bsoft.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserManager userManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private BinderManager binderManager;

    @Override
    public UserDTO getUser(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UserDO users = userManager.getUser(userId);
        long times = timeConsumer.end();
        logger.info("获取工号:{}的用户信息耗时:{}",userId,times);
        return generator.convert(users,UserDTO.class);
    }

    @Override
    public Boolean validatePassword(String userId, String password) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = userManager.validatePassword(userId,password);
        long times = timeConsumer.end();
        logger.info("验证用户工号{}，密码:{}正确性:{}耗时:{}",new Object[]{userId,password,flag,times});
        return flag;
    }

    @Override
    public void buildApp(String userId, String deviceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        binderManager.bindApp(userId,deviceId);
        long times = timeConsumer.end();
        logger.info("绑定APP用户工号:{}，设备号:{}成功，耗时:{}",new Object[]{userId,deviceId,times});
    }

    @Override
    public Boolean validateAppPassword(String userId, String password, String deviceId,String model) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = userManager.validatePassword(userId,password,deviceId,model);
        long times = timeConsumer.end();
        logger.info("验证用户工号{}，密码:{}，设备号:{},型号:{}，正确性:{},耗时:{}",new Object[]{userId,password,deviceId,model,flag,times});
        return flag;
    }

    @Override
    public Boolean validateAppPassword(String userId, String password, String deviceId, String model, String phoneSystem, String address, String latitude, String longitude) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = userManager.validatePassword(userId,password,deviceId,model,phoneSystem,address,latitude,longitude);
        long times = timeConsumer.end();
        logger.info("验证用户工号{}，密码:{}，设备号:{},型号:{}，正确性:{},耗时:{}",new Object[]{userId,password,deviceId,model,flag,times});
        return flag;
    }

    @Override
    public Boolean validateAppDevice(String userId, String deviceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = binderManager.validateDevice(userId,deviceId);
        long times = timeConsumer.end();
        logger.info("验证用户工号:{}，设备号:{}正确性:{}，耗时:{}",new Object[]{userId,deviceId,flag,times});
        return flag;
    }

    @Override
    public Boolean isDeviceEmty(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean flag = binderManager.isDeviceEmty(userId);
        long times = timeConsumer.end();
        logger.info("验证用户工号:{}设备号是否为空，耗时:{}",new Object[]{userId,times});
        return flag;
    }

    @Override
    public Result<AppBoundDTO> getAppBindList(UserBoundQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UserBoundQueryCnd queryCnd = generator.convert(queryCndDTO,UserBoundQueryCnd.class);
        Page<AppBoundDO> pages = userManager.getAppBindList(queryCnd);
        Result<AppBoundDTO> result = ResultUtils.parseResult(pages, AppBoundDTO.class);
        long times = timeConsumer.end();
        logger.info("获取App绑定列表，耗时：{}",times);
        return result;
    }

    @Override
    public void batchUnBound(List<String> ids,String unbinder) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        userManager.batchUnBound(ids,unbinder);
        long times = timeConsumer.end();
        logger.info("批量解绑App用户[{}]，耗时[{}]",ids,times);
    }
}
