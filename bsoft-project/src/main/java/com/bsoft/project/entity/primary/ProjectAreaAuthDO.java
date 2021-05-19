package com.bsoft.project.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhanglf
 * @Date 2020-05-21 14:28
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name="bsoftmis.t_xmqx")
public class ProjectAreaAuthDO {
    private Integer id;
    private String loginId;
    private String area;
    private Integer type;
    private Integer flag;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name="glqx")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name="lx")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
