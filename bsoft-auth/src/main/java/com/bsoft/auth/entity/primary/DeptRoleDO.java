package com.bsoft.auth.entity.primary;

import javax.persistence.*;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description: 部门角色
 */
@Entity
@Table(name = "bsoft_portal.wf_deptroles")
public class DeptRoleDO {

    @Id
    @SequenceGenerator(name="seq_wf_deptroles",allocationSize=1,sequenceName="seq_wf_deptroles")
    @GeneratedValue(generator="seq_wf_deptroles",strategy=GenerationType.SEQUENCE)
    private Integer id;

    private String role;

    private String userId;

    private String dept;

    private Integer roleId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
