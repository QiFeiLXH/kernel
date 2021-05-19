package com.bsoft.clue.manager;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import com.bsoft.clue.entity.primary.TrackLogLookDO;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TrackLogManager {
    public List<TrackLogLookDO> getTrackLog(String personId, Date attendanceDate,Integer clueId);

    public TrackLogLookDO saveTrackLog(TrackLogLookDO trackLog, AttendanceDO attendance);

    public Map<Integer,Integer> getSignChance();
}
