package com.bsoft.menu.manager.impl;

import com.bsoft.auth.dao.primary.*;
import com.bsoft.auth.dto.*;
import com.bsoft.auth.entity.primary.*;
import com.bsoft.auth.manager.MenuAuthorityManager;
import com.bsoft.auth.manager.RoleManager;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.menu.dao.primary.MenuDao;
import com.bsoft.menu.dao.primary.OfficeMenuDao;
import com.bsoft.menu.dto.MenuAndAuthDTO;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.menu.dto.OfficeMenuDTO;
import com.bsoft.menu.entity.primary.MenuAndAuthDO;
import com.bsoft.menu.entity.primary.MenuDO;
import com.bsoft.menu.entity.primary.OfficeMenuDO;
import com.bsoft.menu.manager.MenuManager;
import com.bsoft.menu.repository.primary.MenuRepository;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Component
public class MenuManagerImpl implements MenuManager {

    private final static Logger logger = LoggerFactory.getLogger(MenuManagerImpl.class);
    public static final String DEFAULT_CACHENAME = "Auth";
    public static final String DEFAULT_CACHENAME_PUBLIC = DEFAULT_CACHENAME + ":public";
    public static final String DEFAULT_CACHENAME_USER = DEFAULT_CACHENAME + ":user";

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private OfficeMenuDao officeMenuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleMenuAuthDao roleMenuAuthDao;
    @Autowired
    private MenuAuthorityManager menuAuthorityManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private PersonRoleMenuDao personRoleMenuDao;
    @Autowired
    private PersonRoleMenuAuthDao personRoleMenuAuthDao;
    @Autowired
    private PersonDeptAuthDao personDeptAuthDao;
    private static final String KEY = "MENU";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public MenuDO getMenuById(Integer menuId) {
        Optional<MenuDO> menu = menuDao.findById(menuId);
        MenuDO menuDO = menu.orElseThrow(() -> new ServiceException("?????????????????????????????????menuid???" + menuId));
        return menuDO;
    }

    public List<MenuAndAuthDO> getPubMenuAndAuth(Integer system, List<AuthorityDO> auths) {
        List<MenuDO> list = this.getPubMenu(system);
        List<MenuAndAuthDO> menuAndAuthList = this.integrateMenuAndAuth(list, auths);
        return menuAndAuthList;
    }

    @Override
    public List<MenuDO> getPubMenu(Integer system) {
        return menuDao.findByPubFlagAndSystemAndActive(1,system,1);
    }

    public List<MenuAndAuthDO> getMenuAndAuthWithRole(String userId, Integer system, Integer roleId, List<AuthorityDO> auths) {
        List<MenuDO> list = menuRepository.getMenuWithRole(userId, system);
        List<MenuAndAuthDO> menuAndAuthList  = this.integrateMenuAndAuth(list, auths);
        return menuAndAuthList;
    }

    public List<MenuAndAuthDO> getMenuAndAuthWithPerson(String userId, Integer system, List<AuthorityDO> auths) {
        List<MenuDO> list = menuRepository.getMenuWithPerson(userId, system);
        List<MenuAndAuthDO> menuAndAuthList = this.integrateMenuAndAuth(list, auths);
        return menuAndAuthList;
    }

    @Override
    public List<MenuAndAuthDO> getPersonalMenuAndAuthList(String userId, Integer system, Integer roleId) {
        List<MenuAndAuthDO> menuDOS = new ArrayList<>();
        // ??????????????????(?????????????????????????????????)
        List<AuthorityDO> auths = menuAuthorityManager.getOfficeMenuAuthority(userId, system);
        // ????????????
        List<MenuAndAuthDO> pubMenus = this.getPubMenuAndAuth(system,auths);
        // ?????????????????????
        List<MenuAndAuthDO> roleMenus = this.getMenuAndAuthWithRole(userId, system, roleId, auths);
        // ?????????????????????
        List<MenuAndAuthDO> personMenus = this.getMenuAndAuthWithPerson(userId, system, auths);
        menuDOS.addAll(pubMenus);
        menuDOS.addAll(personMenus);
        menuDOS.addAll(roleMenus);
        return menuDOS;
    }

