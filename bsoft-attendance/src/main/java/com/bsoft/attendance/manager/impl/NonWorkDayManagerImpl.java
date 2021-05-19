package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.dao.primary.NonWorkDayDao;
import com.bsoft.attendance.manager.NonWorkDayManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NonWorkDayManagerImpl implements NonWorkDayManager {
    @Autowired
    private NonWorkDayDao nonWorkDayDao;
    @Override
    public Boolean isWorkDay(Date attendanceDate) {
        return !nonWorkDayDao.existsByAttendanceDate(attendanceDate);
    }
}
