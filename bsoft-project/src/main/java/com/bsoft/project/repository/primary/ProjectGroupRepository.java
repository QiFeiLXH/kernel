package com.bsoft.project.repository.primary;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-10
 * @Description: 项目组
 */
@Mapper
@Repository
public interface ProjectGroupRepository {
    Integer getGroupLeaderCount(String personId, String contractno);

    String  getGroupLeader(String personId, String contractno);

    String  getProjectManager(String personId);
}
