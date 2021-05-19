package com.bsoft.auth.entity.primary;

import com.bsoft.auth.key.RolePersonPKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/10/27 16:09
 * @Description:
 */
@Entity
@IdClass(RolePersonPKey.class)
@Table(name = "ker_sys_rolePerson_view")
public class RolePersonViewDO {
    private String personId;
    private Integer roleId;
    private String personName;
    private Integer sl;
    private Integer sl2;
    private Integer parentId;
    private String roleName;//角色名称

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Id
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getSl2() {
        return sl2;
    }

    public void setSl2(Integer sl2) {
        this.sl2 = sl2;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
