package com.bsoft.menu.dto;

import com.bsoft.auth.dto.AuthorityDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:13
 * @Description: 菜单和权限信息  新权限管理系统
 */
public class MenuAndAuthDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private String icon;
    private String object;
    private Integer pubFlag;
    private Integer sort;
    private Integer system;
    private Integer active;
    private String component;
    private String permisionid;
    private Integer range;
    private String remark;
    private Integer help;//帮助文档ID
    private String prefix;
    private String fileName;
    private List<MenuAndAuthDTO> child;
    private List<AuthorityDTO> auth;

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

    public Integer getPubFlag() {
        return pubFlag;
    }

    public void setPubFlag(Integer pubFlag) {
        this.pubFlag = pubFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
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

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getHelp() {
        return help;
    }

    public void setHelp(Integer help) {
        this.help = help;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<MenuAndAuthDTO> getChild() {
        return child;
    }

    public void setChild(List<MenuAndAuthDTO> child) {
        this.child = child;
    }

    public List<AuthorityDTO> getAuth() {
        return auth;
    }

    public void setAuth(List<AuthorityDTO> auth) {
        this.auth = auth;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
