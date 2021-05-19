package com.bsoft.user.service;

import java.util.concurrent.TimeUnit;

public interface AppTokenService {
    /**
     * @Description: 设置token信息到redis中
     * @param userId 用户工号
     * @param token token信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void setToken(String userId,String token);

    /**
     * @Description: 设置token信息到redis中
     * @param userId 用户工号
     * @param token token信息
     * @param timeout 过期时间
     * @param unit 过期时间类型，秒、分、小时、天
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void setToken(String userId,String token,long timeout,TimeUnit unit);

    /**
     * @Description: 根据工号获取token
     * @param userId 用户工号
     * @return String token信息
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public String getToken(String userId);

    /**
     * @Description: 移除该用户的token信息
     * @param userId 用户工号
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void removeToken(String userId);

    /**
     * @Description: 判断token是否在redis中
     * @param userId 用户工号
     * @return Boolean true有，false无
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Boolean hasToken(String userId);

    /**
     * @Description: 设置token过期时间
     * @param userId 用户工号
     * @param timeout 过期时间
     * @param unit 过期时间类型，秒、分、小时、天
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void expireToken(String userId, long timeout, TimeUnit unit);
}