    /** ?????????????????????????????? */
    @Override
    public List<MenuAndAuthDO> getCachedPubMenu(Integer system) {
        String key = new StringBuffer().append(DEFAULT_CACHENAME_PUBLIC).append("::").append(system).toString();
        List<MenuAndAuthDO> menuAndAuthList = new ArrayList<>();
        String listString = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(listString)) {
            menuAndAuthList = FastJsonUtils.getJsonToList(listString, MenuAndAuthDO.class);
        } else {
            List<MenuDO> list = this.getPubMenu(system);
            if (!list.isEmpty()) {
                menuAndAuthList = generatorUtil.convert(list, MenuAndAuthDO.class);
                redisTemplate.opsForValue().set(key, FastJsonUtils.getBeanToJson(menuAndAuthList));
            }
        }
        return menuAndAuthList;
    }

    @Override
    public List<MenuAndAuthDO> getCachedPersonalMenuAndAuth(String userId, Integer system, Integer roleId) {
        String key = new StringBuffer().append(DEFAULT_CACHENAME_USER).append("::").append(userId).append(":").append(system).toString();
        List<MenuAndAuthDO> menuAndAuthList = new ArrayList<>();
        String listString = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(listString)) {
            menuAndAuthList = FastJsonUtils.getJsonToList(listString, MenuAndAuthDO.class);
        } else {
            menuAndAuthList = this.getPersonalMenuAndAuthList(userId,system,roleId);
            if (!menuAndAuthList.isEmpty()) {
                redisTemplate.opsForValue().set(key, FastJsonUtils.getBeanToJson(menuAndAuthList));
            }
        }
        return menuAndAuthList;
    }

    @Override
    public List<MenuDO> getMenus(List<Integer> menuIds) {
        return menuDao.findByIdIn(menuIds);
    }

    @Override
    public MenuDTO getAppMenu(String userId) {
        List<MenuDO> menuList = getAuthMenu(userId,18);
        List<RoleMenuAuthDO> roleMenuAuths  = menuAuthorityManager.getMenuAuth(userId,18);
        checkAuth(menuList);
        List<MenuDTO> menus =  generator.convert(menuList, MenuDTO.class);
        return processMenu(menus,roleMenuAuths);
    }

    @Override
    public List<MenuDTO> getOfficeMenuByStsrem(String userId, Integer system) {
        List<MenuDO> menuList = getAuthMenu(userId,system);
        checkAuth(menuList);
        List<MenuDTO> menus =  generator.convert(menuList, MenuDTO.class);
        return menus;
    }

    //???????????????system???????????????
    @Override
    public List<MenuDTO> getOfficeMenuList(Integer system) {
        List<MenuDO> menuDOList = menuDao.findBySystemOrderBySortAsc(system);
        List<MenuDTO> menus =  generator.convert(menuDOList, MenuDTO.class);
        return menus;
    }

    @Override
    public Map<String,Object> getOfficeMenuAndAuth(Integer system,Integer roleId) {
        //??????????????????????????????
        List<OfficeMenuDO> menuDOList = officeMenuDao.findBySystemAndActiveOrderBySortAsc(system,1);
        List<OfficeMenuDTO> menusAll =  generator.convert(menuDOList, OfficeMenuDTO.class);
        //????????????????????????
        List<AuthorityDO> authorityDOS = roleManager.getMenuAuth(system);
        List<AuthorityDTO> actions = generator.convert(authorityDOS,AuthorityDTO.class);
        //????????????????????????
        List<MenuDO> menuList = getAuthMenuByRoleId(roleId,system);
        List<MenuDTO> menusAuth =  generator.convert(menuList, MenuDTO.class);
        //??????????????????
        List<Map> actionList = roleManager.getMenuAuthWithRole(system,roleId);
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",menusAll);
        map.put("actionList",actions);
        map.put("authMenuList",menusAuth);
        map.put("authActionList",actionList);
        return map;
    }

    @Override
    public OfficeMenuDTO getOfficeMenuInfo(Integer menuId) {
        List<OfficeMenuDO> officeMenuDOList = officeMenuDao.findAllById(menuId);
        if (officeMenuDOList.size()>0){
            OfficeMenuDO officeMenuDO = officeMenuDOList.get(0);
            List<AuthorityDO> authorityDOList = authorityDao.findAllByMenuIdOrderByKeyAsc(menuId);
            List<Map> mapList = new ArrayList<>();
            if (authorityDOList.size()>0){
                for (AuthorityDO authorityDO:authorityDOList){
                    Map<String,Object> map = new HashMap<>();
                    map.put("id",authorityDO.getId());
                    map.put("name",authorityDO.getName());
                    map.put("menuId",authorityDO.getMenuId());
                    map.put("describe",authorityDO.getDescribe());
                    mapList.add(map);
                }
            }
            OfficeMenuDTO officeMenuDTO = generator.convert(officeMenuDO,OfficeMenuDTO.class);
            officeMenuDTO.setActionEntitySet(mapList);
            return officeMenuDTO;
        }
        return null;
    }

    @Override
    @Transactional
    public Integer saveOfficeMenuInfo(OfficeMenuDTO officeMenuDTO, List<AuthorityDTO> authorityDTOS) {
        OfficeMenuDO officeMenuDO = generator.convert(officeMenuDTO,OfficeMenuDO.class);
        List<AuthorityDO> authorityDOS = generator.convert(authorityDTOS,AuthorityDO.class);
        OfficeMenuDO officeMenuDO1 = officeMenuDao.saveAndFlush(officeMenuDO);
        if (officeMenuDO1.getId() == null){
            logger.error("????????????????????????");
            throw new ServiceException("???????????????????????????");
        }
        Integer menuId = officeMenuDO1.getId();
        List<AuthorityDO> authorityDOList = authorityDao.findAllByMenuIdOrderByKeyAsc(menuId);//????????????
        List<AuthorityDO> deletes = new ArrayList<>();
        if (authorityDOList.size() > 0 ){
            if (authorityDOS.size()>0){
                for (AuthorityDO authorityDO:authorityDOS){
                    Collection<AuthorityDO> result = Collections2.filter(authorityDOList, x-> !x.getId().equals(authorityDO.getId()));
                    List<AuthorityDO> authorityDOS1 = new ArrayList<>(result);
                    if (authorityDOS1.size() > 0 ){
                        deletes.add(authorityDOS1.get(0));
                    }
                }
            }
        }
        if (authorityDOS.size()>0){
            for (AuthorityDO authorityDO:authorityDOS){
                authorityDO.setMenuId(menuId);
            }
            try {
                authorityDao.deleteAll(deletes);
                authorityDao.saveAll(authorityDOS);
            } catch (Exception e){
                logger.error("??????????????????????????????");
                throw new ServiceException("?????????????????????????????????");
            }
        }
        return menuId;
    }

    @Override
    public boolean deleteMenu(Integer menuId,String flag) {
        boolean status = false;
        try {
            if ("stop".equals(flag)){
                OfficeMenuDO officeMenuDO = officeMenuDao.findAllById(menuId).get(0);
                officeMenuDO.setActive(0);
                officeMenuDao.saveAndFlush(officeMenuDO);
                status = true;
            } else if ("delete".equals(flag)) {
                //??????????????????
                officeMenuDao.deleteById(menuId);
                //????????????????????????
                authorityDao.deleteAllByMenuId(menuId);
                //????????????????????????
                roleMenuDao.deleteAllByMenuId(menuId);
                //??????????????????????????????
                roleMenuAuthDao.deleteAllByMenuId(menuId);
                status = true;
            }
        }catch (Exception e){
            throw new ServiceException("????????????\\???????????????");
        }
        return status;
    }

    private String getPublicDeleteKey(String key,Integer system){
        return new StringBuilder(key).append("::").append(system).toString();
    }
    private String getDeleteKey(String key,Integer system){
        return new StringBuilder(key).append("::").append("*").append(":").append(system).toString();
    }

    /**
     * ????????????????????????????????????ID???????????????????????????
     * @param system
     * @return
     */
    @Override
