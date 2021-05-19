package com.bsoft.auth.manager;

import java.util.List;

public interface ProjectPermissionManager {
    public List<String> getProjectAreaPermission(String personId);
    List<String> getContractSalesAreaPermission(String personId);

    void saveProjectAuthority(String personId, List<String> needSaves, List<String> needDeletes);
}
