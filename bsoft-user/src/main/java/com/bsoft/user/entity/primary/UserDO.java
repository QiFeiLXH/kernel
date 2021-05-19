package com.bsoft.user.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "BASE_USER")
public class UserDO {
    @NotEmpty(message="工号不能为空")
    private String id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private Integer status;
    @NotNull(message="创建日期不能为空")
    private Date createdt;
    private String appdevice;
    private Integer head;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public String getAppdevice() {
        return appdevice;
    }

    public void setAppdevice(String appdevice) {
        this.appdevice = appdevice;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }
}
