package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectBaseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBaseDao extends JpaRepository<ProjectBaseDO,String>, JpaSpecificationExecutor<ProjectBaseDO> {

}
