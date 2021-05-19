package com.bsoft.auth.manager;

import com.bsoft.auth.entity.primary.DeptRoleDO;
import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.entity.primary.RoleNameDO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
public interface RoleMaintainManager {

    RoleNameDO saveRole(RoleNameDO roleDO);

    List<RoleNameDO> saveRoles(List<RoleNameDO> roleDO);

    List<RoleNameDO> getRoles(Integer status, String content);

    DeptRoleDO saveDeptRole(DeptRoleDO deptRoleDO);

    List<RoleMaintainBaseDO> getRoleMaintainBase(String dept);

    void saveDeptRoles(List<DeptRoleDO> deptRoles);

    List<Map<String, Object>> getDeptRoleDetails();

    DeptRoleDO getDeptRole(String dept,Integer roleId);

    List<String> getManagerDept(String personId,Integer roleId);

    List<DeptRoleDO> findDeptRoles(String dept,Integer roleId);

}
