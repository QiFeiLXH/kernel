package com.bsoft.clue.manager.impl;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import com.bsoft.attendance.entity.primary.WorkLogDO;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.clue.dao.primary.TrackLogDao;
import com.bsoft.clue.dao.primary.TrackLogLookDao;
import com.bsoft.clue.entity.primary.ClueDO;
import com.bsoft.clue.entity.primary.TrackLogDO;
import com.bsoft.clue.entity.primary.TrackLogLookDO;
import com.bsoft.clue.manager.ClueManager;
import com.bsoft.clue.manager.TrackLogManager;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TrackLogManagerImpl implements TrackLogManager {
    @Autowired
    private TrackLogLookDao trackLogLookDao;
    @Autowired
    private TrackLogDao trackLogDao;
    @Autowired
    private IGenerator generator;
    @Autowired
    private AttendanceManager attendanceManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private SystemDicManager systemDicManager;
    @Autowired
    private ClueManager clueManager;

    @Override
    public List<TrackLogLookDO> getTrackLog(String personId, Date attendanceDate,Integer clueId) {
        return trackLogLookDao.findByPersonIdAndAttendanceDateAndClueId(personId,attendanceDate,clueId);
    }

    @Override
    @Transactional
    public TrackLogLookDO saveTrackLog(TrackLogLookDO trackLog,AttendanceDO attendance) {
        java.util.Date now = serverDateManager.getServerDateTime();
        Date today = serverDateManager.getServerDate();
        TrackLogDO trackLogDO = generator.convert(trackLog,TrackLogDO.class);
        trackLogDO.setSubmitDate(now);
        if(trackLogDO.getSoftware() == null){
            trackLogDO.setSoftware(0D);
        }
        if(trackLogDO.getHardware() == null){
            trackLogDO.setHardware(0D);
        }
        if(trackLogDO.getSysSoftware() == null){
            trackLogDO.setSysSoftware(0D);
        }

        if(trackLogDO.getFirstAmount() == null){
            trackLogDO.setFirstAmount(0D);
        }

        trackLogDO.setTrackDate(trackLog.getAttendanceDate());
        trackLogDO.setTrackDate(today);
        trackLogDO.setTrackStartDate(now);
        trackLogDO.setSubmitter(trackLog.getPersonId());
        trackLogDO.setWorkLogId(trackLog.getWorkLogId());
        trackLogDO.setSignDate(new Date(trackLog.getSignDate().getTime()));
        trackLogDO = trackLogDao.save(trackLogDO);

        Integer clueId = trackLog.getClueId();
        ClueDO clue= clueManager.getClue(clueId);
        clue.setSoftware(trackLog.getSoftware());
        clue.setHardware(trackLog.getHardware());
        clue.setSysSoftware(trackLog.getSysSoftware());
        clue.setSignChance(trackLog.getSignChance());
        clue.setFirstAmount(trackLog.getFirstAmount());
        clue.setStage(trackLog.getStage());
        clue.setSignDate(trackLog.getSignDate());
        clue.setTrackDate(now);
        clue.setTrackTime(now);
        clue.setContent(trackLog.getContent());
        clue.setClueNature(trackLog.getClueNature());
        clue = clueManager.saveClue(clue);


        Integer trackId = trackLogDO.getTrackId();
        trackLog.setTrackId(trackId);
        WorkLogDO workLogDO = new WorkLogDO();
        workLogDO.setSubmitDate(now);
        workLogDO.setId(trackLog.getWorkLogId());
        workLogDO.setWorkLog(getWorkLog(trackLog));
        workLogDO.setProjectId(trackLog.getProjectId());
        workLogDO.setWorkLoad(trackLog.getWorkLoad());
        workLogDO.setProjectType(trackLog.getProjectType());
        workLogDO.setProjectDept(trackLog.getProjectDept());
        workLogDO.setFlag(trackLog.getFlag());
        workLogDO.setProjectName(trackLog.getProjectName());
        workLogDO.setSourceType(0);
        attendance.setStay(trackLog.getStay());
        attendance.setRentId(trackLog.getRentId());
        attendance.setFlag(trackLog.getFlag());
        attendanceManager.saveWorkLog(attendance,workLogDO);
        return trackLog;
    }

    @Override
    public Map<Integer, Integer> getSignChance() {
        List<SystemDicDO> dics = systemDicManager.getSystemDic(924);
        return dics.stream().collect(Collectors.toMap(SystemDicDO::getId,SystemDicDO::getXtsb,(key1,key2)->key1));
    }

    private String getWorkLog(TrackLogLookDO trackLog){
        StringBuilder workLog = new StringBuilder();
        workLog.append("客户名称：").append(trackLog.getCustomer()).append(";\r\n拜访时间：").append(DateUtils.dateToString(trackLog.getStartDate(),"HH:mm")).append("至").append(DateUtils.dateToString(trackLog.getEndDate(),"HH:mm")).append(";\r\n拜访人物：")
                .append(trackLog.getTarget()).append(";\r\n拜访地点：").append(trackLog.getAddress()).append(";\r\n洽谈内容：").append(trackLog.getContent());
        return workLog.toString();
    }
}
