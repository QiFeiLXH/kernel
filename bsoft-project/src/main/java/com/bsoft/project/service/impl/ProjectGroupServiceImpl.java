package com.bsoft.project.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.message.manager.MessageSenderManager;
import com.bsoft.project.dto.*;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectGroupManager;
import com.bsoft.project.service.ProjectGroupService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.service.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description:
 */
@Service
public class ProjectGroupServiceImpl implements ProjectGroupService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectGroupServiceImpl.class);
    @Autowired
    private ProjectGroupManager projectGroupManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private MessageSenderManager messageSenderManager;

    @Override
    public List<ProjectGroupViewDTO> getProjectGroupsTree(String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupTreeDO> tree = projectGroupManager.getProjectGroupsTree(contractNo);
        long times = timeConsumer.end();
        List<ProjectGroupViewDTO> projectGroupViewDTOList = generator.convert(tree, ProjectGroupViewDTO.class);
        logger.info("获取成员管理-项目组列表耗时:{},合同号：{}",new Object[]{times,contractNo});
        return projectGroupViewDTOList;
    }

    @Override
    public List<ProjectGroupViewDTO> getLeaderSelfProjectGroupsTree(String personId, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupTreeDO> leaderGroup = projectGroupManager.getLeaderSelfProjectGroupsTree(personId,contractNo);
        long times = timeConsumer.end();
        List<ProjectGroupViewDTO> projectGroupViewDTOList = generator.convert(leaderGroup, ProjectGroupViewDTO.class);
        logger.info("获取组员维护-项目组列表耗时:{},工号:{},合同号:{}",new Object[]{times,personId,contractNo});
        return projectGroupViewDTOList;
    }

    @Override
    public Result<ProjectGroupDetailViewDTO> getProjectGroupMembers(String contractNo, String inputContent, int pageSize, int pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectGroupDetailViewDO> projectGroupDetailViewDOResult = projectGroupManager.getProjectGroupMembers(contractNo, inputContent, pageSize, pageNo);
        long times = timeConsumer.end();
        Result<ProjectGroupDetailViewDTO> projectGroupDetailViewDTOResult = generator.convert(projectGroupDetailViewDOResult, ProjectGroupDetailViewDTO.class);
        logger.info("获取成员管理指定条件项目组成员耗时:{},合同号:{},筛选条件:{},每页条数:{},页码:{}",new Object[]{times,contractNo,inputContent,pageSize,pageNo});
        return projectGroupDetailViewDTOResult;
    }

    @Override
    public Result<ProjectGroupDetailViewDTO> getProjectLeaderGroupMembers(String contractNo, String personId, String inputContent, int pageSize, int pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectGroupDetailViewDO> projectGroupDetailViewDOResult = projectGroupManager.getProjectLeaderGroupMembers(contractNo, personId, inputContent, pageSize, pageNo);
        long times = timeConsumer.end();
        Result<ProjectGroupDetailViewDTO> projectGroupDetailViewDTOResult = generator.convert(projectGroupDetailViewDOResult, ProjectGroupDetailViewDTO.class);
        logger.info("获取组员维护指定条件项目组成员耗时:{},合同号:{},工号:{},筛选条件:{},每页条数:{},页码:{}",new Object[]{times,contractNo,personId,inputContent,pageSize,pageNo});
        return projectGroupDetailViewDTOResult;
    }


    @Override
    public List<ProjectGroupDTO> getProjectChildGroups(String contractNo, Integer parentId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupDO> ProjectGroupDOList = projectGroupManager.getProjectChildGroups(contractNo, parentId);
        long times = timeConsumer.end();
        List<ProjectGroupDTO> ProjectGroupDTOList = generator.convert(ProjectGroupDOList, ProjectGroupDTO.class);
        logger.info("获取子组列表耗时:{},合同号:{},上级项目组id:{}",new Object[]{times,contractNo,parentId});
        return ProjectGroupDTOList;
    }

    @Override
    public Integer getProjectChildGroupsCount(String contractNo, Integer parentId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer projectChildGroupsCount = projectGroupManager.getProjectChildGroupsCount(contractNo, parentId);
        long times = timeConsumer.end();
        logger.info("获取子组数量耗时:{},合同号:{},上级项目组id:{}",new Object[]{times,contractNo,parentId});
        return projectChildGroupsCount;
    }


    @Override
    public Integer saveProjectGroup(ProjectGroupDTO projectGroupTreeNode) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectGroupDO projectGroupDO = generator.convert(projectGroupTreeNode, ProjectGroupDO.class);
        Integer groupId = projectGroupManager.saveProjectGroup(projectGroupDO).getId();
        long times = timeConsumer.end();
        logger.info("保存项目组节点数据耗时:{}",times);
        return groupId;
    }

    @Override
    public void saveProjectGroups(List<ProjectGroupDTO> projectGroupTreeNodes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupDO> projectGroupDOList = generator.convert(projectGroupTreeNodes, ProjectGroupDO.class);
        projectGroupManager.saveProjectGroups(projectGroupDOList);
        long times = timeConsumer.end();
        logger.info("保存项目组节点数据耗时:{}",times);
    }

    @Override
    public void deleteProjectGroup(Integer groupId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectGroupManager.deleteProjectGroup(groupId);
        long times = timeConsumer.end();
        logger.info("删除项目组节点数据耗时:{},项目组id:{}",new Object[]{times,groupId});
    }

    @Override
    public Result<ProjectGroupDetailViewDTO> getProjectGroupMembersList(Integer groupId, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectGroupDetailViewDO> projectGroupDetailViewDOResult = projectGroupManager.getProjectGroupMembersList(groupId, pageSize, pageNo);
        long times = timeConsumer.end();
        Result<ProjectGroupDetailViewDTO> projectGroupDetailViewDTOResult = generator.convert(projectGroupDetailViewDOResult, ProjectGroupDetailViewDTO.class);
        logger.info("获取成员管理-项目组成员列表耗时:{},项目组id:{},每页条数:{},页码:{}",new Object[]{times,groupId,pageSize,pageNo});
        return projectGroupDetailViewDTOResult;
    }


    @Override
    public Result<ProjectGroupLeaderSelfViewDTO> getLeaderSelfProjectList(String personId, Integer pageSize, Integer pageNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<ProjectGroupLeaderSelfViewDO> projectGroupLeaderSelfViewResult = projectGroupManager.getLeaderSelfProjectList(personId,pageSize,pageNo);
        long times = timeConsumer.end();
        Result<ProjectGroupLeaderSelfViewDTO> projectGroupLeaderSelfViewDTOResult = generator.convert(projectGroupLeaderSelfViewResult, ProjectGroupLeaderSelfViewDTO.class);
        logger.info("获取组员维护-组长自身管理的项目列表耗时:{},工号:{},每页条数:{}, 页码:{}",new Object[]{times,personId,pageSize,pageNo});
        return projectGroupLeaderSelfViewDTOResult;
    }

    @Override
    public Set<String> saveProjectGroupMembers(String contractNo, List<ProjectGroupDetailDTO> members, List<Integer> deletes, List<Integer> updates) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectGroupDetailDO> groupMembers = generator.convert(members,ProjectGroupDetailDO.class);
        Set<String> personIds = projectGroupManager.checkProjectGroupMembers(contractNo,groupMembers,deletes,updates);
        if(personIds.isEmpty()){
            projectGroupManager.saveProjectGroupMembers(groupMembers,deletes);
        }
        messageSenderManager.sendProjectLogUpdate(contractNo);
        long times = timeConsumer.end();
        logger.info("批量保存/修改/删除项目组成员列表耗时:{}",times);
        return personIds;
    }

    @Override
    public Boolean isLeader(String personId, String contractNo) {
        return projectGroupManager.isLeader(personId,contractNo);
    }

    @Override
    public Boolean haveLeader(String personId, String contractNo) {
        return projectGroupManager.haveLeader(personId,contractNo);
    }

}
