package com.bsoft.menu.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OfficeMenuDTO implements Serializable {
    private Integer id;
    private String routetitle;
    private Integer parentId;
    private Integer sort;
    private String icon;
    private String path;
    private Integer active;
    private String component;
    private String name;
    private Integer pubFlag;
    private Integer system;
    private List<OfficeMenuDTO> children = new ArrayList<>();
    private List<Map> actionEntitySet = new ArrayList<>();
    private List<Integer> actionData = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoutetitle() {
        return routetitle;
    }

    public void setRoutetitle(String routetitle) {
        this.routetitle = routetitle;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<OfficeMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<OfficeMenuDTO> children) {
        this.children = children;
    }

    public List<Map> getActionEntitySet() {
        return actionEntitySet;
    }

    public void setActionEntitySet(List<Map> actionEntitySet) {
        this.actionEntitySet = actionEntitySet;
    }

    public List<Integer> getActionData() {
        return actionData;
    }

    public void setActionData(List<Integer> actionData) {
        this.actionData = actionData;
    }
}
