package com.bsoft.common.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BSOFTMIS.GY_IDENTITY")
public class PrimaryKeyDO {
    private String name;
    private Integer value;
    private Integer origin;
    private Integer inc;

    @Id
    @Column(name = "tname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "tvalue")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Column(name = "origin_value")
    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    @Column(name = "inc_value")
    public Integer getInc() {
        return inc;
    }

    public void setInc(Integer inc) {
        this.inc = inc;
    }
}
