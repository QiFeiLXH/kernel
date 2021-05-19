package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @Auther: hy
 * @Date: 2020/5/22
 * @Description:
 */
public class AreaDicDTO implements Serializable {
    private Integer id;
    private String name;
    private String pinyin;
    private Integer parentId;
    private Integer cancelFlag;
    private Integer level;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Integer cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
