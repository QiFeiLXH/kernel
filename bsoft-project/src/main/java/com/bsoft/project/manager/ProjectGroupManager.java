package com.bsoft.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.entity.primary.*;

import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组成员明细Manager
 */
public interface ProjectGroupManager {
    List<ProjectGroupTreeDO> getProjectGroupsTree(String contractNo);

    List<ProjectGroupTreeDO> getLeaderSelfProjectGroupsTree(String personId, String contractNo);

    Result<ProjectGroupDetailViewDO> getProjectGroupMembers(String contractNo, String inputContent, int pageSize, int pageNo);

    Result<ProjectGroupDetailViewDO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, int pageSize, int pageNo);

    ProjectGroupDO saveProjectGroup(ProjectGroupDO projectGroupDO);

    void saveProjectGroups(List<ProjectGroupDO> projectGroupTreeNodes);

    void deleteProjectGroup(Integer groupId);

    List<ProjectGroupDO> getProjectChildGroups(String contractNo, Integer parentId);

    Integer getProjectChildGroupsCount(String contractNo, Integer parentId);

    void saveProjectGroupMembers(List<ProjectGroupDetailDO> projectGroupMembers, List<Integer> deletes);

    Result<ProjectGroupDetailViewDO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo);

    Result<ProjectGroupLeaderSelfViewDO> getLeaderSelfProjectList(String personId, Integer pageSize, Integer pageNo);

    Set<String> checkProjectGroupMembers(String contractNo, List<ProjectGroupDetailDO> members, List<Integer> deletes, List<Integer> updates);

    Boolean isLeader(String personId, String contractNo);

    Boolean haveLeader(String personId, String contractNo);

    String getLeader(String personId, String contractNo);

    String getProjectManager(String personId);

    ProjectGroupDO getGroupById(Integer id);
}
