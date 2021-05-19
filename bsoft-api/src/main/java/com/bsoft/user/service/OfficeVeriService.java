package com.bsoft.user.service;

import java.util.concurrent.TimeUnit;

public interface OfficeVeriService {

    /**
     * 登录设置用户名密码错误次数信息
     * @param Ip IP信息
     * @param mapString
     *  map.put("times",times); 错误次数
     *  map.put("create",createTimes); 创建时间
     * @param timeout 过期时间
     * @param unit 过期时间类型，秒、分、小时、天
     */
    public void setVeriInfo(String Ip, String mapString, long timeout, TimeUnit unit);

    /**
     * @Description: 根据Ip获取VeriInfo
     * @param Ip Ip地址
     * @return String VeriInfo
     */
    public String getVeriInfo(String Ip);

    /**
     * @Description: 移除该Ip的VeriInfo
     * @param Ip Ip地址
     */
    public void removeVeriInfo(String Ip);

    /**
     * @Description: 判断VeriInfo是否在redis中
     * @param Ip Ip地址
     * @return Boolean true有，false无
     */
    public Boolean hasVeriInfo(String Ip);
}
