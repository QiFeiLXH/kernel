package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.AnnualVacationInfoDTO;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
public interface AnnualVacationService {
    /**
     * 获取年假信息
     * @param cndDTO
     * @return
     */
    Result<AnnualVacationInfoDTO> getAnnualVacationInfo(String userId, WorkVacationQueryCndDTO cndDTO);

    /**
     * 保存年假信息（hr）
     * @param workVacationDTO
     */
    void addAnnualVacation(String userId, WorkVacationDTO workVacationDTO);

    /**
     * 修改年假信息（hr）
     * @param workVacationDTO
     */
    void updateAnnualVacation(String userId, WorkVacationDTO workVacationDTO);


}
