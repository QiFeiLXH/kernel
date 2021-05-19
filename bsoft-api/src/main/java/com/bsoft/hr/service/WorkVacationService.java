package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;
import com.bsoft.hr.dto.WorkVacationTotalViewDTO;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假Service
 */
public interface WorkVacationService {
    /**
     * 获取加班调休假（总览）
     */
    Result<WorkVacationTotalViewDTO> getWorkVacationTotal(WorkVacationQueryCndDTO cndDTO);

    /**
     * 获取加班调休假（个人）
     */
    Result<WorkVacationDTO> getWorkVacationPersonal(WorkVacationQueryCndDTO cndDTO);
}
