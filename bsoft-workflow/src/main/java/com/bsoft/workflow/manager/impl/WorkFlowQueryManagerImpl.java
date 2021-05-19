package com.bsoft.workflow.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.result.Result;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.common.result.WFResult;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dao.primary.ProcessDeployDao;
import com.bsoft.workflow.dto.*;
import com.bsoft.workflow.entity.primary.*;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import com.bsoft.workflow.service.HistoryQueryService;
import com.bsoft.workflow.service.QueryService;
import com.bsoft.workflow.service.ResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class WorkFlowQueryManagerImpl implements WorkFlowQueryManager {
    @Reference(check=false,timeout = 10000)
    private QueryService queryService;
    @Reference(check=false,timeout = 10000)
    private HistoryQueryService historyQueryService;
    @Reference(check=false,timeout = 10000)
    private ResourcesService resourcesService;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private ProcessDeployDao processDeployDao;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public BpmnModelDO getBpmnModelMessage(String processInstanceId) {
        WFBpmnModelDTO bpmnModelDTO = queryService.getBpmnModelMessage(processInstanceId);
        Map<String,Object> panelMap = bpmnModelDTO.getPanel();
        for (Map.Entry<String, Object> entry : panelMap.entrySet()) {
            Map<String,Object> infoMap = (Map<String, Object>) entry.getValue();
            if(infoMap.containsKey("assignee")){
                String assignee = (String) infoMap.get("assignee");
                if(StringUtils.isNotBlank(assignee) && !assignee.equals("system")){
                    String assigneeName = getTaskCandidateOrAssigneeName(assignee);
                    infoMap.put("assigneeName",assigneeName);
                }
            }
        }
        bpmnModelDTO.setPanel(panelMap);
        return GeneratorUtil.instance().convert(bpmnModelDTO,BpmnModelDO.class);
    }

    @Override
    public Result<TaskDO> getTaskList(TaskQueryCnd data) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(data,WFTaskQueryCndDTO.class);
        WFResult<WFTaskDTO> result = queryService.getTaskList(queryCndDTO);
        List<WFTaskDTO> list = result.getItems();
        this.setAssigneeNameAndApplyUserName(list);
        result.setItems(list);
        return  GeneratorUtil.instance().convert(result, TaskDO.class);
    }

    @Override
    public List<TaskDO> getTaskListWithoutPage(TaskQueryCnd data) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(data,WFTaskQueryCndDTO.class);
        List<WFTaskDTO> list =  queryService.getTaskListWithoutPage(queryCndDTO);
        return GeneratorUtil.instance().convert(list, TaskDO.class);
    }

    @Override
    public Result<TaskDO> getTaskListWithNotify(TaskQueryCnd data) {
        WFTaskQueryCndDTO queryCndDTO = GeneratorUtil.instance().convert(data, WFTaskQueryCndDTO.class);
        WFResult<WFTaskDTO> result = queryService.getTaskListWithNotify(queryCndDTO);
        List<WFTaskDTO> list = result.getItems();
        this.setAssigneeNameAndApplyUserName(list);
        result.setItems(list);
        return  GeneratorUtil.instance().convert(result, TaskDO.class);
    }

    @Override
    public List<ProcessTaskCountDO> getProcessTaskCount() {
        List<ProcessDeployDO> processDeployDOList = processDeployDao.findByStatus(1);// 查找已部署流程
        List<WFProcessTaskCountDTO> wfProcessTaskCountDTOList = iGenerator.convert(processDeployDOList, WFProcessTaskCountDTO.class);
        List<WFProcessTaskCountDTO> resultDTO = queryService.countProcessTask(wfProcessTaskCountDTOList);// 统计待办任务数量
        List<ProcessTaskCountDO> resultDO = iGenerator.convert(resultDTO, ProcessTaskCountDO.class);
        return resultDO;
    }

    @Override
    public List<CustomerParamDO> getCustomParam(String taskId) {
        List<WFCustomerParamDTO> paramDTOS = resourcesService.getCustomParam(taskId);
        return GeneratorUtil.instance().convert(paramDTOS,CustomerParamDO.class);
    }

    @Override
    public Result<TaskDO> getNotifyTaskList(TaskQueryCnd data) {
        WFTaskQueryCndDTO cndDTO = GeneratorUtil.instance().convert(data,WFTaskQueryCndDTO.class);
        WFResult<WFTaskDTO> result = queryService.getNotifyTaskList(cndDTO);
        List<WFTaskDTO> list = result.getItems();
        this.setAssigneeNameAndApplyUserName(list);
        result.setItems(list);
        return GeneratorUtil.instance().convert(result, TaskDO.class);
    }

    /**
     * 设置代办人及申请人姓名
     * @return
     */
    private void setAssigneeNameAndApplyUserName(List<WFTaskDTO> list) {
        Set<String> personIdSet =new HashSet<>();
        list.forEach(wfTaskDTO -> {
            // 获取代办人ID
            String assignee = wfTaskDTO.getAssignee();
            if(StringUtils.isNotBlank(assignee) && !assignee.equals("system")){
                if(assignee.indexOf(",") > -1) {
                    List<String> idList = Arrays.asList(assignee.split(","));
                    personIdSet.addAll(idList);
                } else {
                    personIdSet.add(assignee);
                }
            }
            // 获取申请人ID
            personIdSet.add(wfTaskDTO.getApplyUserId());
        });
        List<String> peronIdList = new ArrayList<>(personIdSet);
        List<PersonDO> personList = personManager.getPersonList(peronIdList);
        Map<String, String> personMap = personList.stream().collect(Collectors.toMap(PersonDO::getPersonId, PersonDO::getPersonName));
        list.forEach(wfTaskDTO -> {
            // 设置代办人姓名
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
            // 设置申请人姓名
            wfTaskDTO.setApplyUserName(personMap.get(wfTaskDTO.getApplyUserId()));
        });
    }

   public String getTaskCandidateOrAssigneeName (String candidateUsers) { //获取任务待办人或者候选人姓名
       String candidateUserNames = "";
       if (candidateUsers.indexOf(",") > -1) {
           //有逗号说明是组任务，工号以逗号分隔
           List<String> list = Arrays.asList(candidateUsers.split(","));
           for (String candidateUser : list) {
               PersonDO personDO = personManager.getPerson(candidateUser);
               if (personDO != null) {
                   candidateUserNames += personDO.getPersonName() + ",";
               }
           }
           ;
           candidateUserNames = candidateUserNames.substring(0, candidateUserNames.length() - 1);
       } else {
           //没有逗号说明只有一个人
           PersonDO personDO = personManager.getPerson(candidateUsers);
           if (personDO != null) {
               candidateUserNames = personDO.getPersonName();
           }
       }
       return candidateUserNames;
   }
}
