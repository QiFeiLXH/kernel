package com.bsoft.sales.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.sales.condition.SalesCommisQueryCnd;
import com.bsoft.sales.dto.SalesCommisImportDTO;
import com.bsoft.sales.entity.primary.SalesCommisImportDO;
import com.bsoft.sales.entity.primary.SalesCommisViewDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/10 13:49
 * @Description:
 */
public interface SalesCommisManager {
    PageInfo<SalesCommisViewDO> getSalesCommis(SalesCommisQueryCnd cnd);

    void deleteSalesCommis(List<Integer> ids);

    void aduitSalesCommis(List<Integer> ids, String personId);

    ImportResultDO importSalesCommis(List<SalesCommisImportDO> list, String personId);

    List<SalesCommisImportDO> getImportError(String personId);
}
