package com.bsoft.workflow.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.manager.RoleMaintainManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.workflow.dao.primary.GroupRoleDao;
import com.bsoft.workflow.dao.primary.ProcessDeployDao;
import com.bsoft.workflow.entity.primary.GroupRoleDO;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.service.ActionService;
import com.bsoft.workflow.service.QueryService;
import com.bsoft.workflow.service.ResourcesService;
import com.bsoft.workflow.service.VariableService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Component
public class WorkFlowActionManagerImpl implements WorkFlowActionManager {
    private static final String WORKFLOW_APPLY_ID_TOKEN = "WorkFlowApplyId";
    @Autowired
    private RoleMaintainManager roleMaintainManager;
    @Reference(check = false, timeout = 60000)
    private ActionService actionService;
    @Reference(check = false, timeout = 60000)
    private VariableService variableService;
    @Reference(check = false, timeout = 60000)
    private QueryService queryService;
    @Reference(check = false, timeout = 60000)
    private ResourcesService resourcesService;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ProcessDeployDao processDeployDao;
    @Autowired
    private GroupRoleDao groupRoleDao;

    @Override
    public String startAndComplete(String personId, String personName, String dept, String title, String processKey, Integer id, Map<String, Object> map) {
        map.put("applyUserId",personId);//设置流程发起人
        map.put("applyUserName",personName);//设置流程发起人名称
        map.put("userId",personId);
        map.put("dept",dept);//设置流程发起部门
        map.put("action","提交");
        map.put("title",title); //设置流程标题

        String processDefinitionId = processDeployDao.findByKey(processKey).get(0).getDefinitionId();// 获取流程定义ID
        List<String> bpmnVariableNames = resourcesService.getBpmnVariableNames(processDefinitionId);//获取流程变量名
        List<RoleMaintainBaseDO> deptRoles = roleMaintainManager.getRoleMaintainBase(dept); //获取申请人所在部门的部门角色
        List<GroupRoleDO> groupRoles = groupRoleDao.findAll();//获取所有流程组角色
        for (String variableName : bpmnVariableNames) {
            if (variableName.contains("role_")) { // 部门角色
                if (variableName.contains("dept_")) {// 指定部门的角色（例如dept_0271_role_47）
                    String designatedDept = variableName.substring(variableName.indexOf("dept_") + 5, variableName.indexOf("role_") - 1);//截取指定的部门
                    String roleId = variableName.substring(variableName.indexOf("role_") + 5);// 截取角色ID
                    List<RoleMaintainBaseDO> designatedDeptRoles = roleMaintainManager.getRoleMaintainBase(designatedDept);// 获取指定部门的部门角色
                    designatedDeptRoles.forEach(x -> {
                        if(x.getRoleId().equals(Integer.valueOf(roleId))) {
                            map.put(variableName, x.getUserId());//将指定部门角色放入流程变量
                        }
                    });
                } else {// 未指定部门的就角色（例如role_47）
                    String roleId = variableName.substring(variableName.indexOf("role_") + 5);
                    deptRoles.forEach(x -> {
                        if (x.getRoleId().equals(Integer.valueOf(roleId))) {
                            map.put(variableName, x.getUserId());//将未指定部门角色放入流程变量
                        }
                    });
                }
            } else if (variableName.contains("group_")) {// 组角色（例如group_1）
                String groupId = variableName.substring(variableName.indexOf("group_") + 6);
                groupRoles.forEach(x -> {
                    if (x.getId().equals(Integer.valueOf(groupId))) {
                        map.put(variableName, x.getUsers());//将组角色放入流程变量
                    }
                });
            }
        }

        String processInstanceId = actionService.startAndComplete(processKey, String.valueOf(id), map);
        return processInstanceId;
    }

    @Override
    public void stop(String processInstanceId, String reason) {
        actionService.stop(processInstanceId, reason);
    }

    @Override
    public void setTaskLocalVar(String taskId, String key, Object value) {
        variableService.setTaskLocalVar(taskId, key, value);
    }

    @Override
    public void setTaskLocalVarWithProId(String processInstanceId, String key, Object value) {
        List<String> taskIds = queryService.getUnfinishedIdList(processInstanceId);
        taskIds.forEach(taskId ->{
            variableService.setTaskLocalVar(taskId, key, value);
        });
    }

    @Override
    public void complete(String taskId,Map<String, Object> map) {
        actionService.complete(taskId,map);
    }

    /**
     * 获取流程的申请ID（申请ID格式：流程标题英文缩写+年月6位+流水号3位，例如LCR202012001表示2020年12月第1条劳动合同续签申请）
     * @param processKey 流程定义KEY
     * @param size 获取ID的范围
     * @return 最近使用过的ID值（返回值的当前值不可用作申请ID的值）
     */
    @Override
    public Integer getApplyIdCurrentVal(String processKey, Integer size) {
        // 拼接键 workflowApplyId:laborContract
        StringBuilder key = new StringBuilder(WORKFLOW_APPLY_ID_TOKEN).append(":").append(processKey);

        // 获取该键的值
        String value = redisTemplate.opsForValue().get(key.toString());//当前值
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(serverDateManager.getServerDate());
        Integer startVal = calendar.get(Calendar.YEAR) * 100000 + (calendar.get(Calendar.MONTH) + 1) * 1000;//每月默认初始值
        Integer idNumber = null;
        if (StringUtils.isNotBlank(value)) {// 当前值不为空则直接获取
            Integer currentVal = Integer.valueOf(value);
            if (currentVal / 1000 == startVal / 1000) {// 当前值年月=默认初始值年月，说明月份未变更，无需重置
                idNumber = currentVal;
            } else {// 当前值年月！=默认初始值年月，说明月份已变更，重置值
                idNumber = startVal;
            }
        } else {// 当前值为空则获取初始值
            idNumber = startVal;
        }

        // 覆盖当前值
        Integer setNumber = idNumber + size;
        redisTemplate.delete(key.toString());
        redisTemplate.opsForValue().set(key.toString(), JSONObject.toJSONString(setNumber));

        return idNumber;
    }

    @Override
    public void completeNotifyTask(String taskId) {
        actionService.completeNotifyTask(taskId);
    }

}
