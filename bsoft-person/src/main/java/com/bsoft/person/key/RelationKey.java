package com.bsoft.person.key;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 13:03
 * @Description:
 */
public class RelationKey implements Serializable {
    private String zggh;
    private String yggh;
    private Integer bmwh;

    public String getZggh() {
        return zggh;
    }

    public void setZggh(String zggh) {
        this.zggh = zggh;
    }

    public String getYggh() {
        return yggh;
    }

    public void setYggh(String yggh) {
        this.yggh = yggh;
    }

    public Integer getBmwh() {
        return bmwh;
    }

    public void setBmwh(Integer bmwh) {
        this.bmwh = bmwh;
    }
}
