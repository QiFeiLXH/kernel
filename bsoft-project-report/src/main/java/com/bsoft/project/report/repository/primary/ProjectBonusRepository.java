package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.ProjectBonusDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.repository
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 17:09
 * @Description: 项目奖金-项目级、合同级
 */
@Repository
@Mapper
public interface ProjectBonusRepository {
    /**
     *功能描述 获取 项目奖金-项目级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProAllTotal(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProAllYear(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProAllMonth(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProDepTotal(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProDepYear(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-项目级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusProDepMonth(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConAllTotal(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConAllYear(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-全部-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConAllMonth(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-小计 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConDepTotal(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-年度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConDepYear(Integer startYear,Integer endYear);

    /**
     *功能描述 获取 项目奖金-合同级-按产生部门类别-月度 列表数据
     * @author Xuhui Lin
     * @date 2019/12/24
     * @param startYear  统计年份 开始时间
     * @param endYear    统计年份 结束时间
     * @return java.util.List<com.bsoft.project.report.entity.ProjectBonusDO>
     */
    List<ProjectBonusDO> findProjectBonusConDepMonth(Integer startYear,Integer endYear);
}
