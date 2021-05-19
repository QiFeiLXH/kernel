package com.bsoft.work.manager.impl;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyDO;
import com.bsoft.work.manager.PolicyManager;
import com.bsoft.work.repository.primary.PolicyRepository;
import com.bsoft.work.repository.primary.PolicyReadPersonRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 17:32
 */
@Component
public class PolicyManagerImpl implements PolicyManager {
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private PolicyReadPersonRepository policyReadPersonRepository;


    @Override
    public PageInfo<PolicyDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd) {
        PageHelper.startPage(policyQueryCnd.getCurrent(),policyQueryCnd.getPageSize());
        List<PolicyDO> byQueryCnd = policyRepository.findByQueryCnd(policyQueryCnd);
        return new PageInfo<>(byQueryCnd);
    }

    @Override
    public List<PolicyDO> selectReadByQueryCnd(PolicyQueryCnd policyQueryCnd) {

        return null;
    }

    @Override
    public Integer countPersonalNoRead(String personId) {
        return policyReadPersonRepository.countPersonalNoRead(personId);
    }
}
