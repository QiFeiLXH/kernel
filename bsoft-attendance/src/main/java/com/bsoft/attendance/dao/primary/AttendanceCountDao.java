package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.AttendanceCountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/20 19:01
 * @Description:
 */
@Repository
public interface AttendanceCountDao extends JpaRepository<AttendanceCountDO,String>, JpaSpecificationExecutor<AttendanceCountDO> {

    @Procedure(procedureName = "pd_ker_attendance_statis")
    public void pd_ker_attendance_statis(Date startDate,Date endDate,String personId,String dept,String inputContent);

    @Procedure(procedureName = "pd_ker_attendance_statiscommit")
    public void pd_ker_attendance_statiscommit(Date startDate,Date endDate,String personId,String dept,String inputContent);
}
