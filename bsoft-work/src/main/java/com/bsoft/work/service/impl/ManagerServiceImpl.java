package com.bsoft.work.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.work.dto.ManagerDTO;
import com.bsoft.work.entity.primary.ManagerDO;
import com.bsoft.work.manager.ManagerManager;
import com.bsoft.work.service.ManagerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author ding dj
 * @Date 2021/5/14 9:43
 * @Description
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private IGenerator iGenerator;

    @Autowired
    private ManagerManager managerManager;

    @Override
    public List<ManagerDTO> findList(String personName, Integer councilId) {
        List<ManagerDO> list = managerManager.findList(personName, councilId);
        return iGenerator.convert(list,ManagerDTO.class);
    }

    @Override
    public void deleteManager(Integer id) {
        managerManager.deleteManager(id);
    }

    @Override
    public void saveManager(List<ManagerDTO> managerList) {
        managerManager.saveManager(iGenerator.convert(managerList,ManagerDO.class));
    }
}
