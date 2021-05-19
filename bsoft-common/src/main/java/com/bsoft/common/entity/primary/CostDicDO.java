package com.bsoft.common.entity.primary;

import com.bsoft.common.key.CostDicKey;

import javax.persistence.*;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
@Entity
@IdClass(CostDicKey.class)
@Table(name = "bsoftmis.cb_dmzd")
public class CostDicDO {
    /** 代码类别*/
    @Id
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
    @Column(name = "protect")
    private Integer protect;
    /** 单价*/
    @Column(name = "dj")
    private Double price;
    /** 规格*/
    private String standards;
    /** 注销标志*/
    private Integer logout;
    /** 子类*/
    private Integer subType;

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

    public Integer getProtect() {
        return protect;
    }

    public void setProtect(Integer protect) {
        this.protect = protect;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }
}
