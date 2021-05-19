package com.bsoft.workflow.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.workflow.condition.GroupRoleQueryCnd;
import com.bsoft.workflow.dto.GroupRoleDTO;
import com.bsoft.workflow.dto.GroupRoleQueryCndDTO;
import com.bsoft.workflow.entity.primary.GroupRoleDO;
import com.bsoft.workflow.manager.GroupRoleManager;
import com.bsoft.workflow.service.GroupRoleService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zy
 * @date: 2020/12/4
 * @description 流程组角色
 */
@Service
public class GroupRoleServiceImpl implements GroupRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupRoleServiceImpl.class);
    @Autowired
    private GroupRoleManager groupRoleManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<GroupRoleDTO> getGroupRoleList(String userId, GroupRoleQueryCndDTO queryCndDTO) {
        GroupRoleQueryCnd queryCnd = iGenerator.convert(queryCndDTO, GroupRoleQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<GroupRoleDO> resultDO = groupRoleManager.getGroupRoleList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号:[{}]获取流程组角色列表耗时:[{}]", userId, times);
        return iGenerator.convert(resultDO, GroupRoleDTO.class);
    }

    @Override
    public void saveGroupRole(String userId, GroupRoleDTO saveDTO) {
        GroupRoleDO saveDO = iGenerator.convert(saveDTO, GroupRoleDO.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        groupRoleManager.saveGroupRole(saveDO);
        long times = timeConsumer.end();
        LOGGER.info("工号:[{}]保存流程组角色信息耗时:[{}]", userId, times);
    }

    @Override
    public void deleteGroupRole(String userId, Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        groupRoleManager.deleteGroupRole(id);
        long times = timeConsumer.end();
        LOGGER.info("工号:[{}]保存流程组角色信息耗时:[{}]", userId, times);
    }
}
