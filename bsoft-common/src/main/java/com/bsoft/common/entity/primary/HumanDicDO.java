package com.bsoft.common.entity.primary;

import com.bsoft.common.key.HumanDicKey;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(HumanDicKey.class)
@Table(name = "BSOFTMIS.RS_DMZD")
public class HumanDicDO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    private Integer logout;

    @Id
    @Column(name = "dmsb")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dmmc")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "pydm")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Id
    @Column(name = "dmlb")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "zxbz")
    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }
}
