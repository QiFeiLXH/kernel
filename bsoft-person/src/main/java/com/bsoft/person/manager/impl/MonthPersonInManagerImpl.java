package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.MonthPersonInfoDao;
import com.bsoft.person.manager.MonthPersonInManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:30
 * @Description:
 */
@Component
public class MonthPersonInManagerImpl implements MonthPersonInManager {
    @Autowired
    private MonthPersonInfoDao monthPersonInfoDao;
    @Override
    public void updateLastPersonInfo(String dept, Integer deptType, Integer jobCategory, String post, String personId, Date startdate) {
        monthPersonInfoDao.updateLastPersonInfo(dept,deptType,jobCategory,post,personId,startdate);
    }
}
