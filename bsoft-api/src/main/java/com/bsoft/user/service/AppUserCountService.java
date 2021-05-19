package com.bsoft.user.service;

import com.bsoft.common.result.Result;
import com.bsoft.user.dto.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户统计
 */
public interface AppUserCountService {
    /**
     * 获取APP用户部门分布统计
     * @param userId 操作员工
     * @param queryCndDTO 查询参数
     * @return APP用户部门分布情况列表
     */
    Result<AppDeptCountDTO> getDeptCountList(String userId, AppDeptCountQueryCndDTO queryCndDTO);

    /**
     * 获取APP用户省份分布统计
     * @param userId 操作员工
     * @return APP用户省份分布情况列表
     */
    List<AppProvinceCountDTO> getProvinceCountList(String userId);

    /**
     * 获取APP用户终端分布统计
     * @param userId 操作员工
     * @return APP用户终端分布情况列表
     */
    List<AppTerminalCountDTO> getTerminalCountList(String userId);

    /**
     * 获取APP用户绑定统计
     * @param userId 操作员工
     * @param queryCndDTO 查询参数
     * @return APP用户绑定情况列表
     */
    List<AppBindCountDTO> getBindCountList(String userId, AppBindCountQueryCndDTO queryCndDTO);

    /**
     * 获取APP用户绑定统计(分页)
     * @param userId 操作员工
     * @param queryCndDTO 查询参数
     * @return APP用户绑定情况列表
     */
    Result<AppBindCountDTO> getBindCountListWithPage(String userId, AppBindCountQueryCndDTO queryCndDTO);

    /**
     * APP用户总绑定人数
     * @return 总绑定人数
     */
    Integer getBindTotalCount(String userId);

    /**
     * 获取公司总人数以及app用户绑定人数
     * @return
     */
    AppBoundProportionDTO getBoundProportion(String userId,AppDeptCountQueryCndDTO queryCndDTO);

}
