package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.manager.ReimbursementCostManager;
import com.bsoft.project.report.repository.primary.ReimbursementCostRepository;
import com.bsoft.project.report.repository.primary.RowsToColsProcedureRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 11:25
 * @Description:
 */
@Component
public class ReimbursementCostManagerImpl implements ReimbursementCostManager {
    private static final Logger logger = LoggerFactory.getLogger(ReimbursementCostManagerImpl.class);

    @Autowired
    private ReimbursementCostRepository reimbursementCostRepository;
    @Autowired
    private RowsToColsProcedureRepository rowsToColsProcedureRepository;

    @Override
    public PageInfo<Map<String,String>> findReimburseProAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = "";
        String as_groupByParam = "";
        String as_viewName = " ker_report_RPA_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);


        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllTotal();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProAllTotal(Integer startYear, Integer endYear) {
        String as_params = "";
        String as_groupByParam = "";
        String as_viewName = " ker_report_RPA_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllTotal();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseProAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.costYear ";
        String as_groupByParam = ",a.costYear";
        String as_viewName = " ker_report_RPA_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllYear();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProAllYear(Integer startYear, Integer endYear) {
        String as_params = ",a.costYear ";
        String as_groupByParam = ",a.costYear";
        String as_viewName = " ker_report_RPA_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllYear();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseProAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();

        String as_params = ",a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RPA_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllMonth();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);

        long times = timeConsumer.end();
        logger.info("方法名:{}报销费用-项目级-全部-月度获取数据耗时:{}",new Object[]{"findReimburseProAllMonth",times});
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProAllMonth(Integer startYear, Integer endYear) {
        String as_params = ",a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RPA_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProAllMonth();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseProDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.DepTypeText ";
        String as_groupByParam = ",a.depType,a.DepTypeText";
        String as_viewName = " ker_report_RPD_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepTotal();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProDepTotal(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.DepTypeText ";
        String as_groupByParam = ",a.depType,a.DepTypeText";
        String as_viewName = " ker_report_RPD_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepTotal();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseProDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.DepTypeText,a.costYear ";
        String as_groupByParam = ",a.depType,a.DepTypeText,a.costYear";
        String as_viewName = " ker_report_RPD_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepYear();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProDepYear(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.DepTypeText,a.costYear ";
        String as_groupByParam = ",a.depType,a.DepTypeText,a.costYear";
        String as_viewName = " ker_report_RPD_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepYear();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseProDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.DepTypeText,a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.depType,a.DepTypeText,a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RPD_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepMonth();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseProDepMonth(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.DepTypeText,a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.depType,a.DepTypeText,a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RPD_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callProjectLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseProDepMonth();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConAllTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = "";
        String as_groupByParam = "";
        String as_viewName = " ker_report_RCA_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear);
        map.put("as_endYear",endYear);
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllTotal();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConAllTotal(Integer startYear, Integer endYear) {
        String as_params = "";
        String as_groupByParam = "";
        String as_viewName = " ker_report_RCA_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear);
        map.put("as_endYear",endYear);
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllTotal();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConAllYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.costYear ";
        String as_groupByParam = ",a.costYear";
        String as_viewName = " ker_report_RCA_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear);
        map.put("as_endYear",endYear);
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllYear();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConAllYear(Integer startYear, Integer endYear) {
        String as_params = ",a.costYear ";
        String as_groupByParam = ",a.costYear";
        String as_viewName = " ker_report_RCA_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear);
        map.put("as_endYear",endYear);
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllYear();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConAllMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RCA_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllMonth();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConAllMonth(Integer startYear, Integer endYear) {
        String as_params = ",a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RCA_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConAllMonth();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConDepTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.depTypeText ";
        String as_groupByParam = ",a.depType,a.depTypeText";
        String as_viewName = " ker_report_RCD_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepTotal();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConDepTotal(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.depTypeText ";
        String as_groupByParam = ",a.depType,a.depTypeText";
        String as_viewName = " ker_report_RCD_total_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepTotal();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConDepYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.depTypeText,a.costYear ";
        String as_groupByParam = ",a.depType,a.depTypeText,a.costYear";
        String as_viewName = " ker_report_RCD_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepYear();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConDepYear(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.depTypeText,a.costYear ";
        String as_groupByParam = ",a.depType,a.depTypeText,a.costYear";
        String as_viewName = " ker_report_RCD_year_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepYear();
        return reimbursementList;
    }

    @Override
    public PageInfo<Map<String,String>> findReimburseConDepMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        String as_params = ",a.depType,a.depTypeText,a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.depType,a.depTypeText,a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RCD_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        //开始物理分页
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepMonth();
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(reimbursementList);
        return pageInfo;

    }

    @Override
    public List<Map<String, String>> findReimburseConDepMonth(Integer startYear, Integer endYear) {
        String as_params = ",a.depType,a.depTypeText,a.costQuarter,a.costMonth ";
        String as_groupByParam = ",a.depType,a.depTypeText,a.costQuarter,a.costMonth";
        String as_viewName = " ker_report_RCD_month_view ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("as_params",as_params);
        map.put("as_startYear",startYear.toString());
        map.put("as_endYear",endYear.toString());
        map.put("as_groupByParam",as_groupByParam);
        map.put("as_viewName",as_viewName);
        //调用存储过程刷新查询视图
        rowsToColsProcedureRepository.callContractLevelProcedure(map);

        List<Map<String, String>> reimbursementList = reimbursementCostRepository.findReimburseConDepMonth();
        return reimbursementList;
    }

}
