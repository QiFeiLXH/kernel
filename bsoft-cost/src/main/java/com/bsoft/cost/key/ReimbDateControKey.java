package com.bsoft.cost.key;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:16
 * @Description:
 */
public class ReimbDateControKey implements Serializable {
    private Integer year;
    private Integer flag;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
