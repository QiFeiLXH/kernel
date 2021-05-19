package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.BillingInfoDO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:31
 * @Description: 开票信息
 */
public interface BillingInfoManager {
    List<BillingInfoDO> findAllNeedUpdateInvoice();

    void saveBillingInvoice();
}
