package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LeaveDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveDao extends JpaRepository<LeaveDO, Integer>, JpaSpecificationExecutor<LeaveDO> {
//    List<LeaveDO> findAllByLeaveDateAndAuditFlag(Date leaveDate, Integer auditFlag);

    @Query("select a from LeaveDO a  where :now between a.startDate and a.endDate and a.auditFlag = :auditFlag")
    List<LeaveDO> findAllWithLeave(@Param("now")Date now, @Param("auditFlag")Integer auditFlag);
}

