package com.bsoft.work.service;

import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.dto.PolicyQueryCndDTO;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 11:06
 */
public interface ManageGroupService {

    List<ManagerGroupDTO> findGroupByType(PolicyQueryCndDTO cnd);

    List<ManagerGroupDTO> findList(String councilName,Integer isCancel);

    void cancelManagerGroup(Integer councilId,Integer isCancel);

    void saveManagerGroups(List<ManagerGroupDTO> managerGroupList);
}
