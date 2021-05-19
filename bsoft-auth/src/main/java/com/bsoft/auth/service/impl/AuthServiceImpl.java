package com.bsoft.auth.service.impl;

import com.bsoft.auth.condition.AuthorityQueryCnd;
import com.bsoft.auth.dto.AuthorityPersonDTO;
import com.bsoft.auth.dto.AuthorityQueryCndDTO;
import com.bsoft.auth.entity.primary.AuthorityPersonDO;
import com.bsoft.auth.manager.MenuAuthorityManager;
import com.bsoft.auth.manager.ProjectPermissionManager;
import com.bsoft.auth.manager.UserPermissionManager;
import com.bsoft.auth.service.AuthService;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.utils.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Autowired
    private MenuAuthorityManager menuAuthorityManager;
    @Autowired
    private UserPermissionManager userPermissionManager;
    @Autowired
    private ProjectPermissionManager projectPermissionManager;
    @Autowired
    private IGenerator iGenerator;

//    @Override
//    public List<Map> getOfficeAuth(String userId) {
//        TimeConsumer timeConsumer = TimeConsumer.start();
//        List<Map> roleMenuAuthDTOList = menuAuthorityManager.getOfficeMenuAuth(userId,13);
//        long times = timeConsumer.end();
//        logger.info("工号:{}获取office菜单角色权限耗时:{}",userId,times);
//        return roleMenuAuthDTOList;
//    }
//
//    @Override
//    public List<Map> getOfficeAuthBySystem(String userId, Integer system) {
//        TimeConsumer timeConsumer = TimeConsumer.start();
//        List<Map> roleMenuAuthDTOList = menuAuthorityManager.getOfficeMenuAuth(userId,system);
//        long times = timeConsumer.end();
//        logger.info("工号:{}获取系统：{}菜单角色权限耗时:{}",userId,system,times);
//        return roleMenuAuthDTOList;
//    }

    @Override
    public boolean saveOfficeAuth(Integer roleId, List<Integer> menusId, List<Map> authInfo,Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Boolean status = menuAuthorityManager.saveOfficeMenuAuth(roleId,menusId,authInfo,system);
        long times = timeConsumer.end();
        logger.info("保存office菜单角色权限耗时:{}",times);
        return status;
    }

    @Override
    public List<String> getPersonalAuthorityDepts(String personId, Integer flag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<String> depts = null;
        if (flag == 1) {
            // 员工部门权限
            depts = userPermissionManager.getUserDeptPermission(personId);
        } else if (flag == 2) {
            // 工程区域权限
            depts = projectPermissionManager.getProjectAreaPermission(personId);
        }
        long times = timeConsumer.end();
        logger.info("获取员工工号：{}，类型：{} 的部门权限列表耗时:{}",personId,flag,times);
        return depts;
    }

    @Override
    public void saveAuthorityDept(String personId, Integer flag, List<String> needSaves, List<String> needDeletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        if (flag == 1) {
            userPermissionManager.saveDeptAuthority(personId, needSaves, needDeletes); // 部门权限的保存、删除
        } else if (flag == 2) {
            projectPermissionManager.saveProjectAuthority(personId, needSaves, needDeletes); // 工程区域权限的保存、删除
        }
        long times = timeConsumer.end();
        logger.info("保存、删除员工工号：{},类别：{}的权限部门列表耗时:{}",personId,times);
    }

    @Override
    public Result<AuthorityPersonDTO> getPermissionalPersonList(List<AuthorityQueryCndDTO> menuAuthDTOS, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AuthorityQueryCnd> menuAuths = iGenerator.convert(menuAuthDTOS, AuthorityQueryCnd.class);
        PageInfo<AuthorityPersonDO> persons = menuAuthorityManager.getPermissionalPersonList(menuAuths, pageNo, pageSize);
        long times = timeConsumer.end();
        logger.info("获取指定权限：{}，的人员列表耗时:{}", JSONUtils.toString(menuAuthDTOS),times);
        return ResultUtils.parseResult(persons, AuthorityPersonDTO.class);
    }

    @Override
    public boolean checkAllPermission(String personId, Integer menuId, Integer key) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean hasAllPermission = menuAuthorityManager.checkAllPermission(personId, menuId, key);
        long times = timeConsumer.end();
        logger.info("获取工号：{}是否拥有菜单：{}，全部权限：{}，耗时:{}", personId,menuId,key,times);
        return hasAllPermission;
    }

    @Override
    public boolean checkPrivateMenuPermission(String personId, Integer menuId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        boolean hasPermission = menuAuthorityManager.checkPrivateMenuPermission(personId, menuId);
        long times = timeConsumer.end();
        logger.info("获取工号：{}是否拥有非公用菜单：{}权限耗时:{}", personId,menuId,times);
        return hasPermission;
    }
}
