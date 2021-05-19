package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.UserPermissionKey;

import javax.persistence.*;

@Entity
@IdClass(UserPermissionKey.class)
@Table(name = "bsoftmis.gy_qxgl")
public class UserPermissionDO {
    private String personId;
    private String value;
    private Integer flag;
    private Integer type;
    private String remark;

    @Id
    @Column(name = "yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Id
    @Column(name = "qxdm")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Id
    @Column(name = "qxlb")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Id
    @Column(name = "qxlx")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "bzxx")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
