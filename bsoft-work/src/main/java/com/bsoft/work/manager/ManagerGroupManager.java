package com.bsoft.work.manager;

import com.bsoft.work.condition.PolicyQueryCnd;
import com.bsoft.work.dto.ManagerGroupDTO;
import com.bsoft.work.entity.primary.ManagerGroupDO;


import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 10:56
 */

public interface ManagerGroupManager {

    /**
     * @param policyQueryCnd
     * @return
     */
    List<ManagerGroupDTO> findByType(PolicyQueryCnd policyQueryCnd);
    /**
     * @param councilName:组名称
     * @param isCancel:是否注销
     * @return
     */
    List<ManagerGroupDO> findList(String councilName, Integer isCancel);

    /**
     *
     * @param councilId:组id
     * @param isCancel:注销标志
     */
    void cancelManagerGroup(Integer councilId,Integer isCancel);

    /**
     *
     * @param managerGroupList:要保存的组列表
     */
    void saveManagerGroups(List<ManagerGroupDO> managerGroupList);
}
