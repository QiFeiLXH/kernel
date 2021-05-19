package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.dto.PolicyDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;
import com.bsoft.work.entity.primary.PolicyDO;

import com.bsoft.work.manager.PolicyManager;
import com.bsoft.work.service.PolicyService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 17:26
 */
@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyManager policyManager;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public Result<PolicyDTO> selectByQueryCnd(PolicyQueryCndDTO policyQueryCndDto) {
        PolicyQueryCnd convert = iGenerator.convert(policyQueryCndDto, PolicyQueryCnd.class);
        PageInfo<PolicyDO> pageInfo = policyManager.selectByQueryCnd(convert);
        return ResultUtils.parseResult(pageInfo,PolicyDTO.class);
    }

    @Override
    public List<PolicyDTO> selectReadByQueryCnd(PolicyQueryCndDTO policyQueryCndDto) {
        PolicyQueryCnd convert = iGenerator.convert(policyQueryCndDto, PolicyQueryCnd.class);
        List<PolicyDO> policyDOS = policyManager.selectReadByQueryCnd(convert);
        return iGenerator.convert(policyDOS, PolicyDTO.class);
    }

    @Override
    public Integer countPersonalNoRead(String personId) {
        return policyManager.countPersonalNoRead(personId);
    }
}
