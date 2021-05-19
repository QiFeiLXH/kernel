package com.bsoft.auth.entity.primary;

import java.util.Set;

/**
 * @Auther: hy
 * @Date: 2020/7/3
 * @Description:
 */
public class SalesPersonPermissionDO {

    private Set<String> deptPermission;
    private Set<String> groupPermission;

    public Set<String> getDeptPermission() {
        return deptPermission;
    }

    public void setDeptPermission(Set<String> deptPermission) {
        this.deptPermission = deptPermission;
    }

    public Set<String> getGroupPermission() {
        return groupPermission;
    }

    public void setGroupPermission(Set<String> groupPermission) {
        this.groupPermission = groupPermission;
    }
}
