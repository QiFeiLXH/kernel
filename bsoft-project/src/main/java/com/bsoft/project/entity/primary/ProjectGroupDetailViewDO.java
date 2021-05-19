package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.entity
 * @Author: Xuhui lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组成员明细试图
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_GROUP_DETAIL_VIEW")
public class ProjectGroupDetailViewDO {
    /** 主键  */
    @Id
    private Integer id;
    /** id,用于表格展示唯一键  */
    private Integer detailKey;
    /** 项目组ID  */
    private Integer groupId;
    /** 项目组组名  */
    private String groupName;
    /** 合同编号  */
    private String contractNo;
    /** 组成员工号  */
    private String personId;
    /** 组成员工姓名  */
    private String personName;
    /** 组成员工姓名拼音简码  */
    private String simpleCode;
    /** 一级部门id  */
    private String largeDeptId;
    /** 一级部门名称  */
    private String largeDeptName;
    /** 组成员工部门代码  */
    private String deptCode;
    /** 组成员工部门名称  */
    private String deptName;
    /** 1、组长 0、组员  */
    private Integer leader;
    /** 在职标志 1、离职 0、在职 */
    private String isValid;
    /** 所属项目项目组长工号  */
    private String leaderId;
    /** 所属项目项目组长姓名  */
    private String leaderName;
    /** 所属项目项目组长id  */
    private Integer leaderKey;
    /** 项目组组长维护工号 */
    private String maintainId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDetailKey() {
        return detailKey;
    }

    public void setDetailKey(Integer detailKey) {
        this.detailKey = detailKey;
    }

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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getLargeDeptId() {
        return largeDeptId;
    }

    public void setLargeDeptId(String largeDeptId) {
        this.largeDeptId = largeDeptId;
    }

    public String getLargeDeptName() {
        return largeDeptName;
    }

    public void setLargeDeptName(String largeDeptName) {
        this.largeDeptName = largeDeptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
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

    public Integer getLeaderKey() {
        return leaderKey;
    }

    public void setLeaderKey(Integer leaderKey) {
        this.leaderKey = leaderKey;
    }

    public String getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(String maintainId) {
        this.maintainId = maintainId;
    }
}
