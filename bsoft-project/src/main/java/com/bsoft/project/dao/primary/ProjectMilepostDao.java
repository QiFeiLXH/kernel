package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectMilepostDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 15:18
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectMilepostDao extends JpaRepository<ProjectMilepostDO,String>, JpaSpecificationExecutor<ProjectMilepostDO> {
    List<ProjectMilepostDO> findByIdInAndLogoff(List<Integer> Ids, Integer logoff);

    List<ProjectMilepostDO> findByLogoff(Integer logoff);
}
