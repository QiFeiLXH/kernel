package com.bsoft.auth.manager;

import com.bsoft.auth.condition.AuthorityQueryCnd;
import com.bsoft.auth.entity.primary.*;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MenuAuthorityManager {
    List<Integer> getAuthMenuId (String userId,Integer system);
    List<Integer> getAuthMenuIdByRoleId (Integer roleId,Integer system);
    List<RoleMenuAuthDO> getMenuAuth(String userId, Integer system);
//    List<Map> getOfficeMenuAuth(String userId, Integer system);
    boolean saveOfficeMenuAuth(Integer roleId, List<Integer> menusId, List<Map> authInfo,Integer system);
    PageInfo<AuthorityPersonDO> getPermissionalPersonList(List<AuthorityQueryCnd> menuAuths, Integer pageNo, Integer pageSize);
    List<PersonRoleMenuDO> getMenuByPersonId(String personId, Integer system);
    boolean checkAllPermission(String personId, Integer menuId, Integer key);
    boolean checkPrivateMenuPermission(String personId, Integer menuId);
    boolean checkPrivateMenuPermission(String personId, String menuPrefix);
    List<RoleMenuDO> getMenuByRoleId (Integer roleId, Integer system);
    void deletePersonDeptByIds(List<Integer> ids);
    void savePersonDept(List<PersonDeptAuthDO> personDeptAuthDOS);
    List<AuthorityDO> getOfficeMenuAuthority(String userId, Integer system);
}
