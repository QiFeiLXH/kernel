package com.bsoft.work.manager;

import com.bsoft.work.entity.primary.ManagerDO;
import java.util.List;

/**
 * @author ding cj
 * @date 2021/5/14 9:27
 */
public interface ManagerManager {
    /**
     * @param personName:姓名
     * @param councilId:委员会Id
     * @return
     */
    List<ManagerDO> findList(String personName, Integer councilId);

    /**
     *
     * @param id:主键id
     */
    void deleteManager(Integer id);

    /**
     *
     * @param managerList:要保存的记录
     */
    void saveManager(List<ManagerDO> managerList);
}
