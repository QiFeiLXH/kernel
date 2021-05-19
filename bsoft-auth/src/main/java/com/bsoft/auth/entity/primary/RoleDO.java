package com.bsoft.auth.entity.primary;

import javax.persistence.*;

@Entity
@Table(name = "KER_SYS_ROLE" )
public class RoleDO {
    private Integer id;
    private Integer parentId;
    private String name;
    private String roleName;
    private Integer sort;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_ROLE",allocationSize=1,sequenceName="SEQ_KER_SYS_ROLE")
    @GeneratedValue(generator="SEQ_KER_SYS_ROLE",strategy=GenerationType.SEQUENCE)
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
