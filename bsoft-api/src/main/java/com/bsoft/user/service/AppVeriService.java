package com.bsoft.user.service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xucl
 * @DateTime: 2020/7/23 14:14
 * @Description: App登录验证控制
 */
public interface AppVeriService {
    /**
     * 登录设置用户名密码错误次数信息
     * @param uuid 设备号
     * @param mapString
     *  map.put("times",times); 错误次数
     *  map.put("create",createTimes); 创建时间
     * @param timeout 过期时间
     * @param unit 过期时间类型，秒、分、小时、天
     */
    public void setVeriInfo(String uuid, String mapString, long timeout, TimeUnit unit);

    /**
     * @Description: 根据工号获取VeriInfo
     * @param uuid 设备号
     * @return String VeriInfo
     */
    public String getVeriInfo(String uuid);

    /**
     * @Description: 移除该工号的VeriInfo
     * @param uuid 设备号
     */
    public void removeVeriInfo(String uuid);

    /**
     * @Description: 判断VeriInfo是否在redis中
     * @param uuid 设备号
     * @return Boolean true有，false无
     */
    public Boolean hasVeriInfo(String uuid);

    /**
     * 设置验证码
     * @param uuid 设备号
     * @param code
     * @param timeout
     * @param unit
     */
    public void setVerifyCode(String uuid,String code,long timeout, TimeUnit unit);

    /**
     * 获取验证码
     * @param uuid 设备号
     * @return
     */
    public String getVerifyCode(String uuid);
}
