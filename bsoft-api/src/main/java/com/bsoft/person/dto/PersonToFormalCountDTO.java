package com.bsoft.person.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:20
 * @Description:
 */
public class PersonToFormalCountDTO implements Serializable {
    private String month;
    private Integer need;
    private Integer hasToFormal;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getNeed() {
        return need;
    }

    public void setNeed(Integer need) {
        this.need = need;
    }

    public Integer getHasToFormal() {
        return hasToFormal;
    }

    public void setHasToFormal(Integer hasToFormal) {
        this.hasToFormal = hasToFormal;
    }
}
