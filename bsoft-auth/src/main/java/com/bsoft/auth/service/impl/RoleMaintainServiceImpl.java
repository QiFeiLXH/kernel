package com.bsoft.auth.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.auth.dto.RoleMaintainBaseDTO;
import com.bsoft.auth.dto.RoleNameDTO;
import com.bsoft.auth.entity.primary.DeptRoleDO;
import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.entity.primary.RoleNameDO;
import com.bsoft.auth.manager.RoleMaintainManager;
import com.bsoft.auth.service.RoleMaintainService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
@Service
public class RoleMaintainServiceImpl implements RoleMaintainService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleMaintainServiceImpl.class);

    @Autowired
    private RoleMaintainManager roleMaintainManager;


    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public RoleNameDTO saveRole(RoleNameDTO roleNameDTO){
        TimeConsumer time = TimeConsumer.start();
        RoleNameDO roleDO = generatorUtil.convert(roleNameDTO,RoleNameDO.class);
        roleDO = roleMaintainManager.saveRole(roleDO);
        long times = time.end();
        LOGGER.info("保存角色名称耗时:{}",times);
        return  generatorUtil.convert(roleDO,RoleNameDTO.class);
    }

    @Override
    public List<RoleNameDTO> saveRoles(List<RoleNameDTO> list) {
        List<RoleNameDO> roles = generatorUtil.convert(list,RoleNameDO.class);
        roles = roleMaintainManager.saveRoles(roles);
        return generatorUtil.convert(roles,RoleNameDTO.class);
    }

    @Override
    public List<RoleNameDTO> getRoles(Integer status, String content) {
        TimeConsumer time = TimeConsumer.start();
        List<RoleNameDO> roles = roleMaintainManager.getRoles(status, content);
        long times = time.end();
        LOGGER.info("status:{},content:{},获取角色名称列表耗时:{}",status,content,times);
        return generatorUtil.convert(roles, RoleNameDTO.class);
    }

    @Override
    public List<RoleMaintainBaseDTO> getRoleMaintainBase(String dept) {
        TimeConsumer time = TimeConsumer.start();
        List<RoleMaintainBaseDO> roleMaintainBase = roleMaintainManager.getRoleMaintainBase(dept);
        long times = time.end();
        LOGGER.info("部门：{},获取部门角色名称列表耗时:{}",dept,times);
        return generatorUtil.convert(roleMaintainBase,RoleMaintainBaseDTO.class);
    }

    @Override
    public void saveDeptRoles(List<RoleMaintainBaseDTO> list) {
        TimeConsumer time = TimeConsumer.start();
        List<DeptRoleDO> deptRoles = generatorUtil.convert(list, DeptRoleDO.class);
        roleMaintainManager.saveDeptRoles(deptRoles);
        long times = time.end();
        LOGGER.info("保存部门角色名称列表耗时:{}",times);
    }

    @Override
    public List<Map<String,Object>> getDeptRoleDetails() {
        TimeConsumer time = TimeConsumer.start();
        List<Map<String,Object>> list = roleMaintainManager.getDeptRoleDetails();
        long times = time.end();
        LOGGER.info("获取部门角色名称列表耗时:{}",times);
        return list;
    }

    @Override
    public String getDeptRole(String dept, Integer roleId) {
        TimeConsumer time = TimeConsumer.start();
        DeptRoleDO deptRole = roleMaintainManager.getDeptRole(dept,roleId);
        long times = time.end();
        LOGGER.info("获取部门角色名称列表耗时:{}",times);
        return deptRole == null ? null : deptRole.getUserId();
    }

    @Override
    public List<String> getManagerDept(String personId, Integer roleId) {
        return roleMaintainManager.getManagerDept(personId,roleId);
    }
}
