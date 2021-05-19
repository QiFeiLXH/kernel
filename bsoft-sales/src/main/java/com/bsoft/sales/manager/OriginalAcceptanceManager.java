package com.bsoft.sales.manager;

import com.bsoft.sales.condition.OriginalAcceptanceQueryCnd;
import com.bsoft.sales.entity.primary.OriginalAcceptanceDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:47
 * @Description: 合同原件接收、归档Manager
 */
public interface OriginalAcceptanceManager {
    Page<OriginalAcceptanceDO> getOriginalAcceptance(OriginalAcceptanceQueryCnd cnd);

    void auditOriginalAcceptance(List<OriginalAcceptanceDO> words,String userId,Integer ststus);
}
