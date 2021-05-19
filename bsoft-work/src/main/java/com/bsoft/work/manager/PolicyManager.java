package com.bsoft.work.manager;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.entity.primary.PolicyDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/11 17:30
 */
public interface PolicyManager {
    PageInfo<PolicyDO> selectByQueryCnd(PolicyQueryCnd policyQueryCnd);

    List<PolicyDO> selectReadByQueryCnd(PolicyQueryCnd policyQueryCnd);

    Integer countPersonalNoRead(String personId);
}
