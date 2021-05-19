package com.bsoft.auth.manager.impl;

import com.bsoft.auth.dao.primary.SalesPermissionDao;
import com.bsoft.auth.entity.primary.SalesPermissionDO;
import com.bsoft.auth.entity.primary.SalesPersonPermissionDO;
import com.bsoft.auth.manager.SalesPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SalesPermissionManagerImpl implements SalesPermissionManager {
    @Autowired
    private SalesPermissionDao salesPermissionDao;

    @Override
    public List<SalesPermissionDO> getSalesDynamicPermission(String personId) {
        return salesPermissionDao.findByPersonIdAndFlagAndType(personId,9,13);
    }

    @Override
    public Map<String,SalesPersonPermissionDO> getSalesDynamicPermission() {
        List<SalesPermissionDO> deptPermission = salesPermissionDao.findByFlagAndType(9,13);
        List<SalesPermissionDO> groupPermission = salesPermissionDao.findByFlagAndType(9,25);
        Map<String, SalesPersonPermissionDO> userPermission = new HashMap<>();
        for(SalesPermissionDO permission : deptPermission){
            String personId = permission.getPersonId();
            String value =  permission.getValue();
            if(userPermission.get(personId) == null){
                Set<String> permissions = new HashSet<>();
                SalesPersonPermissionDO permissionDO = new SalesPersonPermissionDO();
                permissionDO.setDeptPermission(permissions);
                userPermission.put(personId,permissionDO);
            }else{
                Set<String> permissions = userPermission.get(personId).getDeptPermission();
                permissions.add(value);
            }
        }
        for(SalesPermissionDO permission : groupPermission){
            String personId = permission.getPersonId();
            String value =  permission.getValue();
            if(userPermission.get(personId) == null){
                Set<String> permissions = new HashSet<>();
                SalesPersonPermissionDO permissionDO = new SalesPersonPermissionDO();
                permissionDO.setGroupPermission(permissions);
                userPermission.put(personId,permissionDO);
            }else{
                Set<String> permissions = userPermission.get(personId).getGroupPermission();
                if (permissions != null) {
                    permissions.add(value);
                } else {
                    permissions = new HashSet<>();
                    SalesPersonPermissionDO permissionDO = new SalesPersonPermissionDO();
                    permissionDO.setGroupPermission(permissions);
                    userPermission.put(personId, permissionDO);
                }
            }
        }
        return userPermission;
    }

    @Override
    public List<String> getUserDeptPermission(String personId) {
        List<SalesPermissionDO> permissionDOS = salesPermissionDao.findByPersonIdAndFlagAndType(personId, 5, 13);
        return permissionDOS.stream().map(SalesPermissionDO::getValue).collect(Collectors.toList());
    }
}
