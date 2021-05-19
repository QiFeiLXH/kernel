package com.bsoft.work.manager;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadPersonDO;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:37
 */
public interface PolicyReadPersonManager {
    List<PolicyReadPersonDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd);
}
