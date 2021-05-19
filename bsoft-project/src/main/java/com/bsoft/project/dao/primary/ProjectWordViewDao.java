package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectWordViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.*;

/*
 * @author  hy
 * @date  2020/3/23 9:04
 * @description
 */
@Repository
public interface ProjectWordViewDao extends JpaRepository<ProjectWordViewDO,Integer>, JpaSpecificationExecutor<ProjectWordViewDO> {
    ProjectWordViewDO findByHtbhAndProjectIdAndFileId(String contractId, String projectId, Integer standardWordId);
}
