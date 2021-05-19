package com.bsoft.project.manager.impl;

import com.bsoft.project.dao.primary.ProjectMilepostDao;
import com.bsoft.project.entity.primary.ProjectMilepostDO;
import com.bsoft.project.manager.ProjectMilepostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 15:22
 * @Version 1.0
 * @Description
 */
@Component
public class ProjectMilepostManagerImpl implements ProjectMilepostManager {
    @Autowired
    private ProjectMilepostDao projectMilepostDao;

    @Override
    public List<ProjectMilepostDO> getValidMilposts() {
        return projectMilepostDao.findByLogoff(0);
    }
}
