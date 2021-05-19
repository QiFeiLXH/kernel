package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.dto.ProjectBonusDTO;
import com.bsoft.project.report.entity.primary.ProjectBonusDO;
import com.bsoft.project.report.manager.ProjectBonusManager;
import com.bsoft.project.report.service.ProjectBonusService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-23 13:16
 * @Description:
 */
@Service
public class ProjectBonusServiceImpl implements ProjectBonusService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectBonusServiceImpl.class);
    @Autowired
    private ProjectBonusManager projectBonusManager;
    @Autowired
    private IGenerator generator;

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-小计列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProAllTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-小计(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-年度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProAllYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-年度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-月度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProAllMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProAllMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-全部-月度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-小计列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProDepTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-小计(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-年度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProDepYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-年度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-月度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusProDepMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusProDepMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-项目级-按产生部门类别-月度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-小计列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConAllTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-小计(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-年度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConAllYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-年度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-月度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConAllMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConAllMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-全部-月度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-小计列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConDepTotal(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepTotal(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-小计(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-年度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConDepYear(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepYear(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-年度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }

    @Override
    public Result<ProjectBonusDTO> findProjectBonusConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-月度列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return ResultUtils.parseResult(results, ProjectBonusDTO.class);
    }

    @Override
    public List<ProjectBonusDTO> findProjectBonusConDepMonth(Integer startYear, Integer endYear) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBonusDO> results = projectBonusManager.findProjectBonusConDepMonth(startYear,endYear);
        long times = timeConsumer.end();
        logger.info("获取项目奖金-合同级-按产生部门类别-月度(全部)列表详情耗时:{},startYear:{},endYear:{}",times,startYear,endYear);
        return generator.convert(results, ProjectBonusDTO.class);
    }
}
