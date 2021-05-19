package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.ContractAllByMonthDO;
import com.bsoft.project.report.entity.primary.ContractAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ContractDepTypeByMonthDO;
import com.bsoft.project.report.entity.primary.ContractDepTypeByYearDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:38
 * @Version 1.0
 * @Description
 */
public interface ContractLevelManager {

    PageInfo<ContractAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-全部-小计

    List<ContractAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear);//合同级-全部-小计

    Page<ContractAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-全部-年度

    List<ContractAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear);//合同级-全部-年度

    Page<ContractAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-全部-月度

    List<ContractAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);//合同级-全部-月度

    PageInfo<ContractDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-按产生部门类型-小计

    List<ContractDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear);//合同级-按产生部门类型-小计

    Page<ContractDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-按产生部门类型-年度

    List<ContractDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);//合同级-按产生部门类型-年度

    Page<ContractDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//合同级-按产生部门类型-月度

    List<ContractDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);//合同级-按产生部门类型-月度
}
