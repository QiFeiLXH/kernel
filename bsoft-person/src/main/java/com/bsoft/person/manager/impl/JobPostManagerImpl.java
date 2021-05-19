package com.bsoft.person.manager.impl;

import com.bsoft.dept.manager.DeptManager;
import com.bsoft.person.manager.JobPostManager;
import com.bsoft.auth.manager.RoleMaintainManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobPostManagerImpl implements JobPostManager {
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private RoleMaintainManager roleMaintainManager;
    @Override
    public Boolean isLeader(String personId) {
        return deptManager.isLeader(personId);
    }

    @Override
    public Boolean isFirstManager(String personId) {
        return deptManager.isFirstManager(personId);
    }

    @Override
    public Boolean isSecondManager(String personId) {
        return deptManager.isDepManager(personId);
    }

    @Override
    public Boolean isHr(String personId) {
        return deptManager.isHr(personId);
    }

    @Override
    public Boolean isRankManager(String personId) {
        List<String> depts = roleMaintainManager.getManagerDept(personId,9);
        return depts.isEmpty() ? false : true;
    }
}
