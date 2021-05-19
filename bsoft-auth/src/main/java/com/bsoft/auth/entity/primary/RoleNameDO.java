package com.bsoft.auth.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description: 角色名称维护
 */
@Entity
@Table(name = "bsoft_portal.wf_roles")
public class RoleNameDO {

    @Id
    @SequenceGenerator(name="seq_wf_roles",allocationSize=1,sequenceName="seq_wf_roles")
    @GeneratedValue(generator="seq_wf_roles",strategy=GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 30,message = "角色id不能超过30位")
    private String role;

    @Length(max = 30,message = "角色名称不能超过30位")
    private String roleName;

    private Integer status;

    private Integer sort;

    private Integer sourceType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
}
