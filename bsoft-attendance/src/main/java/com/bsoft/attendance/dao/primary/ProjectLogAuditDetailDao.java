package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogAuditDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectLogAuditDetailDao extends JpaRepository<ProjectLogAuditDetailDO,Integer>, JpaSpecificationExecutor<ProjectLogAuditDetailDO> {

    List<ProjectLogAuditDetailDO> findByAuditter(String auditter);

    Integer countByProWorkLogId(Integer projectLogId);
}
