package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectPlanQueryLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.group.dao
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-17 10:25
 * @Description:
 */
@Repository
public interface ProjectPlanQueryLogDao extends JpaRepository<ProjectPlanQueryLogDO,Integer>, JpaSpecificationExecutor<ProjectPlanQueryLogDO> {
}
