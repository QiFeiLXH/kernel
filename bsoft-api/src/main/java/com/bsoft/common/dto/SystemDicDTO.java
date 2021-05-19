package com.bsoft.common.dto;

import java.io.Serializable;

public class SystemDicDTO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    private Integer xtsb;
    private String saleStage;//dmlb=924 销售阶段

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getXtsb() {
        return xtsb;
    }

    public void setXtsb(Integer xtsb) {
        this.xtsb = xtsb;
    }

    public String getSaleStage() {
        return saleStage;
    }

    public void setSaleStage(String saleStage) {
        this.saleStage = saleStage;
    }
}
