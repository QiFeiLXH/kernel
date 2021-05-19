package com.bsoft.user.manager;

import com.bsoft.common.result.Result;
import com.bsoft.user.condition.AppBindCountQueryCnd;
import com.bsoft.user.condition.AppDeptCountQueryCnd;
import com.bsoft.user.entity.primary.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户分布情况
 */
public interface AppUserCountManager {
    /**
     * APP用户部门分布情况
     * @param queryCnd 查询参数
     * @return APP用户部门分布情况列表
     */
    Result<AppDeptCountViewDO> getDeptCountList(AppDeptCountQueryCnd queryCnd);

    /**
     * APP用户省份分布情况
     * @return APP用户省份分布情况列表
     */
    List<AppProvinceCountDO> getProvinceCountList();

    /**
     * APP用户省份分布情况
     * @return APP用户终端分布情况列表
     */
    List<AppTerminalCountViewDO> getTerminalCountList();

    /**
     * APP用户绑定情况
     * @param queryCnd 查询参数
     * @return APP用户终端分布情况列表
     */
    List<AppBindCountDO> getBindCountList(AppBindCountQueryCnd queryCnd);

    /**
     * APP用户绑定情况(分页)
     * @param queryCnd 查询参数
     * @return APP用户终端分布情况列表
     */
    Result<AppBindCountDO> getBindCountListWithPage(AppBindCountQueryCnd queryCnd);

    /**
     * APP用户总绑定人数
     * @return 总绑定人数
     */
    Integer getBindTotalCount();

    /**
     * 公司总人数
     * @return 公司总人数
     */
    Integer getTotalCount(AppDeptCountQueryCnd cnd);

    /**
     * 获取公司总人数以及app用户绑定人数
     * @return
     */
    AppBoundProportionDO getBoundProportion(AppDeptCountQueryCnd cnd);

}
