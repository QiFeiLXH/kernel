package com.bsoft.project.manager;

import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.project.entity.primary.ProjectDO;
import com.bsoft.project.entity.primary.ProjectLookDO;
import com.bsoft.project.entity.primary.ProjectRankDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ProjectManager {
    Page<ProjectDO> getProjects(Integer page,Integer size);
    List<ProjectDO> getProjects(List<String> projectIdList);
    Page<ProjectDO> searchProjects(String context,Integer page,Integer size);
    List<ProjectLookDO> getClueProjects(Integer clueId);
    List<String> getAllProjectId();
    ProjectLookDO getProject(String projectId);
    ProjectBaseDO getProjectBase(String projectId);
    List<ProjectRankDO> getMyProjectRank(String personId,Date evalDate);
    ProjectDO saveProject(ProjectDO projectDO);
    List<ProjectBaseDO> getProjectLogCommonProjects(String personId);

    /**
     * 关闭对应的销售项目
     * @param projects
     */
    void closeProjects(List<ProjectDO> projects);

    Page<ProjectDO> getProjectsWithContractNo(Integer pageNo, Integer pageSize, String contractNo);

    PageInfo<ProjectLookDO> getProjectLookList(Integer pageNo, Integer pageSize,String contractNo, String inputContent);
    PageInfo<ProjectLookDO> getProjectList(Integer pageNo, Integer pageSize, String inputContent);

    void updateProjectManager(String projectId, Integer projectManagerId);

    /**
    * @author zy
    * @description 根据合同编号获取项目列表
    * @param contractId 合同编号htbh
    */
    List<ProjectDO> getProjectList(String contractId);

    /**
     * @author zy
     * @description 更新同一合同下项目的终验日期
     * @param contractId 合同编号htbh
     */
    void updateProjectFinalCheckDate(String contractId, Date checkDate);

    void updateProjectUpdateFlag(String projectId, Integer updateFlag);

    // 项目与项目扩展表的同步
    void syncProProjectExpand();

    //同步进度上报中的项目最新进度
    void updateProjectProgress(String projectId,Double progress,Date progressMonth);
}
