package com.bsoft.auth.manager.impl;

import com.bsoft.auth.condition.AuthorityQueryCnd;
import com.bsoft.auth.dao.primary.*;
import com.bsoft.auth.entity.primary.*;
import com.bsoft.auth.manager.MenuAuthorityManager;
import com.bsoft.auth.repository.primary.AuthorityRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MenuAuthorityManagerImpl implements MenuAuthorityManager {
    private final static Logger logger = LoggerFactory.getLogger(MenuAuthorityManagerImpl.class);

    @Autowired
    private MenuAuthorityDao menuAuthorityDao;
    @Autowired
    private RoleMenuAuthDao roleMenuAuthDao;
    @Autowired
    private AuthMenuDao authMenuDao;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private PersonRoleMenuDao personRoleMenuDao;
    @Autowired
    private PersonDeptAuthDao personDeptAuthDao;


    @Override
    public List<Integer> getAuthMenuId(String userId,Integer system){
        return menuAuthorityDao.getAuthMenu(userId,system);
    }

    @Override
    public List<Integer> getAuthMenuIdByRoleId(Integer roleId, Integer system) {
        return menuAuthorityDao.getAuthMenuByRoleId(roleId,system);
    }

    @Override
    public List<RoleMenuAuthDO> getMenuAuth(String userId, Integer system){
        return roleMenuAuthDao.getMenuAuth(userId,system);
    }

//    @Override
//    public List<Map> getOfficeMenuAuth(String userId, Integer system) {
//        List<Map> list = roleMenuAuthDao.getOfficeMenuAuth(userId,system);
//        return list;
//    }

    @Override
    @Transactional
    public boolean saveOfficeMenuAuth(Integer roleId, List<Integer> menusId, List<Map> authInfo,Integer system) {
        boolean status = false;
        List<AuthMenuDO> pubMenus = authMenuDao.findByPubFlagAndAndSystem(1,system);
        List<Integer> pubMenusIs = new ArrayList<>();
        for (AuthMenuDO authMenuDO:pubMenus){
            pubMenusIs.add(authMenuDO.getId());//公用菜单ID
        }
        menusId.removeAll(pubMenusIs);//非公用菜单ID
        menuAuthorityDao.deleteAllByRoleIdAndSystem(roleId,system);//删除角色、系统下的所有菜单权限
        roleMenuAuthDao.deleteAllByRoleIdAndSystem(roleId,system);//删除角色、系统下的所有菜单操作权限

        if (menusId.size()>0){
            List<RoleMenuDO> roleMenuDOS = new ArrayList<>();
            for (Integer integer:menusId){
                RoleMenuDO roleMenuDO = new RoleMenuDO();
                roleMenuDO.setRoleId(roleId);
                roleMenuDO.setMenuId(integer);
                roleMenuDO.setSystem(system);
                roleMenuDOS.add(roleMenuDO);
            }
            menuAuthorityDao.saveAll(roleMenuDOS);
        }

        if (authInfo.size()>0){
            List<RoleMenuAuthDO> roleMenuAuthDOS = new ArrayList<>();
            for (Map map:authInfo){
                Integer menuId = Integer.valueOf(map.get("menuId").toString());
                List<Integer> actionIds = (List<Integer>) map.get("actionList");
                for (Integer integer:actionIds){
                    RoleMenuAuthDO roleMenuAuthDO = new RoleMenuAuthDO();
                    roleMenuAuthDO.setRoleId(roleId);
                    roleMenuAuthDO.setMenuId(menuId);
                    roleMenuAuthDO.setAuthId(integer);
                    roleMenuAuthDO.setSystem(system);
                    roleMenuAuthDOS.add(roleMenuAuthDO);
                }
            }
            roleMenuAuthDao.saveAll(roleMenuAuthDOS);
        }
        status = true;
        return status;
    }

    @Override
    @Transactional
    public PageInfo<AuthorityPersonDO> getPermissionalPersonList(List<AuthorityQueryCnd> menuAuths, Integer pageNo, Integer pageSize) {
        Integer count = 0;
        for (AuthorityQueryCnd menuAuth : menuAuths) {
            if (menuAuth.getAuthIds().size() == 0) {
                count += 1;
            } else {
                count += menuAuth.getAuthIds().size();
            }
        }
        PageHelper.startPage(pageNo, pageSize);
        List<AuthorityPersonDO> list = authorityRepository.getPermissionalPersonList(menuAuths, count);
        PageInfo<AuthorityPersonDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    /**
     * 包括公用
     */
    public List<PersonRoleMenuDO> getMenuByPersonId(String personId, Integer system) {
        return personRoleMenuDao.getByPersonId(personId,system);
    }

    @Override
    public boolean checkAllPermission(String personId, Integer menuId, Integer key) {
        int result = authorityRepository.checkAllPermission(personId, menuId, key);
        return result > 0;
    }

    @Override
    public boolean checkPrivateMenuPermission(String personId, Integer menuId) {
        int result = authorityRepository.checkPrivateMenuPermission(personId, menuId);
        return result > 0;
    }

    @Override
    public boolean checkPrivateMenuPermission(String personId, String menuPrefix) {
        int result = authorityRepository.checkPrivateMenuPermissionWithPrefix(personId, menuPrefix);
        return result > 0;
    }

    @Override
    public List<RoleMenuDO> getMenuByRoleId(Integer roleId, Integer system) {
        return menuAuthorityDao.getMenuDOByRoleId(roleId,system);
    }

    @Override
    public void deletePersonDeptByIds(List<Integer> ids) {
        personDeptAuthDao.deleteAllByIdIn(ids);
    }

    @Override
    public void savePersonDept(List<PersonDeptAuthDO> personDeptAuthDOS) {
        personDeptAuthDao.saveAll(personDeptAuthDOS);
    }

    @Override
    public List<AuthorityDO> getOfficeMenuAuthority(String userId, Integer system) {
        return authorityRepository.getAuthorityByPersonIdAndSystem(userId, system);
    }

}
