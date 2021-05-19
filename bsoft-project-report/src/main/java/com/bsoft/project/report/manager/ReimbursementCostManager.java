package com.bsoft.project.report.manager;


import com.bsoft.common.result.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 10:54
 * @Description:
 */

public interface ReimbursementCostManager {
    PageInfo<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-全部-小计

    List<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear);//报销费用-项目级-全部-小计

    PageInfo<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-全部-年度

    List<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear);//报销费用-项目级-全部-年度

    PageInfo<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-全部-月度

    List<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear);//报销费用-项目级-全部-月度

    PageInfo<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-按产生部门类别-小计

    List<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear);//报销费用-项目级-按产生部门类别-小计

    PageInfo<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-按产生部门类别-年度

    List<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear);//报销费用-项目级-按产生部门类别-年度

    PageInfo<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-项目级-按产生部门类别-月度

    List<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear);//报销费用-项目级-按产生部门类别-月度

    PageInfo<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-全部-小计

    List<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear);//报销费用-合同级-全部-小计

    PageInfo<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-全部-年度

    List<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear);//报销费用-合同级-全部-年度

    PageInfo<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-全部-月度

    List<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear);//报销费用-合同级-全部-月度

    PageInfo<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-按产生部门类别-小计

    List<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear);//报销费用-合同级-按产生部门类别-小计

    PageInfo<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-按产生部门类别-年度

    List<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear);//报销费用-合同级-按产生部门类别-年度

    PageInfo<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//报销费用-合同级-按产生部门类别-月度

    List<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear);//报销费用-合同级-按产生部门类别-月度
}
