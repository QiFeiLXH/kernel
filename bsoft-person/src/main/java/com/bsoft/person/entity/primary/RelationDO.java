package com.bsoft.person.entity.primary;

import com.bsoft.person.key.RelationKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 13:01
 * @Description:
 */
@Entity
@IdClass(RelationKey.class)
@Table(name = "bsoftmis.T_RELATION")
public class RelationDO {
    private String zggh;
    private String yggh;
    private Integer bmwh;
    private String zgbm;
    private String ygbm;

    @Id
    public String getZggh() {
        return zggh;
    }

    public void setZggh(String zggh) {
        this.zggh = zggh;
    }

    @Id
    public String getYggh() {
        return yggh;
    }

    public void setYggh(String yggh) {
        this.yggh = yggh;
    }

    @Id
    public Integer getBmwh() {
        return bmwh;
    }

    public void setBmwh(Integer bmwh) {
        this.bmwh = bmwh;
    }

    public String getZgbm() {
        return zgbm;
    }

    public void setZgbm(String zgbm) {
        this.zgbm = zgbm;
    }

    public String getYgbm() {
        return ygbm;
    }

    public void setYgbm(String ygbm) {
        this.ygbm = ygbm;
    }
}
