package com.bsoft.user.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/10/20
 * @description APP用户省份分布情况
 */
public class AppProvinceCountDTO implements Serializable {
    /* 省份 */
    private String province;
    /* 用户数 */
    private Integer userCount;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
