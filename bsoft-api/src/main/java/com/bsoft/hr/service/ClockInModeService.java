package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.ClockInModeDeptInfoDTO;
import com.bsoft.hr.dto.ClockInModePersonalInfoDTO;
import com.bsoft.hr.dto.ClockInModeQueryCndDTO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
public interface ClockInModeService {
    /**
     * 获取部门打卡方式信息
     * @param queryCndDTO
     * @return
     */
    Result<ClockInModeDeptInfoDTO> listDeptInfoWithPage(String userId, ClockInModeQueryCndDTO queryCndDTO);

    /**
     * 获取个人打卡方式信息
     * @param queryCndDTO
     * @return
     */
    Result<ClockInModePersonalInfoDTO> listPersonalInfoWithPage(String userId, ClockInModeQueryCndDTO queryCndDTO);

    /**
     * 设置部门打卡方式
     * @param deptInfoDTOList
     */
    void setDept(String userId, List<ClockInModeDeptInfoDTO> deptInfoDTOList);

    /**
     * 设置个人打卡方式
     * @param personalInfoDTOList
     */
    void setPersonal(String userId, List<ClockInModePersonalInfoDTO> personalInfoDTOList);
}
