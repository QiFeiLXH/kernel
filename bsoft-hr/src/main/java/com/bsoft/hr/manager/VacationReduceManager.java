package com.bsoft.hr.manager;

import com.bsoft.hr.condition.VacationReduceQueryCnd;
import com.bsoft.hr.entity.primary.VacationReduceDO;
import org.springframework.data.domain.Page;

public interface VacationReduceManager {
    Page<VacationReduceDO> getVacationReduceList(VacationReduceQueryCnd cnd);

    void save(VacationReduceDO vacationReduce);

    void delete(VacationReduceDO vacationReduce);

    /**
     * 将记录设置为已执行
     * @param id
     */
    void setFlag(Integer id);
}
