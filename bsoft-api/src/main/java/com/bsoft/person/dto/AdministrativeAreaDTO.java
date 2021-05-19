package com.bsoft.person.dto;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/6/2
 * @Description: 新的省市县
 */
public class AdministrativeAreaDTO implements Serializable {

    private Integer id;

    private String name;

    private Integer parentId;

    private Integer level;

    private String pinyin;

    private Integer deleted;

    private Integer divisionId;

    private List<AdministrativeAreaDTO> children;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public List<AdministrativeAreaDTO> getChildren() {
        return children;
    }

    public void setChildren(List<AdministrativeAreaDTO> children) {
        this.children = children;
    }
}
