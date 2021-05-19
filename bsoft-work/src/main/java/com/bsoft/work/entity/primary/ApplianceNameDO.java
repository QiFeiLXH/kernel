package com.bsoft.work.entity.primary;


import com.bsoft.common.key.CostDicKey;

import javax.persistence.*;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称--成本代码字典（type=2）
 */
@Entity
@Table(name = "bsoftmis.cb_dmzd")
public class ApplianceNameDO {
    /** 代码类别*/
    @Column(name = "dmlb")
    private Integer type;

    /** 识别ID*/
    @Id
    @Column(name = "dmsb")
    private Integer id;

    /** 名称*/
    @Column(name = "dmmc")
    private String name;

    /** 拼音码*/
    @Column(name = "pydm")
    private String pinyin;

    /** 规格*/
    private String standards;

    /** 注销标志*/
    private Integer logout;

    /** 子类*/
    @Column(name = "subType")
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