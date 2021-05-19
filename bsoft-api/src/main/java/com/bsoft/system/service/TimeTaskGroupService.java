package com.bsoft.system.service;

import com.bsoft.system.dto.TimeTaskGroupTreeDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 11:21
 * @Version 1.0
 * @Description
 */
public interface TimeTaskGroupService {
    /**
     * 保存修改
     * @param timeTaskGroup
     * @return
     */
    TimeTaskGroupTreeDTO save(TimeTaskGroupTreeDTO timeTaskGroup);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取分组树
     * @return
     */
    List<TimeTaskGroupTreeDTO> getGroupTree();
}
