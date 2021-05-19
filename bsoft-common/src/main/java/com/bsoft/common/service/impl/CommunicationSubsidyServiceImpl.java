package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dto.CommunicationSubsidyDTO;
import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import com.bsoft.common.manager.CommunicationSubsidyManager;
import com.bsoft.common.service.CommunicationSubsidyService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:22
 * @Description:
 */

@Service
public class CommunicationSubsidyServiceImpl implements CommunicationSubsidyService {

    @Autowired
    private CommunicationSubsidyManager communicationSubsidyManager;

    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public List<CommunicationSubsidyDTO> getCommunicationSubsidy() {
        List<CommunicationSubsidyDO> list = communicationSubsidyManager.getCommunicationSubsidy();
        return generatorUtil.convert(list,CommunicationSubsidyDTO.class);
    }
}
