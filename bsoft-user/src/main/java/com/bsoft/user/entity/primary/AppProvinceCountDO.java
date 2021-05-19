package com.bsoft.user.entity.primary;

/**
 * @author: zy
 * @date: 2020/10/20
 * @description
 */
public class AppProvinceCountDO {
    /* 省份 */
    private String province;
    /* 用户数 */
    private Integer userCount;

    public AppProvinceCountDO() {}

    public AppProvinceCountDO(String province, Integer userCount) {
        this.province = province;
        this.userCount = userCount;
    }

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
