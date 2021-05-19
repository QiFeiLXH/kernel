package com.bsoft.menu.service;

import com.bsoft.auth.dto.AuthorityDTO;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * @Description: 根据用户获取APP有权限的菜单信息
     * @param userId 工号
     * @return MenuDTO 菜单信息对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public MenuDTO getAppAuthMenu(String userId);

    /**
     * 获取有权限的office系统菜单信息
     * @param userId
     * @return
     */
//    public List<MenuDTO> getOfficeAuthMenu(String userId);

    /**
     * 获取有权限的系统菜单信息
     * @param userId 工号
     * @param system 系统id
     * @return
     */
    public List<MenuDTO> getOfficeAuthMenuBySystem(String userId,Integer system);

    /**
     * 获取不同系统所有菜单信息
     * @param system 系统id
     * @return
     */
    public List<MenuDTO> getOfficeAllMenuBySystem(Integer system);

    /**
     * 获取所有菜单及菜单权限，并获取角色的菜单及权限信息
     * @param roleId
     * @return
     * map.put(" menuList ", menusAll); 全部菜单，未禁用
     * map.put("actionList",actions); 全部操作权限
     * map.put("authMenuList",menusAuth); 有权限的菜单
     * map.put("authActionList",actionList); 权限的操作
     */
    public Map<String,Object> getOfficeAllMenuAndAuth(Integer roleId,Integer system);

    public OfficeMenuDTO getOfficeMenuInfo(Integer menuId);

    public Integer saveOfficeMenuInfo(OfficeMenuDTO officeMenuDTO,List<AuthorityDTO> authorityDTOS);

    /**
     * 禁用菜单
     * @param menuId 菜单ID
     * @param flag ‘stop’ 禁用，‘delete’ 删除
     * @return
     */
    public boolean deleteOfficeMenu(Integer menuId,String flag);

    /**
     * 根据系统获取全部的菜单和权限信息
     * @param system
     * @return 菜单和权限信息
     */
    public List<MenuAndAuthDTO> getMenuInfoBySystem(Integer system);

    /**
     * 根据菜单ID 获取菜单及权限信息
     * @param menuId
     * @return
     */
    public MenuAndAuthDTO getMenuInfoByMenuId(Integer menuId);

    /**
     * 保存菜单信息
     */
    public Integer saveMenuInfo(MenuAndAuthDTO menuAndAuthDTO);

    /**
     * 新权限管理系统，删除菜单信息
     * @param menuId
     * @param system
     */
    void deleteMenu(Integer menuId,Integer system);

    /**
     * 获取菜单及权限
     * @param roleId 角色ID
     * @param system 系统
     * @param personId 人员工号
     * @return
     */
    public Map<String,Object> getMenuWithAuth(Integer roleId,Integer system,String personId);

    /**
     * 保存权限信息
     * @param roleId 角色ID
     * @param personId 人员ID，若为0表示保存的是角色权限信息，不为0表示保存的是人员权限信息
     * @param system 系统ID
     * @param menuIds 选中的所以菜单ID
     * @param menuAuths 选中的菜单权限Map<menuId,authId>
     * @param menuRanges 选中的菜单数据范围Map<menuId,range>
     * @param personDeptAuths 选中的数据范围结构
     */

    void saveAuth(Integer roleId,String personId,Integer system,List<Integer> menuIds,List<Map> menuAuths,List<Map> menuRanges,List<Map> personDeptAuths);

    /**
     * 获取有权限的系统菜单、权限信息(带缓存)
     * @param userId 工号
     * @param system 系统id
     * @return
     */
    List<MenuAndAuthDTO>getOfficeAuthMenuList(String userId,Integer system);

    /**
    * @author zy
    * @description
    * @param menuId 根据菜单ID获取菜单信息
    */
    MenuDTO getMenu(String userId, Integer menuId);
}
