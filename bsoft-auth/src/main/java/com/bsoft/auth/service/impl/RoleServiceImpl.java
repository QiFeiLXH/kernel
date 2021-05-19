package com.bsoft.auth.service.impl;

import com.bsoft.auth.dto.RoleDTO;
import com.bsoft.auth.dto.RolePersonDTO;
import com.bsoft.auth.dto.RolePersonViewDTO;
import com.bsoft.auth.entity.primary.RoleDO;
import com.bsoft.auth.entity.primary.RolePersonDO;
import com.bsoft.auth.entity.primary.RolePersonViewDO;
import com.bsoft.auth.manager.RoleManager;
import com.bsoft.auth.service.RoleService;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleManager roleManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<RoleDTO> getRoleList() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RoleDTO> roleDTOS = roleManager.getRoleList();
        long times = timeConsumer.end();
        logger.info("获取office角色耗时:{}",times);
        return roleDTOS;
    }

    @Override
    public List<RoleDTO> saveRole(RoleDTO roleDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RoleDTO> roleDTOS = roleManager.saveRole(roleDTO);
        long times = timeConsumer.end();
        logger.info("保存并获取最新office角色耗时:{}",times);
        return roleDTOS;
    }

    @Override
    public List<RolePersonDTO> getRolePersonList(Integer roleId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RolePersonDTO> rolePersonDTOS = roleManager.getRolePersonList(roleId);
        long times = timeConsumer.end();
        logger.info("获取最新office角色用户列表耗时:{}",times);
        return rolePersonDTOS;
    }

    @Override
    public List<RolePersonViewDTO> getRolePerson(Integer roleId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RolePersonViewDO> list = roleManager.getRolePerson(roleId);
        long times = timeConsumer.end();
        logger.info("获取最新office角色用户姓名列表耗时:{}",times);
        return generatorUtil.convert(list, RolePersonViewDTO.class);
    }

    @Override
    public boolean saveRolePerson(Integer roleId, List<String> add, List<String> remove) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean status = roleManager.saveRolePerson(roleId,add,remove);
        long times = timeConsumer.end();
        logger.info("更新角色Id {} 所分配的人员信息耗时:{}",roleId,times);
        return status;
    }

    @Override
    public boolean deleteRole(Integer roleId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean status = roleManager.deleteRole(roleId);
        long times = timeConsumer.end();
        logger.info("删除角色Id {} 相关所有信息耗时:{}",roleId,times);
        return status;
    }

    @Override
    public List<RoleDTO> saveRoles(List<RoleDTO> roleDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RoleDO> roleDOS = generatorUtil.convert(roleDTOS,RoleDO.class);
        List<RoleDO> list = roleManager.saveRoles(roleDOS);
        long times = timeConsumer.end();
        logger.info("新权限管理系统，更新角色信息耗时:{}",times);
        return generatorUtil.convert(list,RoleDTO.class);
    }

    @Override
    public RolePersonDTO saveRolePerson(RolePersonDTO rolePersonDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        RolePersonDO rolePersonDO = generatorUtil.convert(rolePersonDTO,RolePersonDO.class);
        RolePersonDO personDO = roleManager.saveRolePerson(rolePersonDO);
        long times = timeConsumer.end();
        logger.info("新权限管理系统，保存角色人员信息耗时:{}",times);
        return generatorUtil.convert(personDO,RolePersonDTO.class);
    }

    @Override
    public void deleteRolePerson(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        roleManager.deleteRolePerson(personId);
        long times = timeConsumer.end();
        logger.info("新权限管理系统，删除角色人员[{}]信息耗时:{}",personId,times);
    }

    @Override
    public List<RolePersonViewDTO> getRolePersonByPersonId(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RolePersonViewDO> list = roleManager.getRolesPersonByPersonId(personId);
        long times = timeConsumer.end();
        logger.info("新权限管理系统，根据人员Id = [{}]获取拥有的角色信息耗时:{}",personId,times);
        return generatorUtil.convert(list,RolePersonViewDTO.class);
    }
}
