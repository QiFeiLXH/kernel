package com.bsoft.person.entity.primary;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:16
 * @Description: 人员转正按月统计
 */
public class PersonToFormalCountDO {
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
