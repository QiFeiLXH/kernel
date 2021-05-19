package com.bsoft.project.manager.impl;

import com.bsoft.project.dao.primary.ProjectDeptChangeDao;
import com.bsoft.project.entity.primary.ProjectDeptChangeDO;
import com.bsoft.project.manager.ProjectDeptChangeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 11:22
 * @Description:
 */
@Component
public class ProjectDeptChangeManagerImpl implements ProjectDeptChangeManager {
    @Autowired
    private ProjectDeptChangeDao projectDeptChangeDao;
    @Override
    public List<ProjectDeptChangeDO> getProjectDeptChangeList(String projectID) {
        return projectDeptChangeDao.findAllByProject(projectID);
    }

    @Override
    public ProjectDeptChangeDO getProjectDeptByPreDate(String project, Date hsrq) {
        return projectDeptChangeDao.getByProjectAndPreDate(project,hsrq);
    }

    @Override
    public ProjectDeptChangeDO getFirstProjectChange(String projectid) {
        return projectDeptChangeDao.getFirstProjectChange(projectid);
    }

    @Override
    public ProjectDeptChangeDO getNewProjectChange(String projectid) {
        return projectDeptChangeDao.getNewProjectChange(projectid);
    }
}
