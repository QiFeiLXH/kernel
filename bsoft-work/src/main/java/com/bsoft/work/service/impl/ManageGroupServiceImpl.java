package com.bsoft.work.service.impl;


import com.bsoft.common.dozer.IGenerator;
import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;
import com.bsoft.work.entity.primary.ManagerGroupDO;
import com.bsoft.work.manager.ManagerGroupManager;
import com.bsoft.work.service.ManageGroupService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author Huang GH
 * @date 2021/5/10 11:09
 */
@Service
public class ManageGroupServiceImpl implements ManageGroupService {

    @Autowired
    private ManagerGroupManager managerGroupManager;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public List<ManagerGroupDTO> findGroupByType(PolicyQueryCndDTO cnd) {
        PolicyQueryCnd convert = iGenerator.convert(cnd, PolicyQueryCnd.class);
        return managerGroupManager.findByType(convert);
    }

    @Override
    public List<ManagerGroupDTO> findList(String councilName, Integer isCancel) {
        List<ManagerGroupDO> list = managerGroupManager.findList(councilName, isCancel);
        return iGenerator.convert(list, ManagerGroupDTO.class);
    }

    @Override
    public void cancelManagerGroup(Integer councilId, Integer isCancel) {
        managerGroupManager.cancelManagerGroup(councilId,isCancel);
    }

    @Override
    public void saveManagerGroups(List<ManagerGroupDTO> managerGroupList) {
        managerGroupManager.saveManagerGroups(iGenerator.convert(managerGroupList,ManagerGroupDO.class));
    }
}
