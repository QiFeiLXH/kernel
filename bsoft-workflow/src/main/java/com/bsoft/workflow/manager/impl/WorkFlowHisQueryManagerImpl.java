package com.bsoft.workflow.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.result.Result;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.common.result.WFResult;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.WFTaskDTO;
import com.bsoft.workflow.dto.WFTaskQueryCndDTO;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.WorkFlowHisQueryManager;
import com.bsoft.workflow.service.HistoryQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class WorkFlowHisQueryManagerImpl implements WorkFlowHisQueryManager {
    @Reference(check=false,timeout = 10000)
    private HistoryQueryService historyQueryService;
    @Autowired
    private PersonManager personManager;
    @Override
    public Result<TaskDO> getFinishedProcess(TaskQueryCnd queryCnd) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd,WFTaskQueryCndDTO.class);
        WFResult<WFTaskDTO> result = historyQueryService.getFinishedProcessWithPage(queryCndDTO);
        List<WFTaskDTO> list = result.getItems();
        this.setAssigneeNames(list);
        result.setItems(list);
        return  GeneratorUtil.instance().convert(result, TaskDO.class);
    }

    @Override
    public Result<TaskDO> getFinishedTask(TaskQueryCnd queryCnd) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd,WFTaskQueryCndDTO.class);
        WFResult<WFTaskDTO> result = historyQueryService.getFinishedTaskWithPage(queryCndDTO);
        List<WFTaskDTO> list = result.getItems();
        this.setAssigneeNames(list);
        result.setItems(list);
        return  GeneratorUtil.instance().convert(result, TaskDO.class);
    }

    @Override
    public List<TaskDO> getFinishedTaskList(TaskQueryCnd queryCnd) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(queryCnd,WFTaskQueryCndDTO.class);
        List<WFTaskDTO> list = historyQueryService.getFinishedTaskList(queryCndDTO);
        this.setAssigneeNames(list);
        return GeneratorUtil.instance().convert(list, TaskDO.class);
    }

    /**
     * 设置代办人名字
     * @return
     */
    private void setAssigneeNames(List<WFTaskDTO> list) {
        Set<String> personIdSet =new HashSet<>();
        list.forEach(wfTaskDTO -> {
            String assignee = wfTaskDTO.getAssignee();
            if(StringUtils.isNotBlank(assignee) && !assignee.equals("system")){
                if(assignee.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(assignee.split(","));
                    personIdSet.addAll(idList);
                } else {
                    personIdSet.add(assignee);
                }
            }
        });
        List<String> peronIdList = new ArrayList<>(personIdSet);
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
        list.forEach(wfTaskDTO -> {
            String assignee = wfTaskDTO.getAssignee();
            if(StringUtils.isNotBlank(assignee) && !assignee.equals("system")){
                String assigneeName = "";
                if(assignee.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(assignee.split(","));
                    for(String id: idList) {
                        assigneeName += personMap.get(id) + ",";
                    }
                    assigneeName = assigneeName.substring(0, assigneeName.length() - 1);
                } else {
                    assigneeName = personMap.get(assignee);
                }
                wfTaskDTO.setAssigneeName(assigneeName);
            }
        });
    }
}
