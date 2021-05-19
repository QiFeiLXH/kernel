package com.bsoft.menu.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KER_SYS_MENU")
public class MenuDO implements Serializable{
    private Integer id;
    @Length(max = 30,message = "菜单名称长度不能超过30位")
    private String name;
    private Integer parentId;
    @Length(max = 150,message = "图标地址长度不能超过150位")
    private String icon;
    @Length(max = 150,message = "url路径长度不能超过150位")
    private String object;
    private Integer pubFlag;
    private Integer sort;
    private Integer system;
    private Integer active;
    @Length(max = 90,message = "组件长度不能超过90位")
    private String component;
    private String permisionid;
    private Integer range;
    @Length(max = 150,message = "权限备注长度不能超过150位")
    private String remark;
    private Integer help;//帮助文档ID
    @Length(max = 90,message = "请求前缀长度不能超过90位")
    private String prefix;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_MENU",allocationSize=1,sequenceName="SEQ_KER_SYS_MENU")
    @GeneratedValue(generator="SEQ_KER_SYS_MENU",strategy=GenerationType.SEQUENCE)
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
}
