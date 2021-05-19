package com.bsoft.project.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.dto.*;

import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.service
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-16 13:32
 * @Description: 项目组service
 */
public interface ProjectGroupService {
    /**
     *  功能描述 获取项目组列表
     * @param contractNo 合同编号，
     * @return java.util.List<com.bsoft.project.dto.ProjectGroupViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    List<ProjectGroupViewDTO> getProjectGroupsTree(String contractNo);

    /**
     *  功能描述 获取组长所属项目组列表
     * @param personId 人员id，
     * @param contractNo 合同编号，
     * @return java.util.List<com.bsoft.project.dto.ProjectGroupViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    List<ProjectGroupViewDTO> getLeaderSelfProjectGroupsTree(String personId, String contractNo);

    /**
     * 功能描述 根据查找条件查找项目组成员
     * @param contractNo（合同编号），
     * @param inputContent 输入内容，
     * @param pageSize 每页数量，
     * @param pageNo 页数，
     * @return Result<com.bsoft.project.dto.ProjectGroupDetailViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Result<ProjectGroupDetailViewDTO> getProjectGroupMembers(String contractNo, String inputContent, int pageSize, int pageNo);

    /**
     * 功能描述 根据查找条件查找项目组成员
     * @param contractNo（合同编号），
     * @param personId（员工id），
     * @param inputContent 输入内容，
     * @param pageSize 每页数量，
     * @param pageNo 页数，
     * @return Result<com.bsoft.project.dto.ProjectGroupDetailViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Result<ProjectGroupDetailViewDTO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, int pageSize, int pageNo);


    /**
     *  功能描述 获取子节点列表
     * @param contractNo 合同编号，
     * @param parentId 项目组上级id，
     * @return java.util.List<com.bsoft.project.dto.ProjectGroupViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    List<ProjectGroupDTO> getProjectChildGroups(String contractNo, Integer parentId);

    /**
     *  功能描述 获取子节点数量
     * @param contractNo 合同编号，
     * @param parentId 项目组上级id，
     * @return Integer
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Integer getProjectChildGroupsCount(String contractNo, Integer parentId);

    /**
     *  功能描述 保存项目组节点数据
     * @param projectGroupTreeNode 项目组，
     * @return
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Integer saveProjectGroup(ProjectGroupDTO projectGroupTreeNode);

    /**
     *  功能描述 保存项目组多节点数据
     * @param projectGroupTreeNodes 项目组，
     * @return
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    void saveProjectGroups(List<ProjectGroupDTO> projectGroupTreeNodes);

    /**
     *  功能描述 删除项目组节点数据
     * @param groupId 项目组id，
     * @return
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    void deleteProjectGroup(Integer groupId);

    /**
     * 功能描述 获取项目组成员列表
     * @param groupId 项目组ID，
     * @param pageSize 每页数量，
     * @param pageNo 页数，
     * @return Result<com.bsoft.project.dto.ProjectGroupViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Result<ProjectGroupDetailViewDTO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo);

    /**
     *  功能描述 获取组长自身管理的项目列表
     * @param personId 人员ID，
     * @param pageSize 每页数量，
     * @param pageNo 页数，
     * @return List<com.bsoft.project.dto.ProjectGroupLeaderSelfViewDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Result<ProjectGroupLeaderSelfViewDTO> getLeaderSelfProjectList(String personId, Integer pageSize, Integer pageNo);

    /**
     *  功能描述 获取组长自身管理的项目列表
     * @param contractNo 合同编号
     * @param members 成员列表
     * @param deletes 需要删除的ID
     * @param updates 需要修改的ID
     * @return List<String>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Set<String> saveProjectGroupMembers(String contractNo, List<ProjectGroupDetailDTO> members, List<Integer> deletes, List<Integer> updates);

    /**
     *  功能描述 根据合同号和员工ID判断是否组长
     * @param personId 人员ID，
     * @param contractNo 合同号
     * @return Boolean
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    Boolean isLeader(String personId,String contractNo);

    /**
     * 功能描述 根据合同号和员工ID判断是否组员所在组是否有组长
     * @param personId
     * @param contractNo
     * @return
     */
    Boolean haveLeader(String personId, String contractNo);
}
