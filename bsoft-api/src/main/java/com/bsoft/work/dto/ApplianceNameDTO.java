package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称--成本代码字典（type=2）
 */
public class ApplianceNameDTO implements Serializable {
    /** 类别*/
    private Integer type;
    /** 代码识别ID*/
    private Integer id;
    /** 名称*/
    private String name;
    /** 拼音码*/
    private String pinyin;
    /** 规格*/
    private String standards;
    /** 注销标注*/
    private Integer logout;
    /** 物品类别*/
    private Integer applianceType;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(Integer applianceType) {
        this.applianceType = applianceType;
    }
}
