package com.bsoft.auth.validator;

import com.bsoft.auth.entity.primary.SalesPersonPermissionDO;
import com.bsoft.auth.manager.SalesPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SalesDynamicValidator {
    @Autowired
    private SalesPermissionManager salesPermissionManager;

    public Boolean havePermission(String userId,String deptId){
        return false;
    }

    public Set<String> getHavePermissionUsers(String deptId,String groupId){
        Map<String,SalesPersonPermissionDO> userPermissions = getUserPermission();
        Set<String> havePermissionUsers = new HashSet<>();
        for(Map.Entry<String,SalesPersonPermissionDO> entry : userPermissions.entrySet()){
            String personId = entry.getKey();
            Set<String> deptPermissions = entry.getValue().getDeptPermission();
            Set<String> groupPermissions = entry.getValue().getGroupPermission();
            if(deptPermissions != null && deptPermissions.contains(deptId)){
                havePermissionUsers.add(personId);
            }
            if(groupPermissions != null && groupPermissions.contains(groupId)){
                havePermissionUsers.add(personId);
            }
        }
        return havePermissionUsers;
    }

    private Map<String,SalesPersonPermissionDO> getUserPermission(){
        return salesPermissionManager.getSalesDynamicPermission();
    }
}
