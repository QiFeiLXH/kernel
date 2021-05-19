package com.bsoft.clue.service.impl;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.clue.dto.TrackLogLookDTO;
import com.bsoft.clue.entity.primary.TrackLogLookDO;
import com.bsoft.clue.manager.TrackLogManager;
import com.bsoft.clue.service.TrackLogService;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class TrackLogServiceImpl implements TrackLogService {
    private static final Logger logger = LoggerFactory.getLogger(TrackLogServiceImpl.class);
    @Autowired
    private TrackLogManager trackLogManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private AttendanceManager attendanceManager;

    @Override
    public List<TrackLogLookDTO> getTodayTrackLog(String personId,Integer clueId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Date today = serverDateManager.getServerDate();
        List<TrackLogLookDO> logs = trackLogManager.getTrackLog(personId,today,clueId);
        long times = timeConsumer.end();
        logger.info("获取工号:{}-线索id为{}的今日跟踪日志耗时:{}",new Object[]{personId,clueId,times});
        return generator.convert(logs, TrackLogLookDTO.class);
    }

    @Override
    public List<TrackLogLookDTO> getTrackLog(String personId, Date attendacneDate,Integer clueId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TrackLogLookDO> logs = trackLogManager.getTrackLog(personId,attendacneDate,clueId);
        long times = timeConsumer.end();
        logger.info("获取工号:{}-线索id为{}-日期:{}的跟踪日志耗时:{}",new Object[]{personId,clueId,attendacneDate,times});
        return generator.convert(logs, TrackLogLookDTO.class);
    }

    @Override
    public TrackLogLookDTO saveTrackLog(TrackLogLookDTO trackLog) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TrackLogLookDO trackLogLookDO = generator.convert(trackLog,TrackLogLookDO.class);
        if(trackLogLookDO.getWorkLogId() == null){
            Integer workLogId = keyGenerator.increaseWorkLog();
            trackLogLookDO.setWorkLogId(workLogId);
        }
        if(trackLogLookDO.getTrackId() == null){
            Integer trackId = keyGenerator.increaseTrackLog();
            trackLogLookDO.setTrackId(trackId);
        }
        String personId = trackLog.getPersonId();
        AttendanceDO attendance = attendanceManager.getAttendance(personId);
        trackLogLookDO = trackLogManager.saveTrackLog(trackLogLookDO,attendance);
        long times = timeConsumer.end();
        logger.info("保存工号:{}的跟踪日志耗时:{}",personId,times);
        return generator.convert(trackLogLookDO, TrackLogLookDTO.class);
    }

    @Override
    public Map<Integer, Integer> getSignChance() {
        return trackLogManager.getSignChance();
    }
}
