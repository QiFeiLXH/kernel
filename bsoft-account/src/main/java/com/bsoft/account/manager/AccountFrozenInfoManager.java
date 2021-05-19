package com.bsoft.account.manager;

import com.bsoft.account.entity.primary.AccountFrozenInfoDO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-24 14:51
 * @Version 1.0
 * @Description
 */
public interface AccountFrozenInfoManager {
    void saveAccountFrozenInfos(List<AccountFrozenInfoDO> accountFrozenInfoDOList);
}
