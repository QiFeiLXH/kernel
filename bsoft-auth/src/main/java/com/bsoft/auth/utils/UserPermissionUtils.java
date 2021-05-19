package com.bsoft.auth.utils;

import com.bsoft.auth.entity.primary.UserPermissionDO;

public class UserPermissionUtils {
    public static UserPermissionDO newDeptPermission(String personId,String deptId){
        UserPermissionDO userPermission = new UserPermissionDO();
        userPermission.setFlag(5);
        userPermission.setType(13);
        userPermission.setPersonId(personId);
        userPermission.setValue(deptId);
        return userPermission;
    }
}
