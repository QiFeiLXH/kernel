package com.bsoft.work.manager.impl;

import com.bsoft.work.dao.primary.ManagerDao;
import com.bsoft.work.entity.primary.ManagerDO;
import com.bsoft.work.manager.ManagerManager;
import com.bsoft.work.repository.primary.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author ding dj
 * @Date 2021/5/14 9:31
 * @Description
 */
@Component
public class ManagerManagerImpl implements ManagerManager {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerDao managerDao;

    @Override
    public List<ManagerDO> findList(String personName, Integer councilId) {
        return managerRepository.findList(personName,councilId);
    }

    @Override
    public void deleteManager(Integer id) {
        managerDao.deleteById(id);
    }

    @Override
    public void saveManager(List<ManagerDO> managerList) {
        managerDao.saveAll(managerList);
    }
}
