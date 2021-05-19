package com.bsoft.attendance.manager;

import java.util.Date;

public interface NonWorkDayManager {
    public Boolean isWorkDay(Date attendanceDate);
}
