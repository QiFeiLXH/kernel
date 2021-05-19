package com.bsoft.person.manager;

import com.bsoft.person.dto.WorkDTO;
import com.bsoft.person.entity.primary.WorkDO;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/7/1
 * @Description:
 */
public interface WorkManager {

    void deleteWork(Integer id);

    void saveWork(List<WorkDTO> list);

    void saveWorkWithNoTransaction(List<WorkDO> list);

    List<WorkDO> getWorkList(Integer recruitmentId);

    List<WorkDO> getWorkList(Integer recruitmentId, Integer isInternship);

    WorkDO getWork(Integer id);

    List<WorkDO> getWorksWithPersonId(String personId);
}
