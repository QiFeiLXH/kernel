package com.bsoft.logs.entity.primary;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
public class RequestLogSinkToRedisDO extends SinkToRedisCountDO {
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
