package com.bsoft.account.manager;

import com.bsoft.account.entity.primary.EmpAccountDO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-05-14 9:59
 * @Version 1.0
 * @Description
 */
public interface EmpAccountManager {
    void frozenAccount(String userId); //冻结账户

    void thawAccount(String userId); //解冻账户

    void saveEmpAccount(List<EmpAccountDO> empAccountDOS);
}
