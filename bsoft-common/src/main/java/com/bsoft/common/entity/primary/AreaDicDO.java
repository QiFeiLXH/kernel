package com.bsoft.common.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther: hy
 * @Date: 2020/5/22
 * @Description:
 */
@Entity
@Table(name = "bsoftmis.gy_xzqy")
public class AreaDicDO implements Serializable {

    @Id
    @Column(name="qyid")
    private Integer id;
    @Column(name="qymc")
    private String name;
    @Column(name="pydm")
    private String pinyin;
    @Column(name="sjid")
    private Integer parentId;
    @Column(name="zxbz")
    private Integer cancelFlag;
    @Column(name="qyjb")
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
