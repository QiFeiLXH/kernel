package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectGroupDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.dao
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-07 10:54
 * @Description:
 */
@Repository
public interface ProjectGroupDao extends JpaRepository<ProjectGroupDO,Integer>, JpaSpecificationExecutor<ProjectGroupDO>{
    List<ProjectGroupDO> findAllByContractNoAndParentIdOrderBySortNo(String contractNo, Integer parentId);

    Integer countByContractNoAndParentId(String contractNo, Integer parentId);
}
