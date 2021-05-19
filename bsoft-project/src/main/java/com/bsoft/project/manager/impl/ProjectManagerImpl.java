package com.bsoft.project.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.dao.primary.ProProjectExpandSyncViewDao;
import com.bsoft.project.dao.primary.ProjectBaseDao;
import com.bsoft.project.dao.primary.ProjectDao;
import com.bsoft.project.dto.ProProjectExpandSyncDTO;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectManager;
import com.bsoft.project.repository.primary.ProjectRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectManagerImpl implements ProjectManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectManagerImpl.class);
    @Autowired
    private ProProjectExpandSyncViewDao proProjectExpandSyncViewDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectBaseDao projectBaseDao;
    @Autowired
    private ProjectRepository projectMapper;
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Page<ProjectDO> getProjects(Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return projectDao.findAll(pageable);
    }

    @Override
    public List<ProjectDO> getProjects(List<String> projectIdList) {
        return projectDao.findByProjectIdIn(projectIdList);
    }

    @Override
    public Page<ProjectDO> searchProjects(String context, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProjectDO> projectPage = projectDao.findAll(new Specification<ProjectDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1 = criteriaBuilder.like(root.get("contractNo"),context);
                Predicate predicate2 = criteriaBuilder.like(root.get("projectName"),context);
                Predicate predicate3 = criteriaBuilder.like(root.get("pinyin"),context);
                Predicate predicate4 = criteriaBuilder.or(predicate1,predicate2,predicate3);
                Predicate predicate5 = criteriaBuilder.equal(root.get("finshed"),0);
                return criteriaBuilder.and(predicate4,predicate5);
            }
        },pageable);
        return projectPage;
    }

    @Override
    public List<ProjectLookDO> getClueProjects(Integer clueId) {
        return projectMapper.getProjectByClueId(clueId);
    }

    @Override
    public List<String> getAllProjectId() {
        return projectDao.getAllProjectId();
    }

    @Override
    public ProjectLookDO getProject(String projectId) {
        return projectMapper.getProject(projectId);
    }

    @Override
    public ProjectBaseDO getProjectBase(String projectId) {
        Optional<ProjectBaseDO> projectBase = projectBaseDao.findById(projectId);
        projectBase.orElseThrow(()->new ServiceException("没有找到该项目"));
        return projectBase.get();
    }

    @Override
    public List<ProjectRankDO> getMyProjectRank(String personId,Date evalDate) {
        return projectRepository.getRankProject(personId,evalDate);
    }

    @Override
    public ProjectDO saveProject(ProjectDO projectDO) {
        projectDO = projectDao.save(projectDO);
        return projectDO;
    }

    @Override
    public List<ProjectBaseDO> getProjectLogCommonProjects(String personId) {
        return projectRepository.getProjectLogCommonProjects(personId);
    }

    @Override
    public void closeProjects(List<ProjectDO> projects) {
        projectDao.saveAll(projects);
    }

    @Override
    public Page<ProjectDO> getProjectsWithContractNo(Integer pageNo, Integer pageSize, String contractNo) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<ProjectDO> pages = projectDao.findAllByContractNo(contractNo,pageable);
        return pages;
    }

    @Override
    @Transactional
    public PageInfo<ProjectLookDO> getProjectLookList(Integer pageNo, Integer pageSize, String contractNo, String inputContent) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProjectLookDO> list = projectRepository.getProjectLookList(contractNo, inputContent);
        PageInfo<ProjectLookDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional
    public PageInfo<ProjectLookDO> getProjectList(Integer pageNo, Integer pageSize, String inputContent) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProjectLookDO> list = projectRepository.getAllProjectList(inputContent);
        PageInfo<ProjectLookDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional
    public void updateProjectManager(String projectId, Integer projectManagerId) {
        projectDao.updateProjectManagerByProjectId(projectId, projectManagerId.toString());
    }

    @Override
    public List<ProjectDO> getProjectList(String contractId) {
        List<ProjectDO> list = projectDao.findByContractId(contractId);
        return list;
    }

    @Override
    public void updateProjectFinalCheckDate(String contractId, Date checkDate) {
        List<ProjectDO> projectList = projectDao.findByContractId(contractId);
        List<ProjectDO> saveList = new ArrayList<>();
        projectList.forEach(project -> {
            ProjectDO saveDO = iGenerator.convert(project, ProjectDO.class);
            saveDO.setFinalCheckDate(checkDate);
            saveList.add(saveDO);
        });
        projectDao.saveAll(saveList);
    }


    @Override
    @Transactional
    public void updateProjectUpdateFlag(String projectId, Integer updateFlag) {
        projectDao.updateProjectUpdateFlag(projectId, updateFlag);
    }

    @Override
    public void syncProProjectExpand() {
        List<ProProjectExpandSyncViewDO> projects = proProjectExpandSyncViewDao.findAll();
        if (!projects.isEmpty()) {
            List<ProProjectExpandSyncDTO> projectDTOS = iGenerator.convert(projects, ProProjectExpandSyncDTO.class);
            projectDTOS.parallelStream().forEach(project -> {
                rocketMQTemplate.convertAndSend("snycProject",project);
            });
        }


    }

    @Override
    @Transactional
    public void updateProjectProgress(String projectId, Double progress, Date progressMonth) {
        projectDao.updateProjectProgress(projectId,progress,progressMonth);
    }
}
