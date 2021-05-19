package com.bsoft.attendance.dao.primary;

import com.bsoft.attendance.entity.primary.WorkLogViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkLogViewDao extends JpaRepository<WorkLogViewDO,Integer>, JpaSpecificationExecutor<WorkLogViewDO> {
    public List<WorkLogViewDO> findByAttendanceId(Integer attendanceId);
    public List<WorkLogViewDO> findByAttendanceIdAndIdNotIn(Integer attendanceId,List<Integer> workLogId);
}
