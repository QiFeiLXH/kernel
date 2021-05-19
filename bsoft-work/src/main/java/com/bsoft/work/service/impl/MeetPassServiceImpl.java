package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.work.dto.MeetPassDTO;
import com.bsoft.work.entity.primary.MeetPassDO;
import com.bsoft.work.manager.MeetPassManager;
import com.bsoft.work.service.MeetPassService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MeetPassServiceImpl implements MeetPassService {
    @Autowired
    private MeetPassManager meetPassManager;
    @Autowired
    private IGenerator generator;
    @Override
    public MeetPassDTO getMeetPassWithOpenId(String openId) {
        MeetPassDO meetPassDO = meetPassManager.getMeetPassWithOpenId(openId);
        return generator.convert(meetPassDO,MeetPassDTO.class);
    }
}