//    @Cacheable(cacheNames = KEY,key = "#system")
    public List<MenuAndAuthDO> getMenuInfoBySystem(Integer system) {
        String key = getPublicDeleteKey(KEY,system);
        String str = null;
        List<MenuAndAuthDO> menuAndAuthDOS = null;
        if (redisTemplate.hasKey(key) && !redisTemplate.opsForValue().get(key).isEmpty()){
            str = redisTemplate.opsForValue().get(key);
            menuAndAuthDOS = FastJsonUtils.getJsonToList(str,MenuAndAuthDO.class);
        }else{
            menuAndAuthDOS = this.getMenuAndAuthBySystem(system);
            str = FastJsonUtils.getBeanToJson(menuAndAuthDOS);
            redisTemplate.opsForValue().set(key,str);
        }
        return menuAndAuthDOS;
    }

    //????????????????????????????????????????????????redis??????
    public List<MenuAndAuthDO> getMenuAndAuthBySystem(Integer system){
        List<MenuAndAuthDO> menuAndAuthDOS = new ArrayList<>();
        List<MenuDO> menuDOS = menuDao.findBySystemOrderBySortAsc(system);
        List<AuthorityDO> authorityDOS = authorityDao.getMenuAuth(system);
        Collection<MenuDO> result = Collections2.filter(menuDOS, x->x.getParentId().equals(0));
        List<MenuDO> parent = new ArrayList<>(result);
        parent.forEach(MenuDO->{
            MenuAndAuthDO menuAndAuthDO = generator.convert(MenuDO,MenuAndAuthDO.class);
            Integer menuId = menuAndAuthDO.getId();
            Collection<AuthorityDO> authorityDOS1 = Collections2.filter(authorityDOS,x->x.getMenuId().equals(menuId));
            List<AuthorityDO> authorityDOS2 = new ArrayList<>(authorityDOS1);
            menuAndAuthDO.setAuth(authorityDOS2);
            menuAndAuthDOS.add(menuAndAuthDO);
            this.processMenuAndAuth(menuDOS,authorityDOS,menuAndAuthDO);
        });
        return menuAndAuthDOS;
    }
    /**
     * ????????????????????????????????????ID??????????????????
     * @param menuId
     * @return
     */
    @Override
    public MenuAndAuthDO getMenuInfoByMenuId(Integer menuId) {
        MenuDO menuDO = menuDao.getOne(menuId);
        List<AuthorityDO> authorityDOS = authorityDao.findAllByMenuIdOrderByKeyAsc(menuId);
        MenuAndAuthDO menuAndAuthDO = generator.convert(menuDO,MenuAndAuthDO.class);
        menuAndAuthDO.setAuth(authorityDOS);
        return menuAndAuthDO;
    }

    /**
     * ???????????????????????????????????????????????????
     * @param menuAndAuthDO
     * @return
     */
    @Override
    @Transactional
    public Integer saveMenuInfo(MenuAndAuthDO menuAndAuthDO) {
        MenuDO menuDO = generator.convert(menuAndAuthDO,MenuDO.class);
        String prefix = menuDO.getPrefix();//????????????
        List<MenuDO> menuDOS = menuDao.findAllByPrefixAndPrefixIsNotNull(prefix);
        if (menuDOS.size()>0){
            menuDOS.forEach(MenuDO->{
                if (prefix != null && MenuDO.getPrefix().equals(prefix) && !MenuDO.getId().equals(menuDO.getId())){
                    throw new ServiceException("?????????????????????????????????");
                }
            });
        }
        if (menuDO.getId()!=null){//?????????????????????
            List<AuthorityDO> orgList = authorityDao.findAllByMenuIdOrderByKeyAsc(menuDO.getId());//??????????????????
            List<AuthorityDO> newlist = menuAndAuthDO.getAuth();//???????????????
            List<AuthorityDO> deleteAuths = new ArrayList<>();
            List<Integer> deleteAuthIds = new ArrayList<>();
            orgList.forEach(AuthorityDO->{
                Collection<AuthorityDO> result = Collections2.filter(newlist, x->(x.getId() != null && x.getId().equals(AuthorityDO.getId())));
                if (result.size()<=0){
                    deleteAuths.add(AuthorityDO);
                    deleteAuthIds.add(AuthorityDO.getId());
                }
            });
            if (deleteAuthIds.size()>0){
                authorityDao.deleteAll(deleteAuths);//????????????????????????
                roleMenuAuthDao.deleteAllByAuthIdIn(deleteAuthIds);//?????????????????????????????????????????????
                personRoleMenuAuthDao.deleteAllByAuthIdIn(deleteAuthIds);//?????????????????????????????????????????????
            }
            menuDao.save(menuDO);
            authorityDao.saveAll(newlist);
            Set<String> personKeys = redisTemplate.keys(getDeleteKey(DEFAULT_CACHENAME_USER,menuDO.getSystem()));
            redisTemplate.delete(getPublicDeleteKey(KEY,menuDO.getSystem()));
            redisTemplate.delete(getPublicDeleteKey(DEFAULT_CACHENAME_PUBLIC,menuDO.getSystem()));
            redisTemplate.delete(personKeys);
            return menuDO.getId();
        }else{//????????????
            List<AuthorityDO> list = menuAndAuthDO.getAuth();//???????????????
            MenuDO newMenuDO = menuDao.save(menuDO);
            list.forEach(AuthorityDO->{
                AuthorityDO.setMenuId(newMenuDO.getId());
            });
            authorityDao.saveAll(list);
            Set<String> personKeys = redisTemplate.keys(getDeleteKey(DEFAULT_CACHENAME_USER,menuDO.getSystem()));
            redisTemplate.delete(getPublicDeleteKey(KEY,menuDO.getSystem()));
            redisTemplate.delete(getPublicDeleteKey(DEFAULT_CACHENAME_PUBLIC,menuDO.getSystem()));
            redisTemplate.delete(personKeys);
            return newMenuDO.getId();
        }
    }

    @Override
    @Transactional
    public void deleteMenu(Integer menuId,Integer system) {
        try {
            menuDao.deleteById(menuId);//??????????????????
            authorityDao.deleteAllByMenuId(menuId);//???????????????????????????????????????
            roleMenuDao.deleteAllByMenuId(menuId);//????????????????????????????????????
            roleMenuAuthDao.deleteAllByMenuId(menuId);//???????????????????????????????????????????????????
            personRoleMenuDao.deleteAllByMenuId(menuId);//????????????????????????????????????
            personRoleMenuAuthDao.deleteAllByMenuId(menuId);//??????????????????????????????????????????
            personDeptAuthDao.deleteAllByMenuId(menuId);//????????????????????????????????????????????????????????????
            logger.info("??????systemid=[{}],menuId=[{}]?????????????????????redis??????!",system,menuId);
            Set<String> personKeys = redisTemplate.keys(getDeleteKey(DEFAULT_CACHENAME_USER,system));
            redisTemplate.delete(getPublicDeleteKey(KEY,system));
            redisTemplate.delete(getPublicDeleteKey(DEFAULT_CACHENAME_PUBLIC,system));
            redisTemplate.delete(personKeys);
        }catch (Exception e){
            throw new ServiceException("?????????????????????");
        }
    }

    @Override
    //????????????????????????????????????
    public Map<String, Object> getMenuWithAuth(Integer roleId, Integer system, String personId) {
        Map<String,Object> map = new HashMap<>();
        List<MenuAndAuthDO> all = this.getMenuAndAuthBySystem(system);//?????????????????????????????????--?????????
        List<MenuAndAuthDTO> allDTOS = generator.convert(all,MenuAndAuthDTO.class);
        List<MenuDO> menus = getPubMenu(system);
        List<Integer> pubMenuIds = new ArrayList<>();
        menus.forEach(MenuDO->{
            pubMenuIds.add(MenuDO.getId());
        });
        //?????????????????????????????????
        List<RoleMenuDO> roleMenuDOS = menuAuthorityManager.getMenuByRoleId(roleId,system);
        List<RoleMenuDTO> roleMenuDTOS = generator.convert(roleMenuDOS,RoleMenuDTO.class);
        List<RoleMenuAuthDO> roleMenuAuthDOS = roleManager.getMenuAuthDOByRole(system,roleId);
        List<RoleMenuAuthDTO> roleMenuAuthDTOList = generator.convert(roleMenuAuthDOS,RoleMenuAuthDTO.class);

        //?????????????????????????????????
        List<PersonRoleMenuDO> personMenus = new ArrayList<>();
        List<PersonRoleMenuAuthDO> personRoleMenuAuthDOS = new ArrayList<>();
        List<PersonDeptAuthViewDO> personDeptAuthViewDOS = new ArrayList<>();
        if (!personId.equals("0")){//????????????????????????
            personMenus = menuAuthorityManager.getMenuByPersonId(personId,system);
            personRoleMenuAuthDOS = roleManager.getPersonMenuAuthDOByPersonId(system,personId);
            personDeptAuthViewDOS = roleManager.getPersonDept(personId,system);
        }
        List<PersonRoleMenuDTO> personRoleMenuDTOS = generator.convert(personMenus,PersonRoleMenuDTO.class);
        List<PersonRoleMenuAuthDTO> personRoleMenuAuthDTOS = generator.convert(personRoleMenuAuthDOS,PersonRoleMenuAuthDTO.class);
        List<PersonDeptAuthViewDTO> personDeptAuthViewDTOS = generator.convert(personDeptAuthViewDOS,PersonDeptAuthViewDTO.class);
        map.put("all",allDTOS);//?????????????????????????????????
        map.put("public",pubMenuIds);//??????????????????ID
        map.put("roleMenuDOS",roleMenuDTOS);//???????????????????????????
        map.put("roleMenuAuthDOS",roleMenuAuthDTOList);//?????????????????????????????????
        map.put("personMenus",personRoleMenuDTOS);//????????????????????????????????????
        map.put("personRoleMenuAuthDOS",personRoleMenuAuthDTOS);//??????????????????????????????????????????
        map.put("personDeptAuths",personDeptAuthViewDTOS);//??????????????????????????????????????????
        return map;
    }

    @Override
    @Transactional
    public void saveAuth(Integer roleId, String personId, Integer system, List<Integer> menuIds, List<Map> menuAuths, List<Map> menuRanges,List<Map> personDeptAuths) {
        if (personId.equals("0")){//?????????ID?????????????????????
            List<RoleMenuDO> roleMenuDOS = this.formatRoleMenu(roleId,system,menuIds,menuRanges);
            List<RoleMenuAuthDO> roleMenuAuthDOS = this.formatRoleMenuAuth(roleId,system,menuAuths);
            List<Integer> authIds = roleMenuAuthDOS.stream().map(RoleMenuAuthDO::getAuthId).collect(Collectors.toList());//??????ID
            roleMenuDao.deleteAllByRoleIdAndSystem(roleId,system);
            roleMenuAuthDao.deleteAllByRoleIdAndSystem(roleId,system);
            //????????????????????????????????????????????????????????????????????????
            List<String> personIds = roleManager.getRolePerson(roleId).stream().map(RolePersonViewDO::getPersonId).collect(Collectors.toList());
            personRoleMenuDao.deleteAllByPersonIdInAndMenuIdIn(personIds,menuIds);
            personRoleMenuAuthDao.deleteAllByPersonIdInAndAuthIdIn(personIds,authIds);
            roleMenuDao.saveAll(roleMenuDOS);
            roleMenuAuthDao.saveAll(roleMenuAuthDOS);
        }else{//????????????????????????
            List<PersonRoleMenuDO> personRoleMenuDOS = this.formatPersonMenu(roleId,personId,system,menuIds,menuRanges);
            List<PersonRoleMenuAuthDO> personRoleMenuAuthDOS = this.formatPersonMenuAuth(roleId,personId,system,menuAuths);
            personRoleMenuDao.deleteAllByPersonIdAndSystem(personId,system);
            personRoleMenuAuthDao.deleteAllByPersonIdAndSystem(personId,system);
            personRoleMenuDao.saveAll(personRoleMenuDOS);
            personRoleMenuAuthDao.saveAll(personRoleMenuAuthDOS);
            //??????????????????????????????????????????
            List<PersonDeptAuthViewDO> personDeptAuthViewDOS = roleManager.getPersonDept(personId,system);
            List<Integer> deleteIds = new ArrayList<>();
            List<PersonDeptAuthDO> needSave = generator.convert(personDeptAuths,PersonDeptAuthDO.class);
            if (needSave.size() > 0){
                for (int i=0;i<personDeptAuthViewDOS.size();i++){
                    PersonDeptAuthViewDO personDeptAuthViewDO = personDeptAuthViewDOS.get(i);
                    Collection<PersonDeptAuthDO> personDeptAuthDOS =
                            Collections2.filter(needSave,r->r.getMenuId() == personDeptAuthViewDO.getMenuId() && r.getPersonId() == personDeptAuthViewDO.getPersonId());
                    if (personDeptAuthDOS.size() <= 0){
                        deleteIds.add(personDeptAuthViewDO.getId());
                    }
                }
            }else{//?????????????????????????????????????????????
                personDeptAuthViewDOS.forEach(PersonDeptAuthViewDO->{
                    deleteIds.add(PersonDeptAuthViewDO.getId());
                });
            }
            menuAuthorityManager.deletePersonDeptByIds(deleteIds);
            menuAuthorityManager.savePersonDept(needSave);
        }
        logger.info("??????????????????????????????????????????");
        //??????????????????
        Set<String> personKeys = redisTemplate.keys(getDeleteKey(DEFAULT_CACHENAME_USER,system));
        redisTemplate.delete(getPublicDeleteKey(DEFAULT_CACHENAME_PUBLIC,system));
        redisTemplate.delete(personKeys);
    }


    private List<RoleMenuAuthDO> formatRoleMenuAuth(Integer roleId, Integer system, List<Map> menuAuths){
        List<RoleMenuAuthDO> roleMenuAuthDOS = new ArrayList<>();
        menuAuths.forEach(Map->{
            Integer menuId = Integer.valueOf(Map.get("menuId").toString());
            Integer authId = Integer.valueOf(Map.get("authId").toString());
            RoleMenuAuthDO roleMenuAuthDO = new RoleMenuAuthDO();
            roleMenuAuthDO.setRoleId(roleId);
            roleMenuAuthDO.setMenuId(menuId);
            roleMenuAuthDO.setAuthId(authId);
            roleMenuAuthDO.setSystem(system);
            roleMenuAuthDOS.add(roleMenuAuthDO);
        });
        return roleMenuAuthDOS;
    }

    private List<RoleMenuDO> formatRoleMenu(Integer roleId, Integer system, List<Integer> menuIds,List<Map> menuRanges){
        //?????????????????????????????????
        List<MenuDO> menus = getMenus(menuIds);
        List<RoleMenuDO> roleMenuDOS = new ArrayList<>();
        menus.forEach(MenuDO->{
            if (MenuDO.getPubFlag() != 1){//?????????
                RoleMenuDO roleMenuDO = new RoleMenuDO();
                roleMenuDO.setRoleId(roleId);
                roleMenuDO.setSystem(system);
                roleMenuDO.setMenuId(MenuDO.getId());
                roleMenuDOS.add(roleMenuDO);
            }
        });
        menuRanges.forEach(Map->{
            Integer menuId = Integer.valueOf(Map.get("menuId").toString());
            if(Map.containsKey("range") && Map.get("range") != null){
                Integer range = Integer.valueOf(Map.get("range").toString());
                Collection<RoleMenuDO> roleMenuDOS1 = Collections2.filter(roleMenuDOS,r->r.getMenuId() == menuId);
                if (roleMenuDOS1.size() > 0){
                    List<RoleMenuDO> list = new ArrayList<>(roleMenuDOS1);
                    list.get(0).setRange(range);
                }else{
                    RoleMenuDO roleMenuDO = new RoleMenuDO();
                    roleMenuDO.setRoleId(roleId);
                    roleMenuDO.setSystem(system);
                    roleMenuDO.setMenuId(menuId);
                    roleMenuDO.setRange(range);
                    roleMenuDOS.add(roleMenuDO);
                }
            }
        });
        return roleMenuDOS;
    }

    private List<PersonRoleMenuAuthDO> formatPersonMenuAuth(Integer roleId,String personId, Integer system, List<Map> menuAuths){
        List<RoleMenuAuthDO> roleMenuAuthDOS = roleMenuAuthDao.findAllByRoleId(roleId);//?????????????????????????????????
        List<PersonRoleMenuAuthDO> personRoleMenuAuthDOS = new ArrayList<>();
        menuAuths.forEach(Map->{

            Integer menuId = Integer.valueOf(Map.get("menuId").toString());
            Integer authId = Integer.valueOf(Map.get("authId").toString());
            Collection<RoleMenuAuthDO> results = Collections2.filter(roleMenuAuthDOS,r->r.getMenuId().equals(menuId) && r.getAuthId().equals(authId));
            if (results.size()<=0){
                PersonRoleMenuAuthDO personRoleMenuAuthDO = new PersonRoleMenuAuthDO();
                personRoleMenuAuthDO.setPersonId(personId);
                personRoleMenuAuthDO.setMenuId(menuId);
                personRoleMenuAuthDO.setAuthId(authId);
                personRoleMenuAuthDO.setSystem(system);
                personRoleMenuAuthDOS.add(personRoleMenuAuthDO);
            }
        });
        return personRoleMenuAuthDOS;
    }

    private List<PersonRoleMenuDO> formatPersonMenu(Integer roleId,String personId,Integer system ,List<Integer> menuIds,List<Map> menuRanges){
        //?????????????????????????????????
        List<MenuDO> menus = getMenus(menuIds);
        List<RoleMenuDO> roleMenuDOS = roleMenuDao.findAllByRoleId(roleId);//???????????????????????????
        List<PersonRoleMenuDO> personRoleMenuDOS = new ArrayList<>();
        menus.forEach(MenuDO->{
            Collection<RoleMenuDO> results = Collections2.filter(roleMenuDOS,r->r.getMenuId().equals(MenuDO.getId()));
            if (results.size() <= 0 && MenuDO.getPubFlag() != 1){//?????????????????????????????????????????????
                PersonRoleMenuDO personRoleMenuDO = new PersonRoleMenuDO();
                personRoleMenuDO.setPersonId(personId);
                personRoleMenuDO.setSystem(system);
                personRoleMenuDO.setMenuId(MenuDO.getId());
                personRoleMenuDOS.add(personRoleMenuDO);
            }
        });
        menuRanges.forEach(Map->{
            Integer menuId = Integer.valueOf(Map.get("menuId").toString());
            if (Map.containsKey("range") && Map.get("range") != null){
                Integer range = Integer.valueOf(Map.get("range").toString());
                Collection<PersonRoleMenuDO> personRoleMenuDOS1 = Collections2.filter(personRoleMenuDOS,r->r.getMenuId().equals(menuId));
                if (personRoleMenuDOS1.size() > 0){
                    List<PersonRoleMenuDO> list = new ArrayList<>(personRoleMenuDOS1);
                    list.get(0).setRange(range);
                }else{
                    PersonRoleMenuDO personRoleMenuDO = new PersonRoleMenuDO();
                    personRoleMenuDO.setPersonId(personId);
                    personRoleMenuDO.setSystem(system);
                    personRoleMenuDO.setMenuId(menuId);
                    personRoleMenuDO.setRange(range);
                    personRoleMenuDOS.add(personRoleMenuDO);
                }
            }
        });
        return personRoleMenuDOS;
    }

    private void processMenuAndAuth(List<MenuDO> menuDOS,List<AuthorityDO> authorityDOS,MenuAndAuthDO parent){
        Integer menuId = parent.getId();
        Collection<MenuDO> result = Collections2.filter(menuDOS, x->x.getParentId().equals(menuId));
        List<MenuDO> child = new ArrayList<>(result);
        List<MenuAndAuthDO> menuAndAuthDOS = generator.convert(child,MenuAndAuthDO.class);
        parent.setChild(menuAndAuthDOS);
        Collection<AuthorityDO> authorityDOS1 = Collections2.filter(authorityDOS,x->x.getMenuId().equals(menuId));
        List<AuthorityDO> authorityDOS2 = new ArrayList<>(authorityDOS1);
        parent.setAuth(authorityDOS2);
        for (int i=0;i<menuAndAuthDOS.size();i++){
            this.processMenuAndAuth(menuDOS,authorityDOS,menuAndAuthDOS.get(i));
        }
    }

    private List<MenuDO> getAuthMenuByRoleId(Integer roleId,Integer system){
        List<Integer> menuIds = menuAuthorityManager.getAuthMenuIdByRoleId(roleId,system);
        List<MenuDO> menus = getPubMenu(system);
        List<MenuDO> authMenus = getMenus(menuIds);
        menus.addAll(authMenus);
        return menus;
    }

    private List<MenuDO> getAuthMenu(String userId,Integer system){
        List<Integer> menuIds = menuAuthorityManager.getAuthMenuId(userId,system);
        List<MenuDO> menus = getPubMenu(system);
        List<MenuDO> authMenus = getMenus(menuIds);
        menus.addAll(authMenus);
        return menus;
    }

    private void checkAuth(List<MenuDO> menus){
        if(menus.isEmpty()) {
            throw new ServiceException("????????????????????????");
        }
    }


    private MenuDTO processMenu(List<MenuDTO> menus, List<RoleMenuAuthDO> roleMenuAuths){
        MenuDTO root = null;
        for(int i = 0;i < menus.size();i++){
            MenuDTO menu = menus.get(i);
            Integer id = menu.getId();
            Integer parentId = menu.getParentId();
            if(parentId == 0){
                root = menu;
            }
            Collection<MenuDTO> result = Collections2.filter(menus, x->x.getParentId().equals(id));
            if(result.size() > 0) {
                List<MenuDTO> list = new ArrayList<>(result);
                menu.setChild(list);
            }

            Collection<RoleMenuAuthDO> roleMenuAuth = Collections2.filter(roleMenuAuths,r->r.getMenuId().equals(id));
            for(RoleMenuAuthDO auth : roleMenuAuth){
                menu.getAuth().add(auth.getAuthId());
            }
        }
        if(root == null){
            throw new ServiceException("????????????????????????");
        }
        logger.info(FastJsonUtils.getBeanToJson(menus));
        return root;
    }

    private List<MenuAndAuthDO> integrateMenuAndAuth(List<MenuDO> menus, List<AuthorityDO> auths) {
        // ?????????????????????????????????
        List<MenuAndAuthDO> menuAndAuthDOS = generatorUtil.convert(menus, MenuAndAuthDO.class);
        if (!menus.isEmpty()) {
            Map<Integer, List<AuthorityDO>> authMap = auths.stream().collect(groupingBy(AuthorityDO::getMenuId));
            menuAndAuthDOS.forEach(menu -> {
                if (authMap.containsKey(menu.getId())) {
                    menu.setAuth(authMap.get(menu.getId()));
                }
            });
        }
        return menuAndAuthDOS;
    }
}
