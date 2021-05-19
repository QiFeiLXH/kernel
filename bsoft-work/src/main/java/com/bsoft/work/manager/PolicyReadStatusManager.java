package com.bsoft.work.manager;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyReadStatusDO;



import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 16:33
 */
public interface PolicyReadStatusManager {


    List<PolicyReadStatusDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd);
}
