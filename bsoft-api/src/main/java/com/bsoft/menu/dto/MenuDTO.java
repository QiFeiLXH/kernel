package com.bsoft.menu.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String icon;
    private String object;
    private Integer active;
    private String component;
    private String permisionid;
    private Integer pubFlag;
    private Integer system;
    private List<MenuDTO> child = new ArrayList<>();
    private List<Integer> auth = new ArrayList<>();
    private Integer help;//帮助文档ID

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<MenuDTO> getChild() {
        return child;
    }

    public void setChild(List<MenuDTO> child) {
        this.child = child;
    }

    public List<Integer> getAuth() {
        return auth;
    }

    public void setAuth(List<Integer> auth) {
        this.auth = auth;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPermisionid() {
        return permisionid;
    }

    public void setPermisionid(String permisionid) {
        this.permisionid = permisionid;
    }

    public Integer getPubFlag() {
        return pubFlag;
    }

    public void setPubFlag(Integer pubFlag) {
        this.pubFlag = pubFlag;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public Integer getHelp() {
        return help;
    }

    public void setHelp(Integer help) {
        this.help = help;
    }
}
