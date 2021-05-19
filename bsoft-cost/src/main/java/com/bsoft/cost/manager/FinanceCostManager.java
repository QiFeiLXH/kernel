package com.bsoft.cost.manager;

import com.bsoft.cost.condition.FinanceCostQueryCnd;
import com.bsoft.cost.entity.primary.FinanceCostViewDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-26 9:11
 * @Version 1.0
 * @Description
 */
public interface FinanceCostManager {
    PageInfo<FinanceCostViewDO> getFinanceCostList(FinanceCostQueryCnd queryCnd);

    List<FinanceCostViewDO> getFinanceCostDownload(FinanceCostQueryCnd queryCnd);
}
