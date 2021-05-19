package com.bsoft.workflow.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
public class GroupRoleDTO implements Serializable {
    /** 主键*/
    private Integer id;
    /** 组名称*/
    private String groupName;
    /** 组成员*/
    private String users;
    /** 组成员姓名*/
    private String usersName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }
}
