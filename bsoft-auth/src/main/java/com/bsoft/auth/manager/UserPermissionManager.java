package com.bsoft.auth.manager;

import java.util.List;

public interface UserPermissionManager {
    List<String> getUserDeptPermission(String personId);

    List<String> getModuleRelationPermission(String personId);

    void saveDeptAuthority(String personId, List<String> needSaves, List<String> needDeletes);
}
