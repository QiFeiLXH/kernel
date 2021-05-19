package com.bsoft.user.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String mobile;
    private String post;
    private String deptId;
    private String deptName;
    private String appdevice;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAppdevice() {
        return appdevice;
    }

    public void setAppdevice(String appdevice) {
        this.appdevice = appdevice;
    }
}
