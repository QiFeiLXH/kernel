package com.bsoft.clue.service;

import com.bsoft.common.result.Result;
import com.bsoft.clue.dto.SalesCluesTaskDTO;
import com.bsoft.clue.dto.SalesCluesTaskQueryCndDTO;
import com.bsoft.clue.dto.SalesCluesViewDTO;

import java.util.Map;

public  interface SalesCluesService {
    /**
     * 提交
     * @param personId  操作人工号
     * @param clueId           线索编号
     */
    void submit(String personId, Integer clueId);

    /**
     *
     * 通过-审核
     * @param personId  操作人工号
     * @param taskId   待办任务ID
     * @param opinion 审核意见
     * @param system 操作系统
     * @param clueId 线索id
     * @param processInstanceId 流程实例id
     */
    void successApply(String personId, String taskId,String opinion,Integer system,Integer clueId,String processInstanceId);

    /**
     * 拒绝-审核
     * @param personId  操作人工号
     * @param taskId 待办任务ID
     * @param opinion 审核意见
     * @param system 操作系统
     */
    void failApply(String personId, String taskId,String opinion,Integer system);

    /**
     * 申请处理方法
     * @param personId  操作人工号
     * @param taskId 待办任务ID
     * @param map    变量组
     */
    void apply(String personId, String taskId, Map<String, Object> map);

    /**
     * 根据线索编号获取销售线索
     * @param clueId
     * @return
     */
    SalesCluesViewDTO getClue(String personId,Integer clueId);

    /**
     * 根据条件或者流程待办任务
     * @param data
     * @return
     */
    Result<SalesCluesTaskDTO> getTaskList(String personId,SalesCluesTaskQueryCndDTO data);
}
