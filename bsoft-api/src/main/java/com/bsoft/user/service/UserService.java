package com.bsoft.user.service;

import com.bsoft.common.result.Result;
import com.bsoft.user.dto.AppBoundDTO;
import com.bsoft.user.dto.UserBoundQueryCndDTO;
import com.bsoft.user.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * @Description: 根据工号获取用户信息
     * @param userId 工号
     * @return UserDTO 用户信息对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public UserDTO getUser(String userId);

    /**
     * @Description: 根据工号和密码验证密码是否正确
     * @param userId 工号
     * @param password 密码
     * @return Boolean 密码是否正确标志，true为验证通过，false为验证不通过
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Boolean validatePassword(String userId, String password);

    /**
     * @Description: 根据工号和设备号绑定对应用户的APP设备
     * @param userId 工号
     * @param deviceId App设备号
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月23日 下午3:53:24
     */
    public void buildApp(String userId,String deviceId);

    /**
     * @Description: 根据工号和密码、设备号验证密码并绑定对应用户的APP设备
     * @param userId 工号
     * @param deviceId App设备号
     * @param password 密码
     * @param model 设备型号
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月23日 下午3:53:24
     */
    public Boolean validateAppPassword(String userId,String password,String deviceId,String model);

    /**
     * 根据工号和密码、设备号验证密码并绑定对应用户的APP设备
     * @param userId 工号
     * @param password 密码
     * @param deviceId App设备号
     * @param model 手机
     * @param phoneSystem 手机系统
     * @param address 省市县
     * @param latitude 经度
     * @param longitude 纬度
     * @return
     */
    public Boolean validateAppPassword(String userId,
                                       String password,
                                       String deviceId,
                                       String model,
                                       String phoneSystem,
                                       String address,
                                       String latitude,
                                       String longitude);

    /**
     * @Description: 根据工号验证设备号是否正确，如果未绑定返回true
     * @param userId 工号
     * @param deviceId App设备号
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月23日 下午3:53:24
     */
    public Boolean validateAppDevice(String userId,String deviceId);

    /**
     * @Description: 判断当前用户是否有设备号，主要功能验证是否被解绑
     * @param userId 工号
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月23日 下午3:53:24
     */
    public Boolean isDeviceEmty(String userId);

    /**
     * 获取App已绑定列表
     * @param queryCndDTO
     * @return
     */
    Result<AppBoundDTO> getAppBindList(UserBoundQueryCndDTO queryCndDTO);

    /**
     * 批量解绑App用户
     * @param ids 工号list
     */
    void batchUnBound(List<String> ids,String unbinder);
}
