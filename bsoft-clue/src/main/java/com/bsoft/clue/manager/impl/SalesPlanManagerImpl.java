package com.bsoft.clue.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.clue.condition.SalesPlanQueryCnd;
import com.bsoft.clue.dao.primary.SalesCluesViewDao;
import com.bsoft.clue.dao.primary.SalesPlanDao;
import com.bsoft.clue.dao.primary.SalesPlanDetailViewDao;
import com.bsoft.clue.dao.primary.SalesPlanViewDao;
import com.bsoft.clue.entity.primary.*;
import com.bsoft.clue.manager.SalesCluesManager;
import com.bsoft.clue.manager.SalesPlanManager;
import com.bsoft.clue.repository.primary.SalesPlanRepository;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.customer.entity.primary.CustomerDO;
import com.bsoft.customer.manager.CustomerManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.manager.WorkFlowHisQueryManager;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import com.bsoft.workflow.service.ActionService;
import com.bsoft.workflow.service.QueryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class SalesPlanManagerImpl implements SalesPlanManager {
    private static final String SALESPLAN_PROCESS_KEY = "salesPlan";
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private SalesPlanDao salesPlanDao;
    @Autowired
    private SalesCluesViewDao salesCluesViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private WorkFlowActionManager workFlowActionManager;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private SalesCluesManager salesCluesManager;
    @Autowired
    private SalesPlanRepository salesPlanRepository;
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;
    @Autowired
    private WorkFlowHisQueryManager workFlowHisQueryManager;
    @Autowired
    private SalesPlanViewDao salesPlanViewDao;
    @Reference(check = false)
    private ActionService actionService;
    @Reference(check = false)
    private QueryService queryService;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private SystemDicManager systemDicManager;
    @Autowired
    private CustomerManager customerManager;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private SalesPlanDetailViewDao salesPlanDetailViewDao;


    @Override

    public Result<SalesPlanDO> getSalesPlan(SalesPlanQueryCnd cnd) {
        Sort sort = Sort.by("reportDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<SalesPlanDO> salesPlanDOS = salesPlanDao.findAll(new Specification<SalesPlanDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getEstimateMonth())) {
                    predicates.add(criteriaBuilder.equal(root.get("estimateMonth"), cnd.getEstimateMonth()));
                }
                if (StringUtils.isNotBlank(cnd.getTrackPerson())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPerson"), cnd.getTrackPerson()));
                }
                if (StringUtils.isNotBlank(cnd.getTrackDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackDept"), cnd.getTrackDept()));
                }
                if (cnd.getReportDate() != null) {
                    Date firstDate = cnd.getReportDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("reportDate"), firstDate, lastDate));
                }
                if (cnd.getPlanDate() != null) {
                    Date firstDate = cnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (cnd.getStatus() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), cnd.getStatus()));
                }
                if (cnd.getStatusList() != null && cnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(cnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<SalesPlanDO> result = ResultUtils.parseResult(salesPlanDOS);
        return result;
    }

    public static Date getLastDayOfMonth(Date sDate1) {
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(sDate1);
        cDay1.set(Calendar.DATE, 1);
        cDay1.roll(Calendar.DATE, -1);
        return cDay1.getTime();
    }

    /**
     * 跟单人是本人的销售线索，已立项且未关闭的。计划签约日期在今年或以后的。
     *
     * @param personId
     * @return
     */
    @Override
    public List<SalesCluesViewDO> getClues(String personId) {
        Sort sort = Sort.by("signDate").descending();
        Date firstDay = getYearFirstDay();//获取今年第一天
        Date startDay = getSixMonthsAgo();//获取6个月前时间
        List<SalesCluesViewDO> salesCluesViewDOS = salesCluesViewDao.findAll(new Specification<SalesCluesViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesCluesViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(personId)) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPersonId"), personId));
                }
                predicates.add(criteriaBuilder.equal(root.get("approvalFlag"), 1));//已立项
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("signDate"), startDay));//预计签约日期6个月内
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return salesCluesViewDOS;
    }

    @Override
    public Result<SalesCluesViewDO> getCluesForSearch(SalesPlanQueryCnd queryCnd) {
        Sort sort = Sort.by("signDate").descending();
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Date firstDay = getYearFirstDay();//获取今年第一天
        Date startDay = getSixMonthsAgo();//获取6个月前时间
        Page<SalesCluesViewDO> page = salesCluesViewDao.findAll(new Specification<SalesCluesViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesCluesViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getTrackPerson())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPersonId"), queryCnd.getTrackPerson()));//跟单人
                }
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    predicates.add(criteriaBuilder.like(root.get("customerName"), "%" + queryCnd.getInputContent() + "%"));//客户名称
                }
                predicates.add(criteriaBuilder.equal(root.get("approvalFlag"), 1));//已立项
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("signDate"), startDay));//预计签约日期6个月内
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, SalesCluesViewDO.class);
    }

    @Override
    @Transactional
    public void save(List<SalesPlanDO> list) {
        Date now = serverDateManager.getServerDate();
//        list.forEach(salesPlanDO -> {
//            salesPlanDO.setReportDate(now);//上报日期默认为当前时间
//            Integer clueId = salesPlanDO.getClueId();
//            SalesCluesViewDO salesClue = salesCluesManager.getByClueId(clueId);
//            String trackDept = salesClue.getTrackDeptNo();//获取跟单部门
//            if (!StringUtils.isNotBlank(trackDept)) {
//                throw new ServiceException("无跟单部门，发起流程失败");
//            } else if (!StringUtils.isNotBlank(salesClue.getTrackPersonId())) {
//                throw new ServiceException("无跟单人员，发起流程失败");
//            } else {
//                Map<String, Object> map = new HashMap<>(); //每个不同的业务流程定制化变量
//                map.put("tjr", salesClue.getTrackPersonId());//设置线索申请人节点处理人
//                map.put("applyId", "SC" + serverDateManager.getServerDateTime().getTime());// 申请ID
//                map.put("planDate",salesPlanDO.getPlanDate());//设置计划月份
//                String personId = salesClue.getTrackPersonId();//设置流程发起人
//                String personName = salesClue.getTrackPerson();//设置流程发起人
//                String title = salesClue.getCustomerName() + "(" + salesClue.getProductContent() + ")";//设置线索标题
//                salesPlanDO = initPlan(salesPlanDO, salesClue);
//                salesPlanDO = salesPlanDao.save(salesPlanDO);
//                Integer planId = salesPlanDO.getId();
//                String processInstanceId = workFlowActionManager.startAndComplete(personId, personName, trackDept, title, SALESPLAN_PROCESS_KEY, planId, map);
//                salesPlanDO.setProcessInstanceId(processInstanceId);
//                salesPlanDao.save(salesPlanDO);
//                setPlanAudit(processInstanceId, planId);
//            }
//        });
        list.forEach(salesPlanDO -> {
            salesPlanDO.setReportDate(now);//上报日期默认为当前时间
            Integer clueId = salesPlanDO.getClueId();
            SalesCluesViewDO salesClue = salesCluesManager.getByClueId(clueId);
            String personName = salesClue.getTrackPerson();
            salesPlanDO = initPlan(salesPlanDO, salesClue);//初始化 销售计划 信息
            salesPlanDO = salesPlanDao.save(salesPlanDO);
            salesPlanDO.setTrackPersonName(personName);
            rocketMQTemplate.convertAndSend("salesPlanStart",salesPlanDO);//将流程发起  发送至消息队列
        });
    }

    @Override
    public SalesPlanAmountDO getSalesPlanAmount(SalesPlanQueryCnd cnd) {
        List<SalesPlanDO> salesPlanDOS = salesPlanDao.findAll(new Specification<SalesPlanDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getEstimateMonth())) {
                    predicates.add(criteriaBuilder.equal(root.get("estimateMonth"), cnd.getEstimateMonth()));
                }
                if (StringUtils.isNotBlank(cnd.getTrackPerson())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPerson"), cnd.getTrackPerson()));
                }
                if (StringUtils.isNotBlank(cnd.getTrackDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackDept"), cnd.getTrackDept()));
                }
                if (cnd.getReportDate() != null) {
                    Date firstDate = cnd.getReportDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("reportDate"), firstDate, lastDate));
                }
                if (cnd.getPlanDate() != null) {
                    Date firstDate = cnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (cnd.getStatus() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), cnd.getStatus()));
                }
                if (cnd.getStatusList() != null && cnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(cnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        Double estimateSoftware = 0.0;
        Double estimateNetSales = 0.0;
        Double estimateHardware = 0.0;
        for (SalesPlanDO salesPlanDO : salesPlanDOS) {
            if (salesPlanDO.getEstimateSoftware() != null) {
                estimateSoftware += salesPlanDO.getEstimateSoftware();
            }
            if (salesPlanDO.getEstimateNetSales() != null) {
                estimateNetSales += salesPlanDO.getEstimateNetSales();
            }
            if (salesPlanDO.getEstimateHardware() != null) {
                estimateHardware += salesPlanDO.getEstimateHardware();
            }
        }
        SalesPlanAmountDO salesPlanAmountDO = new SalesPlanAmountDO();
        salesPlanAmountDO.setEstimateHardware(estimateHardware);
        salesPlanAmountDO.setEstimateSoftware(estimateSoftware);
        salesPlanAmountDO.setEstimateNetSales(estimateNetSales);
        return salesPlanAmountDO;
    }

    @Override
    public SalesPlanAmountDO getSalesPlanAmountWithAudit(TaskQueryCnd cnd) {
        List<TaskDO> list;
        if(cnd.getFinished() != null && cnd.getFinished()){
            cnd.setPageNo(null);
            cnd.setPageSize(null);
            list = workFlowHisQueryManager.getFinishedTask(cnd).getItems();
        }else{
            list = workFlowQueryManager.getTaskListWithoutPage(cnd);
        }
        List<String> processInstanceIds = new ArrayList<>();
        list.forEach(taskDO -> {
            String processInstanceId = taskDO.getProcessInstanceId();
            processInstanceIds.add(processInstanceId);
        });
        List<SalesPlanViewDO> salesPlanViewDOS = salesPlanViewDao.findAllByProcessInstanceIdIn(processInstanceIds);
        Double estimateSoftware = 0.0;
        Double estimateNetSales = 0.0;
        Double estimateHardware = 0.0;
        for (SalesPlanViewDO salesPlanDO : salesPlanViewDOS) {
            if (salesPlanDO.getEstimateSoftware() != null) {
                estimateSoftware += salesPlanDO.getEstimateSoftware();
            }
            if (salesPlanDO.getEstimateNetSales() != null) {
                estimateNetSales += salesPlanDO.getEstimateNetSales();
            }
            if (salesPlanDO.getEstimateHardware() != null) {
                estimateHardware += salesPlanDO.getEstimateHardware();
            }
        }
        SalesPlanAmountDO salesPlanAmountDO = new SalesPlanAmountDO();
        salesPlanAmountDO.setEstimateHardware(estimateHardware);
        salesPlanAmountDO.setEstimateSoftware(estimateSoftware);
        salesPlanAmountDO.setEstimateNetSales(estimateNetSales);
        return salesPlanAmountDO;
    }

    @Override
    public List<String> getReportMonthWithYear(String personId, String year) {
        List<String> list = salesPlanRepository.getReportMonthWithYear(personId,year);
        return list;
    }

    @Override
    public List<PersonDO> getTrackPersonsByAuditor(TaskQueryCnd cnd) {
        List<TaskDO> list;
        if(cnd.getFinished() != null && cnd.getFinished()){
            list = workFlowHisQueryManager.getFinishedTask(cnd).getItems();
        }else{
            list = workFlowQueryManager.getTaskListWithoutPage(cnd);
        }

        Set<PersonDO> persons = new HashSet<>();
        list.forEach(taskDO -> {
            addPerson(persons, taskDO);
        });
        return new ArrayList<>(persons);
    }


    public void addPerson(Set<PersonDO> persons, TaskDO taskDO) {
        PersonDO personDO = new PersonDO();
        String trackPerson = taskDO.getApplyUserId();
        String trackPersonName = taskDO.getApplyUserName();
        personDO.setPersonId(trackPerson);
        personDO.setPersonName(trackPersonName);
        persons.add(personDO);
    }

    @Override
    public List<DeptDO> getTrackDeptsByAuditor(TaskQueryCnd cnd) {
        List<TaskDO> list;
        if(cnd.getFinished() != null && cnd.getFinished()){
            list = workFlowHisQueryManager.getFinishedTask(cnd).getItems();
        }else{
            list = workFlowQueryManager.getTaskListWithoutPage(cnd);
        }
        Set<DeptDO> depts = new HashSet<>();
        list.forEach(taskDO -> {
            String deptId = taskDO.getDept();
            if (StringUtils.isNotBlank(deptId)) {
                DeptDO deptDO = deptManager.getDept(deptId);
                depts.add(deptDO);
            }
        });
        return new ArrayList<>(depts);
    }

    @Override
    public Result<SalesPlanViewDO> getSalesPlanAuditList(TaskQueryCnd cnd) {
//        Result<TaskDO> tasks = workFlowQueryManager.getTaskList(cnd);
        Result<TaskDO> tasks;
        if(cnd.getFinished() != null && cnd.getFinished()){
            tasks = workFlowHisQueryManager.getFinishedTask(cnd);
        }else{
            tasks = workFlowQueryManager.getTaskList(cnd);
        }
        List<TaskDO> list = tasks.getItems();
        List<String> processInstanceIds = new ArrayList<>();
        list.forEach(taskDO -> {
            String processInstanceId = taskDO.getProcessInstanceId();
            processInstanceIds.add(processInstanceId);
        });
        List<SalesPlanViewDO> salesPlanViewDOS = salesPlanViewDao.findAllByProcessInstanceIdIn(processInstanceIds);
        salesPlanViewDOS.forEach(salesPlanViewDO -> {
            list.forEach(taskDO -> {
                if (salesPlanViewDO.getProcessInstanceId().equals(taskDO.getProcessInstanceId())) {
                    salesPlanViewDO.setReadFlag(taskDO.getReadFlag());
                    salesPlanViewDO.setTaskId(taskDO.getTaskId());
                }
            });
        });
        Result<SalesPlanViewDO> result = new Result<>();
        result.setPageNumber(tasks.getPageNumber());
        result.setPageSize(tasks.getPageSize());
        result.setTotalCount(tasks.getTotalCount());
        result.setTotalPages(tasks.getTotalPages());
        result.setItems(salesPlanViewDOS);
        return result;
    }

    @Override
    public void successApply(String personId, String taskId, String opinion, Integer system, Integer id, String processInstanceId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("comment", opinion);
        map.put("action", "同意");
        map.put("system", system);
        map.put("userId", personId);
        apply(taskId, map);
        setPlanAudit(processInstanceId, id);
    }

    @Override
    public void failApply(String personId, String taskId, String opinion, Integer system) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("comment", opinion);
        map.put("action", "不同意");
        map.put("system", system);
        map.put("userId", personId);
        actionService.backToLastStep(taskId, map); //不同意退回上一级节点
    }

    @Override
    public void apply(String taskId, Map<String, Object> map) {
        actionService.complete(taskId, map);
    }

    @Override
    public List<SalesPlanViewDO> getSalesPlanReportViewList(SalesPlanQueryCnd queryCnd) {
        Sort sort = Sort.by("status").and(Sort.by("reportDate").descending()).and(Sort.by("id").descending());
        List<SalesPlanViewDO> list = salesPlanViewDao.findAll(new Specification<SalesPlanViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getTrackPerson())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPerson"), queryCnd.getTrackPerson()));
                }
                if (StringUtils.isNotBlank(queryCnd.getTrackDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackDept"), queryCnd.getTrackDept()));
                }
                if (queryCnd.getPlanDate() != null) {
                    Date firstDate = queryCnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (queryCnd.getStatusList() != null && queryCnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(queryCnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return list;
    }

    @Override
    public Result<SalesPlanViewDO> listSalesPlanReportView(SalesPlanQueryCnd queryCnd) {
        Sort sort = Sort.by("status").and(Sort.by("reportDate").descending()).and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Page<SalesPlanViewDO> page = salesPlanViewDao.findAll(new Specification<SalesPlanViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getTrackPerson())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackPerson"), queryCnd.getTrackPerson()));
                }
                if (StringUtils.isNotBlank(queryCnd.getTrackDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("trackDept"), queryCnd.getTrackDept()));
                }
                if (queryCnd.getPlanDate() != null) {
                    Date firstDate = queryCnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (queryCnd.getStatusList() != null && queryCnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(queryCnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<SalesPlanViewDO> result = ResultUtils.parseResult(page);
        return result;
    }

    @Override
    public List<SalesPlanDO> listTrackPersons(SalesPlanQueryCnd queryCnd) {
        List<SalesPlanViewDO> list = salesPlanViewDao.findAll(new Specification<SalesPlanViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (queryCnd.getPlanDate() != null) {
                    Date firstDate = queryCnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (queryCnd.getStatusList() != null && queryCnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(queryCnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<SalesPlanDO> salesPlanDOList = list.stream()
                // 转换对象
                .map(item -> {
                    SalesPlanDO salesPlanDO = new SalesPlanDO();
                    salesPlanDO.setTrackPerson(item.getTrackPerson());
                    salesPlanDO.setTrackPersonName(item.getTrackPersonName());
                    return salesPlanDO;
                })
                // 根据id去重
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SalesPlanDO :: getTrackPerson))), ArrayList::new));
        return salesPlanDOList;
    }

    @Override
    public List<SalesPlanDO> listTrackDepts(SalesPlanQueryCnd queryCnd) {
        List<SalesPlanViewDO> list = salesPlanViewDao.findAll(new Specification<SalesPlanViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPlanViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (queryCnd.getPlanDate() != null) {
                    Date firstDate = queryCnd.getPlanDate();
                    Date lastDate = getLastDayOfMonth(firstDate);
                    predicates.add(criteriaBuilder.between(root.get("planDate"), firstDate, lastDate));
                }
                if (queryCnd.getStatusList() != null && queryCnd.getStatusList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("status")).value(queryCnd.getStatusList()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<SalesPlanDO> salesPlanDOList = list.stream()
                // 转换对象
                .map(item -> {
                    SalesPlanDO salesPlanDO = new SalesPlanDO();
                    salesPlanDO.setTrackDept(item.getTrackDept());
                    salesPlanDO.setTrackDeptName(item.getTrackDeptName());
                    return salesPlanDO;
                })
                // 根据部门去重
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(SalesPlanDO :: getTrackDept))), ArrayList::new));
        return salesPlanDOList;
    }


    @Override
    public void importSalesPlanData(String personId, List<SalesPlanDO> saveDOList, List<SalesPlanDO> errorDOList) {
        salesPlanDao.saveAll(saveDOList);
        this.saveErrorData(personId, errorDOList);
    }

    @Override
    public List<SalesPlanDO> exportErrorData(String personId) {
        StringBuilder keySB = new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append("salesPlan").append(":").append(personId);
        String errorDataString = redisTemplate.opsForValue().get(keySB.toString());
        List<SalesPlanDO> errorData = (List<SalesPlanDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    public void saveSalesPlanReport(SalesPlanDO saveDO) {
        Date now = serverDateManager.getServerDateTime();
        if(saveDO.getId()==null) {
            saveDO.setStatus(2);//默认已审核
            saveDO.setReportDate(now);//默认上报日期为服务器当前时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(saveDO.getSignDate());
            saveDO.setEstimateMonth(calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1));
            salesPlanDao.save(saveDO);
        } else {
            SalesPlanDO findDO = salesPlanDao.findById(saveDO.getId()).get();
            findDO.setCustomer(saveDO.getCustomer());
            findDO.setCustomerName(saveDO.getCustomerName());
            findDO.setPlanDate(saveDO.getPlanDate());
            findDO.setContent(saveDO.getContent());
            findDO.setBusinessBelong(saveDO.getBusinessBelong());
            findDO.setCluesNature(saveDO.getCluesNature());
            findDO.setTrackPerson(saveDO.getTrackPerson());
            findDO.setTrackDept(saveDO.getTrackDept());
            findDO.setTrackDate(saveDO.getTrackDate());
            findDO.setLatestDevelopment(saveDO.getLatestDevelopment());
            findDO.setCluesSource(saveDO.getCluesSource());
            findDO.setStage(saveDO.getStage());
            findDO.setSalesStage(saveDO.getSalesStage());
            findDO.setEstimateSoftware(saveDO.getEstimateSoftware());
            findDO.setEstimateFirstAmount(saveDO.getEstimateFirstAmount());
            findDO.setEstimateHardware(saveDO.getEstimateHardware());
            findDO.setEstimateNetSales(saveDO.getEstimateNetSales());
            findDO.setEstimateSysSoftware(saveDO.getEstimateSysSoftware());
            findDO.setSignDate(saveDO.getSignDate());
            findDO.setSignProbability(saveDO.getSignProbability());
            findDO.setPlanSource(saveDO.getPlanSource());
            findDO.setOpeningDate(saveDO.getOpeningDate());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(saveDO.getSignDate());
            findDO.setEstimateMonth(calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1));
            salesPlanDao.save(findDO);
        }

    }

    @Override
    public SalesPlanViewDO getSalesPlanReport(String processInstanceId) {
        return salesPlanViewDao.findByProcessInstanceId(processInstanceId);
    }

    @Override
    public SalesPlanViewDO getSalesPlanInfo(Integer id) {
        return salesPlanViewDao.findById(id).get();
    }

    @Override
    public SalesPlanDetailViewDO getSalesPlanDetail(Integer id) {
        SalesPlanDetailViewDO salesPlanDetailViewDO = salesPlanDetailViewDao.findById(id).get();
        return salesPlanDetailViewDO;
    }

    @Override
    public void updateSalesPlanWithAudit(SalesPlanDO salesPlanDO) {
        Integer  id = salesPlanDO.getId();
        if(id != null){
            SalesPlanDO updateDO = salesPlanDao.findById(id).get();
            //设置审核时需要修改的参数
            updateDO.setTrackDate(salesPlanDO.getTrackDate());//跟单日期
            updateDO.setLatestDevelopment(salesPlanDO.getLatestDevelopment());//跟单情况
            updateDO.setStage(salesPlanDO.getStage());//项目阶段
            updateDO.setSalesStage(salesPlanDO.getSalesStage());//销售阶段
            updateDO.setEstimateFirstAmount(salesPlanDO.getEstimateFirstAmount());//预计首款
            updateDO.setEstimateSoftware(salesPlanDO.getEstimateSoftware());//预计软件
            updateDO.setEstimateHardware(salesPlanDO.getEstimateHardware());//预计硬件
            updateDO.setEstimateNetSales(salesPlanDO.getEstimateNetSales());//预计净软件
            updateDO.setEstimateSysSoftware(salesPlanDO.getEstimateSysSoftware());//预计系统软件
            updateDO.setSignDate(salesPlanDO.getSignDate());//预计签约日期
            updateDO.setEstimateMonth(salesPlanDO.getEstimateMonth());//预计月份
            updateDO.setSignProbability(salesPlanDO.getSignProbability());//签约概率
            updateDO.setRemarkInfo(salesPlanDO.getRemarkInfo());//切入说明
            salesPlanDao.save(updateDO);
        }
    }

    private SalesPlanDO  initPlan(SalesPlanDO salesPlanDO, SalesCluesViewDO salesClue) {
        salesPlanDO.setTrackPerson(salesClue.getTrackPersonId());//跟单人员
        salesPlanDO.setBusinessBelong(salesClue.getBusinessBelong());//业务归属
        salesPlanDO.setCluesNature(salesClue.getCluesNature());//线索性质
        salesPlanDO.setCluesSource(salesClue.getCluesSource());//线索来源
        salesPlanDO.setContent(salesClue.getProductContent());//产品内容
        salesPlanDO.setCustomer(salesClue.getCustomerId());//客户编码
        salesPlanDO.setCustomerName(salesClue.getCustomerName());//客户名称
//        salesPlanDO.setEstimateHardware(salesClue.getHardwareAmount());//预计硬件额
//        salesPlanDO.setEstimateSoftware(salesClue.getSoftwareAmount());//预计软件额
//        salesPlanDO.setEstimateNetSales(salesClue.getEstimateNetSales());//预计净销售软件额
        salesPlanDO.setPlanSource("销售线索");//计划来源
//        salesPlanDO.setStage(salesClue.getEntryStage());//线索阶段
        salesPlanDO.setStatus(1);//状态 默认审核中
        salesPlanDO.setTrackDept(salesClue.getTrackDeptNo());//跟单部门
        salesPlanDO.setOpeningDate(salesClue.getBiddingDate());//开标时间-投标时间
//        salesPlanDO.setEstimateMonth(salesClue.getSignMonth());//预计签约月份
//        salesPlanDO.setLatestDevelopment(salesClue.getTrackInfo());//最新情况
        return salesPlanDO;
    }

    /**
     * 获取6个月前时间
     * @return
     */
    private Date getSixMonthsAgo(){
        Date dNow = serverDateManager.getServerDate();   //当前时间
        Date dBefore;
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -6);  //设置为前6月
        dBefore = calendar.getTime();   //得到前6月的时间
        return dBefore;
    }

    /**
     * 获取当年第一天
     * @return
     */
    private Date getYearFirstDay() {
        Calendar currCal = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, currCal.get(Calendar.YEAR));
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 查询流程是否完结，若完结则将状态改为已审核
     */
    public void setPlanAudit(String processInstanceId, Integer id) {
        boolean flag = queryService.isFinished(processInstanceId);
        if (flag) {
            SalesPlanDO salesPlanDO = salesPlanDao.findById(id).get();
            salesPlanDO.setStatus(2);//设置为已审核
            salesPlanDao.save(salesPlanDO);
        }
    }

    /**
     * 缓存导入的错误数据
     */
    private void saveErrorData(String personId, List<SalesPlanDO> errorList) {
        StringBuilder keySB = new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append("salesPlan").append(":").append(personId);
        // 先删除redis数据
        redisTemplate.delete(keySB.toString());
        // 再重新缓存数据,并设置30min的过期时间
        redisTemplate.opsForValue().set(keySB.toString(), JSONObject.toJSONString(errorList), 30, TimeUnit.MINUTES);
    }
}
