package com.bsoft.common.service;

public interface ServerDateService {
    /**
     * @Description: 获取服务器当前日期
     * @return java.sql.Date 服务器当前日期
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public java.sql.Date getServerDate();
    /**
     * @Description: 获取服务器当前日期和时间（包含时分秒）
     * @return java.sql.Date 服务器当前日期和时间
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public java.util.Date getServerDateTime();
}
