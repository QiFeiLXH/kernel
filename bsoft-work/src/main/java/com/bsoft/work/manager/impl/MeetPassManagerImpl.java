package com.bsoft.work.manager.impl;

import com.bsoft.exception.ServiceException;
import com.bsoft.work.dao.primary.MeetPassDao;
import com.bsoft.work.entity.primary.MeetPassDO;
import com.bsoft.work.manager.MeetPassManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeetPassManagerImpl implements MeetPassManager {
    @Autowired
    private MeetPassDao meetPassDao;

    @Override
    public MeetPassDO getMeetPassWithOpenId(String openId) {
        List<MeetPassDO> list =  meetPassDao.findByOpenId(openId);
        if(list.isEmpty()){
            throw new ServiceException("该用户无会议");
        }
        return list.get(0);
    }
}
