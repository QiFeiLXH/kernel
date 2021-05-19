package com.bsoft.workflow.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dao.primary.ActionRecordDao;
import com.bsoft.workflow.dto.WFTaskDTO;
import com.bsoft.workflow.entity.primary.ActionRecordDO;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.ActionRecordManager;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ActionRecordManagerImpl implements ActionRecordManager {
    @Autowired
    private ActionRecordDao actionRecordDao;
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;
    @Autowired
    private WorkFlowActionManager workFlowActionManager;
    @Autowired
    private PersonManager personManager;

    @Override
    public List<ActionRecordDO> getActionRecords(String processInstanceId) {
        List<ActionRecordDO> list = actionRecordDao.findAllByProcessInstanceIdOrderByAuditDateAscIdAsc(processInstanceId);
        this.setAuditorName(list);
        return list;
    }

    @Override
    public List<ActionRecordDO> getActionRecordsWithNext(String processInstanceId) {
        List<ActionRecordDO> actionRecordDOS = actionRecordDao.findAllByProcessInstanceIdOrderByAuditDateAscIdAsc(processInstanceId);
        this.setAuditorName(actionRecordDOS);
        TaskQueryCnd taskQueryCnd = new TaskQueryCnd();
        taskQueryCnd.setProcessInstanceId(processInstanceId);
        taskQueryCnd.setPageNo(0);//设置分页
        taskQueryCnd.setPageSize(999);//设置分页大小
        Result<TaskDO> result = workFlowQueryManager.getTaskList(taskQueryCnd); //获取当前流程待办任务
        List<TaskDO> taskDOS = result.getItems();
        Integer i = 0;
        for(TaskDO taskDO : taskDOS){ //将流程操作记录 以及 待办任务 结合到一个集合中
            ActionRecordDO actionRecord = new ActionRecordDO();
            actionRecord.setAction("待审核");
            actionRecord.setAuditor(taskDO.getAssigneeName());
            actionRecord.setTaskName(taskDO.getTaskName());
            actionRecord.setId(i);
            i--;
            actionRecordDOS.add(actionRecord);
        }
        return actionRecordDOS;
    }


    /**
     * 设置操作人姓名
     */
    private void setAuditorName(List<ActionRecordDO> list) {
        Set<String> personIdSet =new HashSet<>();
        list.forEach(item -> {
            // 获取操作人ID
            String auditor = item.getAuditor();
            if(StringUtils.isNotBlank(auditor) && !auditor.equals("system")){
                if(auditor.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(auditor.split(","));
                    personIdSet.addAll(idList);
                } else {
                    personIdSet.add(auditor);
                }
            }
        });
        List<String> peronIdList = new ArrayList<>(personIdSet);
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
        list.forEach(wfTaskDTO -> {
            // 设置代办人姓名
            String auditor = wfTaskDTO.getAuditor();
            if(StringUtils.isNotBlank(auditor) && !auditor.equals("system")){
                String auditorName = "";
                if(auditor.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(auditor.split(","));
                    for(String id: idList) {
                        auditorName += personMap.get(id) + ",";
                    }
                    auditorName = auditorName.substring(0, auditorName.length() - 1);
                } else {
                    auditorName = personMap.get(auditor);
                }
                wfTaskDTO.setAuditor(auditorName);
            }
        });
    }
}
