package com.bsoft.workflow.entity.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Entity
@Table(name = "wf_grouproles")
public class GroupRoleDO {
    /** 主键*/
    @Id
    @SequenceGenerator(name="seq_wf_grouproles",allocationSize=1,sequenceName="seq_wf_grouproles")
    @GeneratedValue(generator="seq_wf_grouproles",strategy=GenerationType.SEQUENCE)
    private Integer id;
    /** 组名称*/
    private String groupName;
    /** 组成员*/
    private String users;
    /** 组成员姓名*/
    @Transient
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
