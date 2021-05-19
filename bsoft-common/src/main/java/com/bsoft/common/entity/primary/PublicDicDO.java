package com.bsoft.common.entity.primary;

import com.bsoft.common.key.PublicDicKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(PublicDicKey.class)
@Table(name = "BSOFTMIS.GY_DMZD")
public class PublicDicDO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    private Integer sort;
    private String product;
    private Integer flag;
    private String productDept;
    /* 状态 */
    private Integer personflag;
    /* 登记日期 */
    private Date registerDate;
    /* 登记人 */
    private String Registrant;
    @Column(name = "registerDate")
    public Date getRegisterDate() {
        return registerDate;
    }
    @Column(name = "ZXBZ")
    public Integer getPersonflag() {
        return personflag;
    }


    public void setPersonflag(Integer personflag) {
        this.personflag = personflag;
    }


    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    @Column(name = "registrant")
    public String getRegistrant() {
        return Registrant;
    }


    public void setRegistrant(String registrant) {
        Registrant = registrant;
    }



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

    @Column(name = "srdm")
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

    @Column(name = "pxxh")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Column(name = "cpbm")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "lb")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
