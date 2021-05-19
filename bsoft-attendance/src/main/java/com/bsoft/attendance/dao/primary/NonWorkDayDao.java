package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.NonWorkDayDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NonWorkDayDao extends JpaRepository<NonWorkDayDO,Integer>, JpaSpecificationExecutor<NonWorkDayDO> {
    public Boolean existsByAttendanceDate(Date attendanceDate);
}
