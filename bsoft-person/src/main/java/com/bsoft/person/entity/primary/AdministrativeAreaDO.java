package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/6/2
 * @Description: 新的省市县
 */
@Entity
@Table(name = "bsoftmis.pub_admindivi")
public class AdministrativeAreaDO {

    @Id
    @Column(name = "diviid")
    private Integer id;

    @Column(name = "diviname")
    private String name;

    @Column(name = "higherdiviid")
    private Integer parentId;

    @Column(name = "divilevel")
    private Integer level;

    @Column(name = "pycode")
    private String pinyin;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "qyid")
    private Integer divisionId;

    @Transient
    private List<AdministrativeAreaDO> children;

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

    public List<AdministrativeAreaDO> getChildren() {
        return children;
    }

    public void setChildren(List<AdministrativeAreaDO> children) {
        this.children = children;
    }
}
