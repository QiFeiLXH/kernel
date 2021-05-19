package com.bsoft.auth.service;

import com.bsoft.auth.dto.RoleMaintainBaseDTO;
import com.bsoft.auth.dto.RoleNameDTO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
public interface RoleMaintainService {

    /**
     * 保存角色名称
     * @param roleNameDTO
     * @return
     */
    RoleNameDTO saveRole(RoleNameDTO roleNameDTO);

    /**
     * 保存角色名称
     * @param list
     * @return
     */
    List<RoleNameDTO> saveRoles(List<RoleNameDTO> list);

    /**
     * 获取角色名称列表
     * @param status 状态 0 启用 1 禁用  -1 全部
     * @param content 名称
     * @return
     */
    List<RoleNameDTO> getRoles(Integer status, String content);

    /**
     * 获取部门角色名称
     * @param dept 部门编号
     * @return
     */
    List<RoleMaintainBaseDTO> getRoleMaintainBase(String dept);

    /**
     * 保存部门角色名称
     * @param list 部门角色名称列表
     */
    void saveDeptRoles(List<RoleMaintainBaseDTO> list);

    /**
     * 获取全部部门角色名称及对应人员
     * @return
     */
    List<Map<String,Object>> getDeptRoleDetails();

    /**
     * 获取对应部门和roleid对应角色人员
     * @return
     */
     String getDeptRole(String dept,Integer roleId);

    /**
     * 获取管辖的部门
     * @return
     */
    List<String> getManagerDept(String personId,Integer roleId);
}
