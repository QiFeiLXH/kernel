package com.bsoft.person.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.schoolMessage.ResultJavaEntity;
import com.bsoft.common.schoolMessage.manager.SchoolSyncUserJavaManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.person.entity.primary.PersonQuitSyncDO;
import com.bsoft.person.manager.PersonQuitManager;
import com.bsoft.person.repository.primary.CloudschoolUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class PersonQuitManagerImpl implements PersonQuitManager {

    private static final Logger logger = LoggerFactory.getLogger(CloudschoolSynManagerImpl.class);


    @Autowired
    private ServerDateManager serverDateManager;

    @Autowired
    private CloudschoolUserRepository cloudschoolUserRepository;

    @Override
    public List<PersonQuitSyncDO> SyncQuitPersonnel()  {
        Date now = serverDateManager.getServerDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE,-1);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        Date endDate = null;
        try {
            endDate = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<PersonQuitSyncDO> quitPersons = cloudschoolUserRepository.getQuitPersons(endDate);
        return quitPersons;
    }
}
