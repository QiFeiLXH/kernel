package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogQueryDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectLogQueryDetailDao extends JpaRepository<ProjectLogQueryDetailDO,Integer>, JpaSpecificationExecutor<ProjectLogQueryDetailDO> {
}
