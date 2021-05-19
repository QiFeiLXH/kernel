package com.bsoft.project.manager;

import com.bsoft.project.entity.primary.ProjectDeptChangeDO;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 11:21
 * @Description:
 */
public interface ProjectDeptChangeManager {
    List<ProjectDeptChangeDO> getProjectDeptChangeList(String projectID);

    ProjectDeptChangeDO getProjectDeptByPreDate(String project, Date hsrq);

    ProjectDeptChangeDO getFirstProjectChange(String projectid);
    ProjectDeptChangeDO getNewProjectChange(String projectid);
}
