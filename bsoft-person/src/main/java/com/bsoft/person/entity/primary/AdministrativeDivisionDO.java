package com.bsoft.person.entity.primary;


import javax.persistence.*;
import java.util.List;

/**
 * 行政区划
 */
@Entity
@Table(name = "bsoftmis.GY_XZQY")
public class AdministrativeDivisionDO {
    /* 区域ID */
    private Integer code;
    /* 上级区域ID */
    private Integer parentCode;
    /* 区域名称 */
    private String name;
    /* 注销标志 */
    private Integer flag;
    /* 区域级别 */
    private Integer level;
    /* 区域编号 */
    private String zipCode;
    /* 拼音代码 */
    private String pinyin;

    private List<AdministrativeDivisionDO> children;

    @Id
    @Column(name = "qyid")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "sjid")
    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    @Column(name = "qymc")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "zxbz")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "qyjb")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "qybh")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "pydm")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Transient
    public List<AdministrativeDivisionDO> getChildren() {
        return children;
    }

    public void setChildren(List<AdministrativeDivisionDO> children) {
        this.children = children;
    }
}
