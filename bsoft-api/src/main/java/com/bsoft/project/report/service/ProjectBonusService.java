package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.ProjectBonusDTO;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 13:15
 * @Description: 项目奖金service
 */
public interface ProjectBonusService {
    /**
     *功能描述 获取 项目奖金-项目级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProAllTotal(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProAllYear(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProAllMonth(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProDepTotal(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProDepYear(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusProDepMonth(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-合同级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConAllTotal(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-合同级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConAllYear(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-合同级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConAllMonth(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConDepTotal(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConDepYear(Integer startYear, Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @param pageNo  页码
     * @param pageSize  每页显示条数
     * @return com.bsoft.common.result.Result<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    Result<ProjectBonusDTO> findProjectBonusConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize); /**

     *功能描述 获取 项目奖金-合同级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear  统计年份 结束时间
     * @return List<com.bsoft.project.report.dto.ProjectBonusDTO>
     */
    List<ProjectBonusDTO> findProjectBonusConDepMonth(Integer startYear, Integer endYear);
}
