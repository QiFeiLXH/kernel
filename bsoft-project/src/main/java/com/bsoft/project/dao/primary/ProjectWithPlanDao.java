package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectWithPlanDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2020-01-17 10:18
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectWithPlanDao extends JpaRepository<ProjectWithPlanDO,String>, JpaSpecificationExecutor<ProjectWithPlanDO> {

}
