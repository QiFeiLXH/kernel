package com.bsoft.project.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.bsoft.project.dto.ProjectDTO;
import com.bsoft.project.dto.ProjectLookDTO;
import com.bsoft.project.dto.ProjectRankDTO;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.project.entity.primary.ProjectDO;
import com.bsoft.project.entity.primary.ProjectLookDO;
import com.bsoft.project.entity.primary.ProjectRankDO;
import com.bsoft.project.manager.ProjectManager;
import com.bsoft.project.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private static final Integer DEFAULT_SIZE = 25;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private IGenerator generatorUtil;

    @Override
    public Result<ProjectDTO> getProjects(Integer page,Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDO> projectPage = projectManager.getProjects(page,size);
        long times = timeConsumer.end();
        logger.info("获取项目列表条数：{}，页数：{}耗时:{}",new Object[]{size,page,times});
        return ResultUtils.parseResult(projectPage,ProjectDTO.class);
    }

    @Override
    public Result<ProjectDTO> getProjects(Integer page) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDO> projectPage = projectManager.getProjects(page,DEFAULT_SIZE);
        long times = timeConsumer.end();
        logger.info("获取项目列表条数：{}，页数：{}耗时:{}",new Object[]{DEFAULT_SIZE,page,times});
        return ResultUtils.parseResult(projectPage,ProjectDTO.class);
    }

    @Override
    public Result<ProjectDTO> searchProjects(String context,Integer page) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDO> projectPage = projectManager.searchProjects(context,page,DEFAULT_SIZE);
        long times = timeConsumer.end();
        logger.info("搜索项目列表内容: {}，条数：{}，页数：{}耗时:{}",new Object[]{context,DEFAULT_SIZE,page,times});
        return ResultUtils.parseResult(projectPage,ProjectDTO.class);
    }
    @Override
    public Result<ProjectDTO> searchProjects(String context,Integer page,Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDO> projectPage = projectManager.searchProjects(context,page,size);
        long times = timeConsumer.end();
        logger.info("搜索项目列表内容: {}，条数：{}，页数：{}，耗时:{}",new Object[]{context,size,page,times});
        return ResultUtils.parseResult(projectPage,ProjectDTO.class);
    }

    @Override
    public List<ProjectLookDTO> getClueProjects(Integer clueId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLookDO> projects =  projectManager.getClueProjects(clueId);
        long times = timeConsumer.end();
        logger.info("获取线索id:{}的线索项目耗时:{}",clueId,times);
        return generatorUtil.convert(projects,ProjectLookDTO.class);
    }

    @Override
    public List<String> getAllProjectId() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> results = projectManager.getAllProjectId();
        long times = timeConsumer.end();
        logger.info("获取所有项目id列表耗时:{}",times);
        return results;
    }

    @Override
    public ProjectLookDTO getProject(String projectId) {
        ProjectLookDO projectLookDO = projectManager.getProject(projectId);
        return generatorUtil.convert(projectLookDO,ProjectLookDTO.class);
    }

    @Override
    public ProjectBaseDTO getProjectBase(String projectId) {
        ProjectBaseDO projectBase = projectManager.getProjectBase(projectId);
        return generatorUtil.convert(projectBase,ProjectBaseDTO.class);
    }

    @Override
    public List<ProjectRankDTO> getProjectRankWithPersonId(String personId, Date evalDate) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectRankDO> result = projectManager.getMyProjectRank(personId,evalDate);
        long times = timeConsumer.end();
        logger.info("获取工号为{}的项目信息耗时:{}",personId,times);
        return generatorUtil.convert(result,ProjectRankDTO.class);
    }

    @Override
    public Result<ProjectDTO> getProjectsWithContractNo(Integer pageNo, Integer pageSize, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectDO> pages = projectManager.getProjectsWithContractNo(pageNo,pageSize,contractNo);
        long times = timeConsumer.end();
        logger.info("获取合同号为：{}的项目信息耗时:{}",contractNo,times);
        return ResultUtils.parseResult(pages,ProjectDTO.class);
    }

    @Override
    public Result<ProjectLookDTO> getProjectLookList(Integer pageNo, Integer pageSize, String contractNo, String inputContent) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectLookDO> pageInfos = projectManager.getProjectLookList(pageNo,pageSize,contractNo,inputContent);
        long times = timeConsumer.end();
        logger.info("获取合同号为：{},项目名称：{}，的项目信息耗时:{}",contractNo,inputContent,times);
        return ResultUtils.parseResult(pageInfos,ProjectLookDTO.class);
    }

    @Override
    public Result<ProjectLookDTO> getAllProjectList(Integer pageNo, Integer pageSize, String inputContent) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectLookDO> pageInfos = projectManager.getProjectList(pageNo,pageSize,inputContent);
        long times = timeConsumer.end();
        logger.info("获取项目信息耗时:{}",inputContent,times);
        return ResultUtils.parseResult(pageInfos,ProjectLookDTO.class);
    }

    @Override
    public void updateProjectManager(String projectId, Integer projectManagerId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectManager.updateProjectManager(projectId,projectManagerId);
        long times = timeConsumer.end();
        logger.info("更新项目的项目经理耗时:{}，projectId：{},projectManagerId:{}",projectId,projectManagerId,times);
    }

    @Override
    public List<ProjectDTO> getProjectList(String contractId) {
        List<ProjectDO> projectList = projectManager.getProjectList(contractId);
        return generatorUtil.convert(projectList, ProjectDTO.class);
    }

    @Override
    public void updateProjectFinalCheckDate(String contractId, Date checkDate) {
        projectManager.updateProjectFinalCheckDate(contractId, checkDate);
    }


    @Override
    public void updateProjectUpdateFlag(String projectId, Integer updateFlag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectManager.updateProjectUpdateFlag(projectId,updateFlag);
        long times = timeConsumer.end();
        logger.info("更新项目更新标志耗时:{}，projectId：{},updateFlag:{}",projectId,updateFlag,times);
    }

    @Override
    public void updateProjectProgress(String projectId, Double progress, Date progressMonth) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        projectManager.updateProjectProgress(projectId, progress, progressMonth);
        long times = timeConsumer.end();
        logger.info("更新项目进度耗时:{}，projectId：{},progress:{},progressMonth:{}",times,projectId,progress,progressMonth);
    }
}
