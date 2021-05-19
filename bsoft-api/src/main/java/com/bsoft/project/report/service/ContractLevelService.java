package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.ContractAllByMonthDTO;
import com.bsoft.project.report.dto.ContractAllSubTotalDTO;
import com.bsoft.project.report.dto.ContractDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ContractDepTypeByYearDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2019-12-23 15:35
 * @Version 1.0
 * @Description
 */
public interface ContractLevelService {
    /**
     * @Description: 获取报表-合同级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ContractAllSubTotalDTO> 合同级-全部-小计-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    Result<ContractAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ContractAllSubTotalDTO> 合同级-全部-小计-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    List<ContractAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-合同级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 合同级-全部-年度-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    Result<ContractAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<Map<String,String>> 合同级-全部-年度-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    List<ContractAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-合同级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ContractAllByMonthDTO> 合同级-全部-月度-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    Result<ContractAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ContractAllByMonthDTO> 合同级-全部-月度-列表
     * @author zhanglf
     * @Time 2019年12月23日 下午3:40:24
     */
    List<ContractAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ContractDepTypeByYearDTO> 合同级-按产生部门类型-小计-列表
     * @author zhanglf
     */
    Result<ContractDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ContractDepTypeByYearDTO> 合同级-按产生部门类型-小计-列表
     * @author zhanglf
     */
    List<ContractDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 合同级-按产生部门类型-年度-列表
     * @author zhanglf
     */
    Result<ContractDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<Map<String,String>> 合同级-按产生部门类型-年度-列表
     * @author zhanglf
     */
    List<ContractDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 合同级-按产生部门类型-月度-列表
     * @author zhanglf
     */
    Result<ContractDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-合同级-按产生部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<Map<String,String>> 合同级-按产生部门类型-月度-列表
     * @author zhanglf
     */
    List<ContractDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
