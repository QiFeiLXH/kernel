package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogNeedAuditDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectLogNeedAuditDao extends JpaRepository<ProjectLogNeedAuditDO,Integer>, JpaSpecificationExecutor<ProjectLogNeedAuditDO> {
    Page<ProjectLogNeedAuditDO> findByAuditTypeIn(Pageable pageable, List<Integer> auditTypeList);
}
