package com.bsoft.logs.manager;

import com.bsoft.logs.entity.primary.RequestLogDO;
import com.bsoft.logs.entity.primary.UsageLogDO;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
public interface RequestLogManager {

    void save(RequestLogDO requestLogDO);

    /**
     * 将日志统计数输出到redis
     */
    void sinkToRedis();

    /**
     * 将数据保存至数据库
     */
    void saveCount();

    /**
     * 读取redis数据，初始化菜单访问情况
     */
    void initRedisCache();

    /**
     * 项目关闭时将最新的数据写至redis
     */
    void sinkToRedisWithClose();

    /**
     * 清楚访问情况数据缓存
     */
    void clearCache();
}
