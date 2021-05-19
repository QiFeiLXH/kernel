package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:25
 * @Version 1.0
 * @Description
 */
public interface ContractLevelWorkloadService {
    /**
     * @Description: 获取报表人力成本-工作量-合同级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-全部-小计-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * 获取报表人力成本-工作量-合同级-全部-小计 列表
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelworkloadAllDTO> findAllSubTotalList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-合同级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-全部-年度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * 获取报表人力成本-工作量-合同级-全部-年度 列表
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelworkloadAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-合同级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-全部-月度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * 获取报表人力成本-工作量-合同级-全部-月度
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelworkloadAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-合同级-按产生部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-按产生部门类型-小计-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelworkloadAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-合同级-按产生部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-按产生部门类型-年度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-合同级-按产生部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-合同级-按产生部门类型-月度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ContractLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
