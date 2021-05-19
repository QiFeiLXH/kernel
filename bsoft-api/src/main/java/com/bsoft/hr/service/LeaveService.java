package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/17 14:54
 * @Description
 */
public interface LeaveService {
    /** 假期记录列表查询
     * @Param: cnd 条件
     * @return com.bsoft.common.result.Result<WorkLeaveVacationDTO>
     * @author Xuhui Lin
     */
    Result<WorkLeaveVacationDTO> getWorkLeaveVacationList(LeaveQueryCndDTO cnd);

    /** 年休、调休已使用列表查询
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @Param: personId 工号
     * @Param: type 请假类型
     * @Param: year 年份
     * @return com.bsoft.common.result.Result<LeaveDTO>
     * @author Xuhui Lin
     */
    Result<LeaveInfoDTO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    /** 年休、调休总列表查询
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @Param: personId 工号
     * @Param: type 假期类型
     * @Param: flag 数据类型（1历年 2当年）
     * @Param: year 年份
     * @return com.bsoft.common.result.Result<WorkVacationTotalDTO>
     * @author Xuhui Lin
     */
    Result<WorkVacationTotalDTO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    /** 个人假期记录列表查询
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @Param: personId 工号
     * @Param: year 年份
     * @return com.bsoft.common.result.Result<PersonalWorkLeaveVacationDTO>
     * @author Xuhui Lin
     */
    Result<PersonalWorkLeaveVacationDTO> getPersonalVacationList(Integer pageNo, Integer pageSize, String personId, String year);

    /** 个人调休、年休总天数列表查询
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @Param: personId 工号
     * @Param: year 年份
     * @Param: type 假期类别 13年休 12调休
     * @return com.bsoft.common.result.Result<WorkVacationDTO>
     * @author Xuhui Lin
     */
    Result<WorkVacationTotalDTO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String personId, String year, Integer type);

    /** 个人调休、年休已用列表查询
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @Param: personId 工号
     * @Param: year 年份
     * @Param: type 年休 调休
     * @return com.bsoft.common.result.Result<LeaveInfoDTO>
     * @author Xuhui Lin
     */
    Result<LeaveInfoDTO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String personId, String year,Integer type);
}
