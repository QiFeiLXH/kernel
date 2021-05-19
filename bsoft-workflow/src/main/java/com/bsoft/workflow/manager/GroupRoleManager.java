package com.bsoft.workflow.manager;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.condition.GroupRoleQueryCnd;
import com.bsoft.workflow.entity.primary.GroupRoleDO;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
public interface GroupRoleManager {
    /**
     * 获取流程组角色列表
     * @param queryCnd 查询参数
     * @return
     */
    Result<GroupRoleDO> getGroupRoleList(GroupRoleQueryCnd queryCnd);

    /**
     * 获取流程组角色
     * @param id 组角色ID
     * @return
     */
    GroupRoleDO getGroupRole(Integer id);

    /**
     * 保存流程组角色信息
     * @param saveDO 组角色信息
     */
    void saveGroupRole(GroupRoleDO saveDO);

    /**
     * 删除流程组角色
     * @param id 组角色ID
     */
    void deleteGroupRole(Integer id);
}
