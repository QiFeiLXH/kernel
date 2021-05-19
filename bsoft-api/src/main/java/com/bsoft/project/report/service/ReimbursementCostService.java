package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 13:26
 * @Description:
 */
public interface ReimbursementCostService {
    /**
     *功能描述  获取 报销费用-项目级-全部-小计
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-项目级-全部-小计
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-项目级-全部-年度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-项目级-全部-年度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-项目级-全部-月度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-项目级-全部-月度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-项目级-产生部门类别-小计
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-项目级-产生部门类别-小计
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-项目级-产生部门类别-年度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

     /**
     *功能描述  获取 报销费用-项目级-产生部门类别-年度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-项目级-产生部门类别-月度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-项目级-产生部门类别-月度
     * @author Xuhui Lin
     * @date 2019/12/17
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-全部-小计
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-全部-小计
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-全部-年度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-全部-年度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-全部-月度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-全部-月度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-小计
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-小计
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-年度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-年度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-月度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @param pageNo     页数，
     * @param pageSize    每页数量，
     * @return com.bsoft.common.result.Result<java.util.Map<java.lang.String,java.lang.String>>
     */
    public Result<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述  获取 报销费用-合同级-产生部门类别-月度
     * @author Xuhui Lin
     * @date 2019/12/19
     * @param startYear  开始年份
     * @param endYear    结束年份，
     * @return List<java.util.Map<java.lang.String,java.lang.String>>
     */
    public List<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear);
}
