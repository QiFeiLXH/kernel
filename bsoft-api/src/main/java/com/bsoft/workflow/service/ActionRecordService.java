package com.bsoft.workflow.service;

import com.bsoft.workflow.dto.ActionRecordDTO;

import java.util.List;

public interface ActionRecordService {
    /**
     * 根据流程实例Id 获取流程操作信息
     * @param processInstanceId 流程实例Id
     * @param personId 工号
     * @return
     */
    List<ActionRecordDTO> getActionRecords(String personId,String processInstanceId);

    /**
     * 根据流程实例Id 获取流程操作信息  包含下一步待办信息
     * @param processInstanceId 流程实例Id
     * @param personId 工号
     * @return
     */
    List<ActionRecordDTO> getActionRecordsWithNext(String personId,String processInstanceId);
}
