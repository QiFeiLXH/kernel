package com.bsoft.auth.manager;

import com.bsoft.auth.entity.primary.SalesPermissionDO;
import com.bsoft.auth.entity.primary.SalesPersonPermissionDO;

import java.util.List;
import java.util.Map;

public interface SalesPermissionManager {
    public List<SalesPermissionDO> getSalesDynamicPermission(String personId);

    public Map<String,SalesPersonPermissionDO> getSalesDynamicPermission();

    List<String> getUserDeptPermission(String personId);
}
