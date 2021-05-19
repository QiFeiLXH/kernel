package com.bsoft.auth.entity.primary;

import javax.persistence.*;

/**
 * @Author: xucl
 * @DateTime: 2020/10/22 13:26
 * @Description: 人员自定义部门权限
 */
@Entity
@Table(name = "KER_SYS_AUTH_DEPT_P")
public class PersonDeptAuthDO {
    private Integer id;
    private String personId;
    private Integer menuId;
    private String dept;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_AUTH_DEPT_P",allocationSize=1,sequenceName="SEQ_KER_SYS_AUTH_DEPT_P")
    @GeneratedValue(generator="SEQ_KER_SYS_AUTH_DEPT_P",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
