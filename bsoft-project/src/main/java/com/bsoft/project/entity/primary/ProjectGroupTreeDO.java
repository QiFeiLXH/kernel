package com.bsoft.project.entity.primary;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组视图
 */
@Entity
@Table(name="bsoft_portal.pro_group_tree_view")
@Proxy(lazy = false)
public class ProjectGroupTreeDO {
    /** 主键-组别id */
    @Id
    private Integer groupId;
    /** 组名 */
    private String groupName;
    /** 上级ID */
    private Integer parentId;
    /** 合同编号 */
    private String contractNo;
    /** 组长ID */
    private String leaderId;
    /** 组长名字 */
    private String leaderName;
    /** 层级 */
    @Transient
    private Integer levelNo;
    /** 排序号 */
    private Integer sortNo;
    /** 是否有组员 */
    private Integer haveMembers;
    /** 组员数量 */
    private Integer membersNum;
    /** 项目组组长key */
    private Integer leaderKey;
    /** 项目经理维护组长标记 1为项目经理维护 0为非项目经理维护 */
    private Integer managerMaintain;

    @Transient
    private List<ProjectGroupTreeDO> children = new ArrayList<>();


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Integer levelNo) {
        this.levelNo = levelNo;
    }

    public List<ProjectGroupTreeDO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectGroupTreeDO> children) {
        this.children = children;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getHaveMembers() {
        return haveMembers;
    }

    public void setHaveMembers(Integer haveMembers) {
        this.haveMembers = haveMembers;
    }

    public Integer getLeaderKey() {
        return leaderKey;
    }

    public void setLeaderKey(Integer leaderKey) {
        this.leaderKey = leaderKey;
    }

    public Integer getMembersNum() {
        return membersNum;
    }

    public void setMembersNum(Integer membersNum) {
        this.membersNum = membersNum;
    }

    public Integer getManagerMaintain() {
        return managerMaintain;
    }

    public void setManagerMaintain(Integer managerMaintain) {
        this.managerMaintain = managerMaintain;
    }
}
