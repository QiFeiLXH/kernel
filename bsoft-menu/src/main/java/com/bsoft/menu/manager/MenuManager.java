package com.bsoft.menu.manager;

import com.bsoft.auth.dto.AuthorityDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;
import com.bsoft.menu.entity.primary.MenuAndAuthDO;
import com.bsoft.menu.entity.primary.MenuDO;

import java.util.List;
import java.util.Map;

public interface MenuManager {
    /**
     * 根据ID获取菜单信息
     * @param menuId
     * @return
     */
    MenuDO getMenuById(Integer menuId);

    public List<MenuDO> getPubMenu(Integer system);

    public List<MenuDO> getMenus(List<Integer> menuIds);

    public MenuDTO getAppMenu(String userId);

//    public List<MenuDTO> getOfficeMenu(String userId);

    public List<MenuDTO> getOfficeMenuByStsrem(String userId,Integer system);

    public List<MenuDTO> getOfficeMenuList(Integer system);

    public Map<String,Object> getOfficeMenuAndAuth(Integer system,Integer roleId);

    public OfficeMenuDTO getOfficeMenuInfo(Integer menuId);

    public Integer saveOfficeMenuInfo(OfficeMenuDTO officeMenuDTO, List<AuthorityDTO> authorityDTOS);

    public boolean deleteMenu(Integer menuId,String flag);

    /**
     * 新权限管理系统，根据system获取全部菜单及权限信息
     * @param system
     * @return
     */
    public List<MenuAndAuthDO> getMenuInfoBySystem(Integer system);

    /**
     * 根据菜单ID获取菜单及权限信息
     * @param menuId
     * @return
     */
    MenuAndAuthDO getMenuInfoByMenuId(Integer menuId);

    /**
     * 新增、修改菜单信息
     * @param menuAndAuthDO
     * @return
     */
    Integer saveMenuInfo(MenuAndAuthDO menuAndAuthDO);

    /**
     * 删除菜单信息
     * @param menuId
     * @param system
     */
    void deleteMenu(Integer menuId,Integer system);

    /**
     * 获取菜单及权限
     * @param roleId
     * @param system
     * @param personId
     * @return
     */
    Map<String, Object> getMenuWithAuth(Integer roleId, Integer system, String personId);

    /**
     * 保存权限信息
     * @param roleId 角色ID
     * @param personId 人员ID，若为0表示保存的是角色权限信息，不为0表示保存的是人员权限信息
     * @param system 系统ID
     * @param menuIds 选中的所以菜单ID
     * @param menuAuths 选中的菜单权限Map<menuId,authId>
     * @param menuRanges 选中的菜单数据范围Map<menuId,range>
     * @param List<Map> personDeptAuths 选中的数据范围
     */
    void saveAuth(Integer roleId,String personId,Integer system,List<Integer> menuIds,List<Map> menuAuths,List<Map> menuRanges,List<Map> personDeptAuths);

    List<MenuAndAuthDO> getPersonalMenuAndAuthList(String userId, Integer system, Integer roleId);

    List<MenuAndAuthDO> getCachedPubMenu(Integer system);

    List<MenuAndAuthDO> getCachedPersonalMenuAndAuth(String userId, Integer system, Integer roleId);
}
