package com.bsoft.cost.manager;

import com.bsoft.cost.condition.SubsidyStandardQueryCnd;
import com.bsoft.cost.entity.primary.SubsidyStandardDO;
import com.bsoft.cost.entity.primary.SubsidyStandardViewDO;
import org.springframework.data.domain.Page;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:27
 * @Description: 特殊津贴标准
 */
public interface SubsidyStandardManager {
    /**
     * 更新特殊津贴
     * @param standardDO
     */
    void saveSubsidyStandard(SubsidyStandardDO standardDO);

    /**
     * 分页查询特殊津贴标准
     * @return
     */
    Page<SubsidyStandardViewDO> findSubsidyStandardList(SubsidyStandardQueryCnd cnd);
}
