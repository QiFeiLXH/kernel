package com.bsoft.auth.manager.impl;

import com.bsoft.auth.dao.primary.ProjectPermissionDao;
import com.bsoft.auth.entity.primary.ProjectPermissionDO;
import com.bsoft.auth.manager.ProjectPermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectPermissionManagerImpl implements ProjectPermissionManager {
    @Autowired
    private ProjectPermissionDao projectPermissionDao;
    @Override
    public List<String> getProjectAreaPermission(String personId) {
        List<ProjectPermissionDO> result = projectPermissionDao.findByPersonIdAndFlagAndType(personId,1,6);
        return result.stream().map(ProjectPermissionDO::getValue).collect(Collectors.toList());
    }

    @Override
    public List<String> getContractSalesAreaPermission(String personId) {
        List<ProjectPermissionDO> result = projectPermissionDao.findByPersonIdAndFlagAndType(personId,2,1);
        return result.stream().map(ProjectPermissionDO::getValue).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveProjectAuthority(String personId, List<String> needSaves, List<String> needDeletes) {
        List<ProjectPermissionDO> saveList = new ArrayList<>();
        List<ProjectPermissionDO> deleteList = new ArrayList<>();
        if (!needSaves.isEmpty()) {
            needSaves.forEach(deptId -> {
                ProjectPermissionDO permissionDO = new ProjectPermissionDO();
                permissionDO.setPersonId(personId);
                permissionDO.setValue(deptId);
                permissionDO.setFlag(1);
                permissionDO.setType(6);
                saveList.add(permissionDO);
            });
        }

        if (!needDeletes.isEmpty()) {
            needDeletes.forEach(deptId -> {
                ProjectPermissionDO permissionDO = new ProjectPermissionDO();
                permissionDO.setPersonId(personId);
                permissionDO.setValue(deptId);
                permissionDO.setFlag(1);
                permissionDO.setType(6);
                deleteList.add(permissionDO);
            });
        }

        projectPermissionDao.saveAll(saveList);
        projectPermissionDao.deleteInBatch(deleteList);
    }
}
