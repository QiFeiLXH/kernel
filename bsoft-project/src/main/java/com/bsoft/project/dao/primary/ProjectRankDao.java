package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectRankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRankDao extends JpaRepository<ProjectRankDO,Integer>, JpaSpecificationExecutor<ProjectRankDO> {
    List<ProjectRankDO> findByPersonId(String personId);
}
