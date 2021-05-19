package com.bsoft.system.manager;

import com.bsoft.system.entity.primary.TimeTaskGroupTreeDO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 10:54
 * @Version 1.0
 * @Description
 */
public interface TimeTaskGroupManager {
    TimeTaskGroupTreeDO save(TimeTaskGroupTreeDO timeTaskGroup);
    void delete(Integer id);
    List<TimeTaskGroupTreeDO> getGroupTree();
}
