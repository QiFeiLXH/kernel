package com.bsoft.menu.service.impl;

import com.bsoft.auth.dto.AuthorityDTO;
import com.bsoft.auth.entity.primary.RolePersonDO;
import com.bsoft.auth.manager.RoleManager;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.exception.ServiceException;
import com.bsoft.file.document.file.dto.FileDefinitionDTO;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;
import com.bsoft.menu.entity.primary.MenuAndAuthDO;
import com.bsoft.menu.entity.primary.MenuDO;
import com.bsoft.menu.manager.MenuManager;
import com.bsoft.menu.service.MenuService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Autowired
    private MenuManager menuManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private FilerServerManager filerServerManager;
    @Autowired
    private RoleManager roleManager;

    @Override
    public MenuDTO getAppAuthMenu(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MenuDTO menu = menuManager.getAppMenu(userId);
        long times = timeConsumer.end();
        logger.info("工号:{}获取app菜单耗时:{}",userId,times);
        return menu;
    }

//    @Override
//    public List<MenuDTO> getOfficeAuthMenu(String userId) {
//        TimeConsumer timeConsumer = TimeConsumer.start();
//        List<MenuDTO> menu = menuManager.getOfficeMenu(userId);
//        long times = timeConsumer.end();
//        logger.info("工号:{}获取office菜单耗时:{}",userId,times);
//        return menu;
//    }

    @Override
    public List<MenuDTO> getOfficeAuthMenuBySystem(String userId, Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MenuDTO> menu = menuManager.getOfficeMenuByStsrem(userId,system);
        long times = timeConsumer.end();
        logger.info("工号:{}获取系统：{}菜单耗时:{}",userId,system,times);
        return menu;
    }

    @Override
    public List<MenuDTO> getOfficeAllMenuBySystem(Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MenuDTO> menuDTOS = menuManager.getOfficeMenuList(system);
        long times = timeConsumer.end();
        logger.info("菜单设置获取系统[{}]，菜单耗时:{}",system,times);
        return menuDTOS;
    }

    @Override
    public Map<String ,Object> getOfficeAllMenuAndAuth(Integer roleId,Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Map<String,Object> maps = menuManager.getOfficeMenuAndAuth(system,roleId);
        long times = timeConsumer.end();
        logger.info("权限设置获取系统[{}]，角色[{}]菜单权限耗时:{}",system,roleId,times);
        return maps;
    }

    @Override
    public OfficeMenuDTO getOfficeMenuInfo(Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OfficeMenuDTO officeMenuDTO = menuManager.getOfficeMenuInfo(menuId);
        long times = timeConsumer.end();
        logger.info("获取菜单ID = {} 的菜单详细信息限耗时:{}",menuId,times);
        return officeMenuDTO;
    }

    @Override
    public Integer saveOfficeMenuInfo(OfficeMenuDTO officeMenuDTO, List<AuthorityDTO> authorityDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Integer menuId = menuManager.saveOfficeMenuInfo(officeMenuDTO,authorityDTOS);
        long times = timeConsumer.end();
        logger.info("更新菜单信息(id={})限耗时:{}",menuId,times);
        return menuId;
    }

    @Override
    public boolean deleteOfficeMenu(Integer menuId,String flag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean status = false;
        status = menuManager.deleteMenu(menuId,flag);
        long times = timeConsumer.end();
        logger.info("禁用菜单信息(id={})限耗时:{}",menuId,times);
        return status;
    }

    @Override
    public List<MenuAndAuthDTO> getMenuInfoBySystem(Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MenuAndAuthDO> menuAndAuthDOS = menuManager.getMenuInfoBySystem(system);
        List<MenuAndAuthDTO> menuAndAuthDTOS = generatorUtil.convert(menuAndAuthDOS,MenuAndAuthDTO.class);
        long times = timeConsumer.end();
        logger.info("新权限管理系统获取菜单信息限耗时:{}",times);
        return menuAndAuthDTOS;
    }

    @Override
    public MenuAndAuthDTO getMenuInfoByMenuId(Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MenuAndAuthDO menuAndAuthDO = menuManager.getMenuInfoByMenuId(menuId);
        MenuAndAuthDTO menuAndAuthDTO = generatorUtil.convert(menuAndAuthDO,MenuAndAuthDTO.class);
        if (menuAndAuthDO.getHelp() != null){
            FileDefinitionDTO fileDefinitionDTO = filerServerManager.getFileInfo(menuAndAuthDO.getHelp());
            menuAndAuthDTO.setFileName(fileDefinitionDTO.getFileName());
        }
        long times = timeConsumer.end();
        logger.info("获取菜单ID=[{}]的详细信息,耗时[{}]",menuId,times);
        return menuAndAuthDTO;
    }

    @Override
    public Integer saveMenuInfo(MenuAndAuthDTO menuAndAuthDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MenuAndAuthDO menuAndAuthDO = generatorUtil.convert(menuAndAuthDTO,MenuAndAuthDO.class);
        Integer menuId = menuManager.saveMenuInfo(menuAndAuthDO);
        long times = timeConsumer.end();
        logger.info("保存菜单信息耗时{}",times);
        return menuId;
    }

    @Override
    public void deleteMenu(Integer menuId,Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        menuManager.deleteMenu(menuId,system);
        long times = timeConsumer.end();
        logger.info("删除菜单信息耗时{}",times);
    }

    @Override
    public Map<String, Object> getMenuWithAuth(Integer roleId, Integer system, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Map<String,Object> map = menuManager.getMenuWithAuth(roleId,system,personId);
        long times = timeConsumer.end();
        logger.info("获取systemId=[{}],roleId=[{}],personId=[{}]的所以菜单按钮信息及相关权限信息耗时{}",system,roleId,personId,times);
        return map;
    }

    @Override
    public void saveAuth(Integer roleId, String personId, Integer system, List<Integer> menuIds, List<Map> menuAuths, List<Map> menuRanges,List<Map> personDeptAuths) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        menuManager.saveAuth(roleId,personId,system,menuIds,menuAuths,menuRanges,personDeptAuths);
        long times = timeConsumer.end();
        logger.info("保存权限信息耗时：{}!roleId=[{}],personId=[{}],system=[{}],menuIds=[{}],menuAuths=[{}],menuRanges=[{}],personDeptAuths=[{}]", times,roleId,personId,system,menuIds,menuAuths,menuRanges,personDeptAuths);
    }

    @Override
    public List<MenuAndAuthDTO> getOfficeAuthMenuList(String userId, Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<MenuAndAuthDO> menuDOS = new ArrayList<>();
        RolePersonDO rolePerson = roleManager.getRolePerson(userId);
        if (rolePerson != null) {
            // 有角色时，查询员工拥有的菜单列表（公用菜单、角色菜单、自有菜单）与权限
            menuDOS = menuManager.getCachedPersonalMenuAndAuth(userId, system, rolePerson.getRoleId());
        } else {
            // 无角色时，查询公用菜单
            menuDOS = menuManager.getCachedPubMenu(system);
        }
        if (menuDOS.isEmpty()) {
            throw new ServiceException("没有权限访问系统");
        }
        long times = timeConsumer.end();
        logger.info("工号:{}获取系统：{}菜单耗时:{}",userId,system,times);
        return generatorUtil.convert(menuDOS, MenuAndAuthDTO.class);
    }

    @Override
    public MenuDTO getMenu(String userId, Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        MenuDO menuDO = menuManager.getMenuById(menuId);
        long times = timeConsumer.end();
        logger.info("工号：{}，获取菜单信息耗时：{}",userId, times);
        return generatorUtil.convert(menuDO, MenuDTO.class);
    }

}
