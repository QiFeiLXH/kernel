package com.bsoft.hr.manager;

import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import com.bsoft.hr.entity.primary.WorkVacationTotalViewDO;
import org.springframework.data.domain.Page;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假Manager
 */
public interface WorkVacationManager {
    /**
     * 获取加班调休假（总览）
     */
    Page<WorkVacationTotalViewDO> getWorkVacationTotal(WorkVacationQueryCnd cnd);

    /**
     * 获取加班调休假（个人）
     */
    Page<WorkVacationDO> getWorkVacationPersonal(WorkVacationQueryCnd cnd);
}

