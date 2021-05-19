package com.bsoft.auth.dao.primary;

import com.bsoft.auth.entity.primary.ProjectPermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectPermissionDao extends JpaRepository<ProjectPermissionDO,Integer>, JpaSpecificationExecutor<ProjectPermissionDO> {
    public List<ProjectPermissionDO> findByPersonIdAndFlagAndType(String personId, Integer flag, Integer type);
}
