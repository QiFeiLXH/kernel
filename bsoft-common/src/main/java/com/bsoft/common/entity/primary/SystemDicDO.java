package com.bsoft.common.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BSOFTMIS.T_DMZD")
public class SystemDicDO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    private Integer xtsb;
    private String saleStage;//dmlb=924 销售阶段

    @Id
    @Column(name = "dmsb")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dmmc")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "srdm")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Column(name = "dmlb")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "xtsb")
    public Integer getXtsb() {
        return xtsb;
    }

    public void setXtsb(Integer xtsb) {
        this.xtsb = xtsb;
    }

    @Column(name = "bzbm")
    public String getSaleStage() {
        return saleStage;
    }

    public void setSaleStage(String saleStage) {
        this.saleStage = saleStage;
    }
}
