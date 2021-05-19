package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectGroupDetailViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.dao
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-07 10:54
 * @Description:
 */
@Repository
public interface ProjectGroupDetailViewDao extends JpaRepository<ProjectGroupDetailViewDO,Integer>, JpaSpecificationExecutor<ProjectGroupDetailViewDO>{
}
