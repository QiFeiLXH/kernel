package com.bsoft.auth.manager.impl;

import com.bsoft.auth.dao.primary.*;
import com.bsoft.auth.dto.RoleDTO;
import com.bsoft.auth.dto.RolePersonDTO;
import com.bsoft.auth.entity.primary.*;
import com.bsoft.auth.manager.RoleManager;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Component
public class RoleManagerImpl implements RoleManager {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private IGenerator generator;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private RoleMenuAuthDao roleMenuAuthDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RolePersonDao rolePersonDao;
    @Autowired
    private PersonRoleMenuAuthDao personRoleMenuAuthDao;
    @Autowired
    private RolePersonViewDao rolePersonViewDao;
    @Autowired
    private PersonDeptAuthViewDao personDeptAuthViewDao;
    @Autowired
    private PersonDeptAuthDao personDeptAuthDao;
    @Autowired
    private PersonRoleMenuDao personRoleMenuDao;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    public static final String DEFAULT_CACHENAME = "Auth";
    public static final String DEFAULT_CACHENAME_USER = DEFAULT_CACHENAME + ":user";

    @Override
    public List<RoleDTO> getRoleList() {
        List<RoleDO> roleDOS = roleDao.findAll();
        List<RoleDTO> roleDTOS = generator.convert(roleDOS,RoleDTO.class);
        return roleDTOS;
    }

    @Override
    public List<RoleDTO> saveRole(RoleDTO roleDTO) {
        RoleDO roleDO = generator.convert(roleDTO,RoleDO.class);
        roleDao.save(roleDO);
        return this.getRoleList();
    }

    @Override
    public List<AuthorityDO> getMenuAuth(Integer system) {
        return authorityDao.getMenuAuth(system);
    }

    @Override
    public List<Map> getMenuAuthWithRole(Integer system, Integer roleId) {
        return roleMenuAuthDao.getMenuAuthByRoleId(roleId,system);
    }

    @Override
    public List<RoleMenuAuthDO> getMenuAuthDOByRole(Integer system, Integer roleId) {
        return roleMenuAuthDao.getMenuAuthDOByRoleId(roleId,system);
    }

    @Override
    public List<PersonRoleMenuAuthDO> getPersonMenuAuthDOByPersonId(Integer system, String personId) {
        return personRoleMenuAuthDao.getMenuAuthDOByRoleId(personId,system);
    }

    @Override
    public List<RolePersonDTO> getRolePersonList(Integer roleId) {
        List<RolePersonDO> rolePersonDOS = rolePersonDao.findByRoleId(roleId);
        List<RolePersonDTO> rolePersonDTOS = generator.convert(rolePersonDOS,RolePersonDTO.class);
        return rolePersonDTOS;
    }

    @Override
    public List<RolePersonViewDO> getRolePerson(Integer roleId) {
        return rolePersonViewDao.findAllByRoleId(roleId);
    }

    @Override
    @Transactional
    public boolean saveRolePerson(Integer roleId, List<String> add, List<String> remove) {
        if (remove.size()>0){
            List<RolePersonDO> rolePersonDOList = new ArrayList<>();
            for (String personId:remove){
                RolePersonDO rolePersonDO = new RolePersonDO();
                rolePersonDO.setPersonId(personId);
                rolePersonDO.setRoleId(roleId);
                rolePersonDOList.add(rolePersonDO);
            }
            rolePersonDao.deleteAll(rolePersonDOList);
        }
        if (add.size()>0){
            List<RolePersonDO> rolePersonDOList = new ArrayList<>();
            for (String personId:add){
                RolePersonDO rolePersonDO = new RolePersonDO();
                rolePersonDO.setPersonId(personId);
                rolePersonDO.setRoleId(roleId);
                rolePersonDOList.add(rolePersonDO);
            }
            rolePersonDao.saveAll(rolePersonDOList);
        }
        return true;
    }

    private String getDeletePersonKey(String key,String personId){
        return new StringBuilder(key).append("::").append(personId).append(":").append("*").toString();
    }

    @Override
    @Transactional
    public boolean deleteRole(Integer roleId) {
        try {
            roleDao.deleteById(roleId);
            roleMenuAuthDao.deleteAllByRoleId(roleId);
            roleMenuDao.deleteAllByRoleId(roleId);
            List<RolePersonDO> rolePersonDOS = rolePersonDao.findByRoleId(roleId);
            rolePersonDao.deleteAllByRoleIdEquals(roleId);
            List<String> personIds = new ArrayList<>();
            rolePersonDOS.forEach(RolePersonDO->{
                personIds.add(RolePersonDO.getPersonId());
                Set<String> personKeys = redisTemplate.keys(getDeletePersonKey(DEFAULT_CACHENAME_USER,RolePersonDO.getPersonId()));
                redisTemplate.delete(personKeys);
            });
            personDeptAuthDao.deleteAllByPersonIdIn(personIds);
            personRoleMenuAuthDao.deleteAllByPersonIdIn(personIds);
            personRoleMenuDao.deleteAllByPersonIdIn(personIds);
            return true;
        } catch (Exception e){
            throw new ServiceException("角色信息删除失败!");
        }
    }

    @Override
    public List<RoleDO> saveRoles(List<RoleDO> roleDOS) {
        return roleDao.saveAll(roleDOS);
    }

    @Override
    public RolePersonDO saveRolePerson(RolePersonDO rolePersonDO) {
        String personId = rolePersonDO.getPersonId();
        List<RolePersonDO> list = rolePersonDao.findByPersonId(personId);
        if (list.size()>0){
            throw new ServiceException("该人员已分配角色信息!");
        }
        return rolePersonDao.save(rolePersonDO);
    }

    @Override
    @Transactional
    public void deleteRolePerson(String personId) {
        List<RolePersonDO> rolePersonDOS = rolePersonDao.findByPersonId(personId);
        rolePersonDOS.forEach(RolePersonDO->{
            Set<String> personKeys = redisTemplate.keys(getDeletePersonKey(DEFAULT_CACHENAME_USER,RolePersonDO.getPersonId()));
            redisTemplate.delete(personKeys);
        });
        rolePersonDao.deleteAllByPersonIdEquals(personId);
        personRoleMenuAuthDao.deleteAllByPersonId(personId);
        personDeptAuthDao.deleteAllByPersonId(personId);
        personRoleMenuDao.deleteAllByPersonId(personId);
    }

    @Override
    public List<PersonDeptAuthViewDO> getPersonDept(String personId,Integer system) {
        return personDeptAuthViewDao.findAllByPersonIdAndSystem(personId,system);
    }

    @Override
    public List<RolePersonViewDO> getRolesPersonByPersonId(String personId) {
        return rolePersonViewDao.findAllByPersonId(personId);
    }

    @Override
    public RolePersonDO getRolePerson(String personId) {
        RolePersonDO rolePersonDO = rolePersonDao.getByPersonId(personId);
        return rolePersonDO;
    }
}
