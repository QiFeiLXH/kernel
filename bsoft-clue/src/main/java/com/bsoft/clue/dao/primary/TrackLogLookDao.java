package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.TrackLogLookDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TrackLogLookDao extends JpaRepository<TrackLogLookDO,Integer>, JpaSpecificationExecutor<TrackLogLookDO> {
    public List<TrackLogLookDO> findByPersonIdAndAttendanceDateAndClueId(String personId, Date attendanceDate,Integer clueId);

}
