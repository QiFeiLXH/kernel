package com.bsoft.auth.manager.impl;

import com.bsoft.auth.dao.primary.UserPermissionDao;
import com.bsoft.auth.entity.primary.UserPermissionDO;
import com.bsoft.auth.manager.UserPermissionManager;
import com.bsoft.auth.utils.UserPermissionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 14:34
 * @Description
 */
@Component
public class UserPermissionManagerImpl implements UserPermissionManager {

    @Autowired
    private UserPermissionDao userPermissionDao;


    @Override
    public List<String> getUserDeptPermission(String personId) {
        List<UserPermissionDO> permissionDOS = userPermissionDao.findByPersonIdAndFlagAndType(personId, 5, 13);
        return permissionDOS.stream().map(UserPermissionDO::getValue).collect(Collectors.toList());
    }

    @Override
    public List<String> getModuleRelationPermission(String personId) {
        List<UserPermissionDO> permissionDOS = userPermissionDao.findByPersonIdAndFlagAndType(personId, 2, 27);
        return permissionDOS.stream().map(UserPermissionDO::getValue).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveDeptAuthority(String personId, List<String> needSaves, List<String> needDeletes) {
        List<UserPermissionDO> saveList = new ArrayList<>();
        List<UserPermissionDO> deleteList = new ArrayList<>();
        if (!needSaves.isEmpty()) {
            needSaves.forEach(deptId -> {
                UserPermissionDO permissionDO = UserPermissionUtils.newDeptPermission(personId,deptId);
                saveList.add(permissionDO);
            });
        }

        if (!needDeletes.isEmpty()) {
            needDeletes.forEach(deptId -> {
                UserPermissionDO permissionDO = UserPermissionUtils.newDeptPermission(personId,deptId);
                deleteList.add(permissionDO);
            });
        }

        userPermissionDao.saveAll(saveList);
        userPermissionDao.deleteInBatch(deleteList);
    }
}
