package com.bsoft.menu.entity.primary;

import javax.persistence.*;

@Entity
@Table(name = "KER_SYS_MENU")
public class OfficeMenuDO {
    private Integer id;
    private String routetitle;
    private Integer parentId;
    private String icon;
    private String path;
    private Integer pubFlag;
    private Integer sort;
    private Integer system;
    private Integer active;
    private String component;
    private String name;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_MENU",allocationSize=1,sequenceName="SEQ_KER_SYS_MENU")
    @GeneratedValue(generator="SEQ_KER_SYS_MENU",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Column(name = "object")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    @Column(name = "permisionid")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
