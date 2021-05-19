package com.bsoft.project.report.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.manager.ReimbursementCostManager;
import com.bsoft.project.report.service.ReimbursementCostService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 13:17
 * @Description:
 */
@Service
public class ReimbursementCostServiceImpl implements ReimbursementCostService {
    private static final Logger logger = LoggerFactory.getLogger(ReimbursementCostServiceImpl.class);

    @Autowired
    private ReimbursementCostManager reimbursementCostManager;

    @Override
    public Result<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProAllTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-全部-小计列表详情耗时:{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProAllTotal(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProAllTotal(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProAllYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-全部-年度列表详情耗时:{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProAllYear(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProAllYear(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProAllMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProAllMonth(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProAllMonth(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProDepTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-按产生部门类别-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProDepTotal(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProDepTotal(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProDepYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-按产生部门类别-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProDepYear(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProDepYear(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseProDepMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-项目级-按产生部门类别-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseProDepMonth(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseProDepMonth(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConAllTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-全部-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConAllTotal(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConAllTotal(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConAllYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-全部-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConAllYear(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConAllYear(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConAllMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-全部-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConAllMonth(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConAllMonth(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConDepTotal(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-按产生部门类别-小计列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConDepTotal(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConDepTotal(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConDepYear(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-按产生部门类别-年度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConDepYear(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConDepYear(startYear,endYear);
    }

    @Override
    public Result<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PageInfo<Map<String,String>> pages = reimbursementCostManager.findReimburseConDepMonth(startYear,endYear,pageNo,pageSize);
        long times = timeConsumer.end();
        logger.info("获取报销费用-合同级-按产生部门类别-月度列表详情耗时:{}, 开始年份：{}，结束年份：{}",new Object[]{times,startYear,endYear});
        return ResultUtils.parseResult(pages);
    }

    @Override
    public List<Map<String, String>> findReimburseConDepMonth(Integer startYear, Integer endYear) {
        return reimbursementCostManager.findReimburseConDepMonth(startYear,endYear);
    }
}
