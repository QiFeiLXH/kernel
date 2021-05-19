package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.ProjectLogAuditDO;
import com.bsoft.attendance.entity.primary.ProjectLogDO;
import com.bsoft.attendance.entity.primary.ProjectLogViewDO;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectLogViewDao extends JpaRepository<ProjectLogViewDO,Integer>, JpaSpecificationExecutor<ProjectLogViewDO> {
    List<ProjectLogViewDO> findBySubmitterAndAttendanceDate(String personId,Date attendanceDate);
}
