package com.bsoft.auth.manager;

import com.bsoft.auth.dto.RoleDTO;
import com.bsoft.auth.dto.RolePersonDTO;
import com.bsoft.auth.entity.primary.*;

import java.util.List;
import java.util.Map;

public interface RoleManager {
    List<RoleDTO> getRoleList();
    List<RoleDTO> saveRole(RoleDTO roleDTO);
    List<AuthorityDO> getMenuAuth(Integer system);
    List<Map> getMenuAuthWithRole(Integer system, Integer roleId);
    List<RoleMenuAuthDO> getMenuAuthDOByRole(Integer system, Integer roleId);
    List<PersonRoleMenuAuthDO> getPersonMenuAuthDOByPersonId(Integer system,String personId);
    List<RolePersonDTO> getRolePersonList(Integer roleId);
    List<RolePersonViewDO> getRolePerson(Integer roleId);
    boolean saveRolePerson(Integer roleId,List<String> add,List<String> remove);
    boolean deleteRole(Integer roleId);
    List<RoleDO> saveRoles(List<RoleDO> roleDTOS);
    RolePersonDO saveRolePerson(RolePersonDO rolePersonDO);
    void deleteRolePerson(String personId);
    List<PersonDeptAuthViewDO> getPersonDept(String personId,Integer system);
    List<RolePersonViewDO> getRolesPersonByPersonId(String personId);
    RolePersonDO getRolePerson(String personId);
}
