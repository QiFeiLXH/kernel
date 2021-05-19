package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.ProjectBonusDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 13:17
 * @Description:
 */
public interface ProjectBonusManager {
    PageInfo<ProjectBonusDO> findProjectBonusProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-全部-小计

    List<ProjectBonusDO> findProjectBonusProAllTotal(Integer startYear, Integer endYear);//项目奖金-项目级-全部-小计

    PageInfo<ProjectBonusDO> findProjectBonusProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-全部-年度

    List<ProjectBonusDO> findProjectBonusProAllYear(Integer startYear, Integer endYear);//项目奖金-项目级-全部-年度

    PageInfo<ProjectBonusDO> findProjectBonusProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-全部-月度

    List<ProjectBonusDO> findProjectBonusProAllMonth(Integer startYear, Integer endYear);//项目奖金-项目级-全部-月度

    PageInfo<ProjectBonusDO> findProjectBonusProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-按产生部门类别-小计

    List<ProjectBonusDO> findProjectBonusProDepTotal(Integer startYear, Integer endYear);//项目奖金-项目级-按产生部门类别-小计

    PageInfo<ProjectBonusDO> findProjectBonusProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-按产生部门类别-年度

    List<ProjectBonusDO> findProjectBonusProDepYear(Integer startYear, Integer endYear);//项目奖金-项目级-按产生部门类别-年度

    PageInfo<ProjectBonusDO> findProjectBonusProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-项目级-按产生部门类别-月度

    List<ProjectBonusDO> findProjectBonusProDepMonth(Integer startYear, Integer endYear);//项目奖金-项目级-按产生部门类别-月度

    PageInfo<ProjectBonusDO> findProjectBonusConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-全部-小计

    List<ProjectBonusDO> findProjectBonusConAllTotal(Integer startYear, Integer endYear);//项目奖金-合同级-全部-小计

    PageInfo<ProjectBonusDO> findProjectBonusConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-全部-年度

    List<ProjectBonusDO> findProjectBonusConAllYear(Integer startYear, Integer endYear);//项目奖金-合同级-全部-年度

    PageInfo<ProjectBonusDO> findProjectBonusConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-全部-月度

    List<ProjectBonusDO> findProjectBonusConAllMonth(Integer startYear, Integer endYear);//项目奖金-合同级-全部-月度

    PageInfo<ProjectBonusDO> findProjectBonusConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-按产生部门类别-小计

    List<ProjectBonusDO> findProjectBonusConDepTotal(Integer startYear, Integer endYear);//项目奖金-合同级-按产生部门类别-小计

    PageInfo<ProjectBonusDO> findProjectBonusConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-按产生部门类别-年度

    List<ProjectBonusDO> findProjectBonusConDepYear(Integer startYear, Integer endYear);//项目奖金-合同级-按产生部门类别-年度

    PageInfo<ProjectBonusDO> findProjectBonusConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//项目奖金-合同级-按产生部门类别-月度

    List<ProjectBonusDO> findProjectBonusConDepMonth(Integer startYear, Integer endYear);//项目奖金-合同级-按产生部门类别-月度
}
