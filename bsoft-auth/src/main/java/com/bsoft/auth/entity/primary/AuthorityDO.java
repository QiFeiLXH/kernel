package com.bsoft.auth.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KER_SYS_AUTHORITY")
public class AuthorityDO implements Serializable {
    private Integer id;
    private String name;
    private Integer menuId;
    private String describe;
    private Integer key;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_AUTHORITY",allocationSize=1,sequenceName="SEQ_KER_SYS_AUTHORITY")
    @GeneratedValue(generator="SEQ_KER_SYS_AUTHORITY",strategy=GenerationType.SEQUENCE)
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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
