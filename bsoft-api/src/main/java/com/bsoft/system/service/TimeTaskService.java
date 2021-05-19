package com.bsoft.system.service;

import com.bsoft.common.result.Result;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.dto.TimeTaskQueryCndDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 16:25
 * @Version 1.0
 * @Description
 */
public interface TimeTaskService {
    /**
     * 获取定时任务列表
     * @param cnd 查询条件cnd
     * @return Result<TaskDTO>
     */
    Result<TimeTaskDTO> getTaskList(TimeTaskQueryCndDTO cnd);

    /**
     * 保存修改 定时任务
     * @param task
     */
    void saveTask(TimeTaskDTO task);

    /**
     * 删除定时任务
     * @param task
     */
    void remove(TimeTaskDTO task);

    /**
     * 批量删除定时任务
     * @param timeTaskDTOList
     */
    void removeBatch(List<TimeTaskDTO> timeTaskDTOList);

    /**
     * 启用/禁用 定时任务
     * @param jobId 任务ID
     * @param jobStatus 任务状态
     */
    void changeStatus(Integer jobId, String jobStatus);

    /**
     * 根据id获取定时任务信息
     * @param id
     * @return
     */
    TimeTaskDTO getById(Integer id);
}
