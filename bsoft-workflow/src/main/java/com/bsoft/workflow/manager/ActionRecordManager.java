package com.bsoft.workflow.manager;

import com.bsoft.workflow.entity.primary.ActionRecordDO;

import java.util.List;

public interface ActionRecordManager {
    /**
     * 获取流程流转审核记录
     * @param processInstanceId
     * @return
     */
    List<ActionRecordDO> getActionRecords(String processInstanceId);

    /**
     * 获取流程流转审核记录，带下一步待办信息
     * @param processInstanceId
     * @return
     */
    List<ActionRecordDO> getActionRecordsWithNext(String processInstanceId);
}
