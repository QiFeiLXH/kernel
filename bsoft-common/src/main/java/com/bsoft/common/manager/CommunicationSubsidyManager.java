package com.bsoft.common.manager;

import com.bsoft.common.entity.primary.CommunicationSubsidyDO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:19
 * @Description:
 */
public interface CommunicationSubsidyManager {
    List<CommunicationSubsidyDO> getCommunicationSubsidy();

    CommunicationSubsidyDO getCommunicationSubsidy(Integer id);
}
