package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectPlanDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author zhanglf
 * @Date 2020-01-19 16:40
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectPlanDao extends JpaRepository<ProjectPlanDO,Integer>, JpaSpecificationExecutor<ProjectPlanDO> {

}
