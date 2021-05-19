package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.List;

public class AdministrativeDivisionDTO implements Serializable {
    private Integer code;
    private Integer parentCode;
    private String name;
    private Integer flag;
    private Integer level;
    private String zipCode;
    private String pinyin;
    private List<AdministrativeDivisionDTO> children;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public List<AdministrativeDivisionDTO> getChildren() {
        return children;
    }

    public void setChildren(List<AdministrativeDivisionDTO> children) {
        this.children = children;
    }
}
