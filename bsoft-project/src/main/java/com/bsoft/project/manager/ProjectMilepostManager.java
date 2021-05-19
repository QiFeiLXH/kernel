package com.bsoft.project.manager;

import com.bsoft.project.entity.primary.ProjectMilepostDO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 15:22
 * @Version 1.0
 * @Description
 */
public interface ProjectMilepostManager {

    /**
     * 查询所有未注销的里程碑用于设置初始计划模板
     * @return
     */
    List<ProjectMilepostDO> getValidMilposts();
}
