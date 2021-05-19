package com.bsoft.workflow.service;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.dto.GroupRoleDTO;
import com.bsoft.workflow.dto.GroupRoleQueryCndDTO;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
public interface GroupRoleService {
    /**
     * 获取流程组角色列表
     * @param queryCndDTO 查询参数
     * @return
     */
    Result<GroupRoleDTO> getGroupRoleList(String userId, GroupRoleQueryCndDTO queryCndDTO);

    /**
     * 保存流程组角色信息
     * @param saveDTO 组角色信息
     */
    void saveGroupRole(String userId, GroupRoleDTO saveDTO);

    /**
     * 删除流程组角色信息
     * @param id 组角色ID
     */
    void deleteGroupRole(String userId, Integer id);
}
