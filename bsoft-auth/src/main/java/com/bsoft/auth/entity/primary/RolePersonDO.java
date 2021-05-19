package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.RolePersonPKey;

import javax.persistence.*;

@Entity
@IdClass(RolePersonPKey.class)
@Table(name = "KER_SYS_ROLEPERSON")
public class RolePersonDO {
    private Integer roleId;
    private String personId;

    @Id
    @Column(name = "roleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "personId")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
