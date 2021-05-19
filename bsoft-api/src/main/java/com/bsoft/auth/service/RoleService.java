package com.bsoft.auth.service;

import com.bsoft.auth.dto.RoleDTO;
import com.bsoft.auth.dto.RolePersonDTO;
import com.bsoft.auth.dto.RolePersonViewDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getRoleList();
    List<RoleDTO> saveRole(RoleDTO roleDTO);
    List<RolePersonDTO> getRolePersonList(Integer roleId);
    List<RolePersonViewDTO> getRolePerson(Integer roleId);
    boolean saveRolePerson(Integer roleId,List<String> add,List<String> remove);
    boolean deleteRole(Integer roleId);
    List<RoleDTO> saveRoles(List<RoleDTO> roleDTOS);
    RolePersonDTO saveRolePerson(RolePersonDTO rolePersonDTO);
    void deleteRolePerson(String personId);
    List<RolePersonViewDTO> getRolePersonByPersonId(String personId);
}
