package com.bsoft.workflow.dto;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-12-09 11:13
 * @Version 1.0
 */
public class CustomerParamDTO implements Serializable {
    private String key;
    private String param;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
