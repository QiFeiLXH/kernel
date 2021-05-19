package com.bsoft.work.manager.impl;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadStatusDO;
import com.bsoft.work.manager.PolicyReadStatusManager;
import com.bsoft.work.repository.primary.PolicyReadStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:35
 */
@Component
public class PolicyReadStatusManagerImpl implements PolicyReadStatusManager {

    @Autowired
    private PolicyReadStatusRepository policyReadStatusDao;

    @Override
    public List<PolicyReadStatusDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd) {
        return policyReadStatusDao.selectByQueryCnd(policyQueryCnd);
    }
}
