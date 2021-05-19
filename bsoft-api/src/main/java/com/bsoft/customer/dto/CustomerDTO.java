package com.bsoft.customer.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/12/7
 * @description 客户基本信息
 */
public class CustomerDTO implements Serializable {
    private String id;
    private String name;
    private String pinyin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
