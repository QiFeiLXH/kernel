package com.bsoft.work.manager.impl;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadPersonDO;
import com.bsoft.work.manager.PolicyReadPersonManager;

import com.bsoft.work.repository.primary.PolicyReadPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:38
 */
@Component
public class PolicyReadPersonManagerImpl implements PolicyReadPersonManager {

    @Autowired
    private PolicyReadPersonRepository policyReadPersonDao;

    @Override
    public List<PolicyReadPersonDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd) {
        return policyReadPersonDao.selectByQueryCnd(policyQueryCnd);
    }
}
