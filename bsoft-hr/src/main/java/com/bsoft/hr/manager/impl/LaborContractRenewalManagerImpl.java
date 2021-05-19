package com.bsoft.hr.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.manager.KeyGeneratorManager;
import com.bsoft.common.manager.PrimaryKeyManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.LaborContractQueryCnd;
import com.bsoft.hr.dao.primary.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.dao.primary.LaborContractApplyDao;
import com.bsoft.hr.dao.primary.LaborContractApplyViewDao;
import com.bsoft.hr.dao.primary.LaborContractDao;
import com.bsoft.hr.dao.primary.LaborContractQuitViewDao;
import com.bsoft.hr.entity.primary.LaborContractApplyDO;
import com.bsoft.hr.entity.primary.LaborContractApplyViewDO;
import com.bsoft.hr.entity.primary.LaborContractDO;
import com.bsoft.hr.entity.primary.LaborContractQuitViewDO;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.hr.manager.LaborContractRenewalManager;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.entity.primary.GroupRoleDO;
import com.bsoft.workflow.entity.primary.TaskAuditDO;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.GroupRoleManager;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.manager.WorkFlowHisQueryManager;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:27
 * @Version 1.0
 */
@Component
public class LaborContractRenewalManagerImpl implements LaborContractRenewalManager {
    private static final String LABORCONTRACT = "T_LDHT";
    private static final String LABOR_CONTRACT_APPLY = "T_HTSQ";
    private static final String SUBJECT = "部门人员劳动合同续签办理提醒";
    private static final String PROCESS_KEY = "laborContract";

    @Autowired
    private WorkFlowHisQueryManager workFlowHisQueryManager;
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;
    @Autowired
    private LaborContractApplyViewDao laborContractApplyViewDao;
    @Autowired
    private LaborContractApplyDao laborContractApplyDao;
    @Autowired
    private LaborContractDao laborContractDao;
    @Autowired
    private LaborContractViewDao laborContractViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private KeyGeneratorManager keyGeneratorManager;
    @Autowired
    private PersonLaborContractViewDao personLaborContractViewDao;
    @Autowired
    private WorkFlowActionManager workFlowActionManager;
    @Autowired
    private LaborContractQuitViewDao laborContractQuitViewDao;
    @Autowired
    private PrimaryKeyManager primaryKeyManager;
    @Autowired
    private GroupRoleManager groupRoleManager;
    @Autowired
    private LaborContractDetailViewDao laborContractDetailViewDao;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private PersonManager personManager;

    @Override
    public Result<LaborContractApplyViewDO> getLaborContractTaskList(TaskQueryCnd cnd) {
        // 查询任务及劳工合同续签申请信息
        Result<TaskDO> tasks = workFlowQueryManager.getTaskListWithNotify(cnd);
        List<TaskDO> list = tasks.getItems();
        List<String> processInstanceIds = new ArrayList<>();
        List<String> processInstanceIdsWithNotify = new ArrayList<>();
        list.forEach(taskDO -> {
            String processInstanceId = taskDO.getProcessInstanceId();
            if(taskDO.getNotifyFlag().equals(1)){
                processInstanceIdsWithNotify.add(processInstanceId);
            }else{
                processInstanceIds.add(processInstanceId);
            }
        });
        List<LaborContractApplyViewDO> applyViewDOList = laborContractApplyViewDao.findAllByProcessInstanceIdIn(processInstanceIds);
        List<LaborContractApplyViewDO> notifyApplyViewDOList = laborContractApplyViewDao.findAllByProcessInstanceIdIn(processInstanceIdsWithNotify);

        // 关联任务和劳动合同续签申请信息
        List<LaborContractApplyViewDO> resultList = new ArrayList<>();
        for (TaskDO taskDO : list) {
            if (taskDO.getNotifyFlag().equals(0)) {// 普通任务
                List<LaborContractApplyViewDO> collect = applyViewDOList.stream().filter(x -> x.getProcessInstanceId().equals(taskDO.getProcessInstanceId())).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    LaborContractApplyViewDO resultItem = iGenerator.convert(collect.get(0), LaborContractApplyViewDO.class);
                    resultItem.setReadFlag(taskDO.getReadFlag());
                    resultItem.setTaskId(taskDO.getTaskId());
                    resultItem.setTaskDefineKey(taskDO.getTaskDefineKey());
                    resultItem.setNotifyFlag(taskDO.getNotifyFlag());
                    resultList.add(resultItem);
                }
            } else if (taskDO.getNotifyFlag().equals(1)) { // 知会任务
                List<LaborContractApplyViewDO> collect = notifyApplyViewDOList.stream().filter(x -> x.getProcessInstanceId().equals(taskDO.getProcessInstanceId())).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    LaborContractApplyViewDO resultItem = iGenerator.convert(collect.get(0), LaborContractApplyViewDO.class);
                    resultItem.setReadFlag(taskDO.getReadFlag());
                    resultItem.setTaskId(taskDO.getTaskId());
                    resultItem.setTaskDefineKey(taskDO.getTaskDefineKey());
                    resultItem.setNotifyFlag(taskDO.getNotifyFlag());
                    resultList.add(resultItem);
                }
            }
        };

        //处理分页
        Result<LaborContractApplyViewDO> result = new Result<>();
        result.setPageNumber(tasks.getPageNumber());
        result.setPageSize(tasks.getPageSize());
        result.setTotalCount(tasks.getTotalCount());
        result.setTotalPages(tasks.getTotalPages());
        result.setItems(resultList);
        return result;
    }

    @Override
    public Result<LaborContractApplyViewDO> getLaborContractTaskList(Integer flag, TaskQueryCnd cnd) {
        Result<TaskDO> tasks;
        if(flag.equals(0)){//普通待办任务
            tasks = workFlowQueryManager.getTaskList(cnd);
        }else{//知会任务
            tasks = workFlowQueryManager.getNotifyTaskList(cnd);
        }
        List<TaskDO> list = tasks.getItems();
        List<String> processInstanceIds = new ArrayList<>();
        list.forEach(taskDO -> {
            String processInstanceId = taskDO.getProcessInstanceId();
            processInstanceIds.add(processInstanceId);
        });
        List<LaborContractApplyViewDO> applyViewDOList = laborContractApplyViewDao.findAllByProcessInstanceIdIn(processInstanceIds);
        // 关联任务和劳动合同续签申请信息
        List<LaborContractApplyViewDO> resultList = new ArrayList<>();
        for (TaskDO taskDO : list) {
            List<LaborContractApplyViewDO> collect = applyViewDOList.stream().filter(x -> x.getProcessInstanceId().equals(taskDO.getProcessInstanceId())).collect(Collectors.toList());
            if (!collect.isEmpty()) {
                LaborContractApplyViewDO resultItem = iGenerator.convert(collect.get(0), LaborContractApplyViewDO.class);
                resultItem.setReadFlag(taskDO.getReadFlag());
                resultItem.setTaskId(taskDO.getTaskId());
                resultItem.setTaskDefineKey(taskDO.getTaskDefineKey());
                resultItem.setNotifyFlag(taskDO.getNotifyFlag());
                resultList.add(resultItem);
            }
        };

        //处理分页
        Result<LaborContractApplyViewDO> result = new Result<>();
        result.setPageNumber(tasks.getPageNumber());
        result.setPageSize(tasks.getPageSize());
        result.setTotalCount(tasks.getTotalCount());
        result.setTotalPages(tasks.getTotalPages());
        result.setItems(resultList);
        return result;
    }

    @Override
    public Result<LaborContractApplyViewDO> getLaborContractHistoricTaskList(TaskQueryCnd cnd) {
        List<TaskDO> taskList = workFlowHisQueryManager.getFinishedTaskList(cnd);
        List<String> processInstanceIds = taskList.stream().map(TaskDO::getProcessInstanceId).collect(Collectors.toList());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize());
        Page<LaborContractApplyViewDO> page = laborContractApplyViewDao.findAll(new Specification<LaborContractApplyViewDO>() {
            @Override
            public Predicate toPredicate(Root<LaborContractApplyViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (processInstanceIds != null && processInstanceIds.size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("processInstanceId")).value(processInstanceIds));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, LaborContractApplyViewDO.class);
    }

    @Override
    @Transactional
    public void deptAudit(String personId, LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO) {
        HashMap<String, Object> map = new HashMap<>();
        Date now = serverDateManager.getServerDateTime();
        LaborContractApplyDO saveDO = laborContractApplyDao.findById(laborContractApplyDO.getId()).get();
        if(laborContractApplyDO.getDeptAudit() != 1 && laborContractApplyDO.getDeptAudit() != 2) {//默认同意
            laborContractApplyDO.setDeptAudit(1);
        }
        saveDO.setDeptAudit(laborContractApplyDO.getDeptAudit());//部门审核标志 1.同意 2.不同意
        saveDO.setDeptAuditor(personId);//部门审核人
        saveDO.setDeptAuditDate(now);//部门审核时间
        saveDO.setDeptOpinion(laborContractApplyDO.getDeptOpinion());//部门审核意见
        saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//续签年限
        saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//续签劳动合同开始日期
        saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//续签劳动合同结束日期
        if(laborContractApplyDO.getDeptAudit().equals(1)){
            saveDO.setRenewalFlag(1);//续签
            map.put("agreeFlag",true);
        }else{
            map.put("agreeFlag",false);
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "审核");
        map.put("system", taskAuditDO.getSystem());
        map.put("userId", personId);
        workFlowActionManager.complete(taskId,map);
    }

    @Transactional
    @Override
    public void areaAudit(String personId,LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO) {
        HashMap<String, Object> map = new HashMap<>();
        LaborContractApplyDO saveDO = laborContractApplyDao.findById(laborContractApplyDO.getId()).get();
        Date now = serverDateManager.getServerDateTime();
        saveDO.setAreaAuditDate(now);//大区审核时间
        saveDO.setAreaAudit(1);//大区审核
        saveDO.setAreaAuditor(personId);//大区审核人
        saveDO.setRemark(laborContractApplyDO.getRemark());//备注
        saveDO.setDealPerson(personId);//经办人
        saveDO.setDealDate(now);//经办人办理日期
        if(laborContractApplyDO.getDeptAudit().equals(1)){ //部门负责人同意续签
            saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//续签年限
            saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//续签劳动合同开始日期
            saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//续签劳动合同结束日期
            saveDO.setSignUnit(laborContractApplyDO.getSignUnit());//签订单位
            LaborContractDO laborContractDO = initLaborContractDO(personId,saveDO,now);
            laborContractDao.save(laborContractDO);
        } else {//部门负责人不同意
            saveDO.setQuitApplyId(laborContractApplyDO.getQuitApplyId());//离职单id
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "审核");
        map.put("system", taskAuditDO.getSystem());
        map.put("userId", personId);
        workFlowActionManager.complete(taskId,map);
    }

    @Override
    @Transactional
    public void hrAudit(Integer flag, String personId, LaborContractApplyDO laborContractApplyDO, TaskAuditDO taskAuditDO) {
        HashMap<String, Object> map = new HashMap<>();
        LaborContractApplyDO saveDO = laborContractApplyDao.findById(laborContractApplyDO.getId()).get();
        Date now = serverDateManager.getServerDateTime();
        saveDO.setHrAudit(1);
        saveDO.setHrAuditDate(now);//人事审核时间
        saveDO.setHrAuditor(personId);//人事审核人
        saveDO.setHrOpinion(laborContractApplyDO.getHrOpinion());//人事审核意见
        saveDO.setStatus(2);//审核结束
        if(flag.equals(2)){
            //flag=1为有大区行政总监 人事专员只需人事审核
            //flag=2为无大区行政总监 人事专员需处理与大区行政总监相同业务
            saveDO.setAreaAuditDate(now);//大区审核时间
            saveDO.setAreaAudit(1);//大区审核
            saveDO.setAreaAuditor(personId);//大区审核人
            saveDO.setRemark(laborContractApplyDO.getRemark());//备注
            saveDO.setDealPerson(personId);//经办人
            saveDO.setDealDate(now);//经办人办理日期
            if(laborContractApplyDO.getDeptAudit().equals(1)) { //部门负责人同意续签
                saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//续签年限
                saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//续签劳动合同开始日期
                saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//续签劳动合同结束日期
                saveDO.setSignUnit(laborContractApplyDO.getSignUnit());//签订单位
                LaborContractDO laborContractDO = initLaborContractDO(personId,saveDO,now);
                laborContractDao.save(laborContractDO);
            } else{
                saveDO.setQuitApplyId(laborContractApplyDO.getQuitApplyId());//离职单id
            }
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "审核");
        map.put("system", taskAuditDO.getSystem());
        map.put("userId", personId);
        workFlowActionManager.complete(taskId,map);
    }

    @Override
    public List<PersonLaborContractViewDO> getRenewalPersonList() {

        // 查找劳动合同即将到期的在职人员
        Date now = serverDateManager.getServerDateTime();
        Date startDate = getFirstTimeOfMonth(now);
        Date endDate = getLastTimeAfterThreeMonth(now);
        List<PersonLaborContractViewDO> personList = personLaborContractViewDao.findAll(new Specification<PersonLaborContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonLaborContractViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("endDate"), startDate, endDate));
                predicates.add(criteriaBuilder.equal(root.get("flag"), "0"));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });

        // 在合同即将到期的人员中查找已发起流程的人员并剔除（防止重复发起）
        List<PersonLaborContractViewDO> result = new ArrayList<>();
        for (PersonLaborContractViewDO item : personList) {
            List<LaborContractApplyViewDO> applyingPerson = laborContractApplyViewDao.findByPersonIdAndEndDate(item.getPersonId(), item.getEndDate());
            if (applyingPerson == null || applyingPerson.isEmpty()) {
                result.add(item);
            }
        }

        return result;
    }



    @Override
    public Result<LaborContractViewDO> getLaborContractInfoList(LaborContractQueryCnd queryCnd) {
        Sort sort = Sort.by("renewalStartDate").descending();
        PageRequest pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Page<LaborContractViewDO> page = laborContractViewDao.findAll(new Specification<LaborContractViewDO>() {
            @Override
            public Predicate toPredicate(Root<LaborContractViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("flag"), queryCnd.getFlag()));
                if (StringUtils.isNotBlank(queryCnd.getDept())) {
                    predicates.add(criteriaBuilder.equal(root.get("dept"), queryCnd.getDept()));
                }
                if (StringUtils.isNotBlank(queryCnd.getPersonId())) {
                    predicates.add(criteriaBuilder.equal(root.get("personId"), queryCnd.getPersonId()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, LaborContractViewDO.class);
    }

    @Override
    public LaborContractApplyViewDO getLaborContractApply(Integer id) {
        return laborContractApplyViewDao.findById(id).get();
    }

    @Override
    public List<LaborContractQuitViewDO> getLaborContractQuitList(String personId) {
        List<LaborContractQuitViewDO> list = laborContractQuitViewDao.findByPersonId(personId);
        return list;
    }

    @Override
    public LaborContractQuitViewDO getLaborContractApplyQuit(Integer id) {
        return laborContractQuitViewDao.findById(id).get();
    }

    @Override
    public void sendRemindEmailToDept() {
        Date now = serverDateManager.getServerDate();
        List<LaborContractApplyViewDO> list = laborContractApplyViewDao.findRemindDeptAudit();
        for(LaborContractApplyViewDO apply : list){
            if(apply.getDeptManagerEmail() != null && apply.getDeptManagerEmail() != ""){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject(SUBJECT);//设置主题
                List<String> to = new ArrayList<>();
                to.add(apply.getDeptManagerEmail());//收件人  部门负责人
                emailSenderBean.setTo(to);//设置收件人
                List<String> cc = new ArrayList<>();
                cc.add(apply.getAreaManagerEmail());
                String hrStr = apply.getHr();
                String[] hrs = hrStr.split(",");
                for(String hr : hrs){
                    PersonDO person = personManager.getPerson(hr);
                    cc.add(person.getEmail());
                }
                emailSenderBean.setCc(cc);//设置抄送人
                String context = "<div style=\"font-size: 15px; line-height: 22px;\">" +
                        apply.getDeptManager() + ":<br/>" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！<br/>" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司员工<span style=\"font-weight:bold;\">" + apply.getPersonName() + "</span>的合同即将在<span style=\"font-weight:bold;\">" + DateFormatUtils.format(apply.getEndDate(),"yyyy年MM月dd日") + "</span>到期，请在&nbsp;门户平台&nbsp;或&nbsp;慧康办公APP&nbsp;上审批。<br/></br></br>" +
                        "<div style=\"text-align: right;\">人力资源部</div>" +
                        "<div style=\"text-align: right;\">"+now+"</div>" +
                        "</div>" +
                        "<hr style=\"border:1px double #e8e8e8\"/>" +
                        "此为企业信息门户系统邮件。请勿回复，谢谢！";
                emailSenderBean.setText(context);//邮件正文
                emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
                emailSenderBean.setNeedPassWord(false);//不需要密码发送
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
            }
        }
    }

    @Override
    public void sendRemindEmailToDealPerson() {
        Date now = serverDateManager.getServerDate();
        List<LaborContractApplyViewDO> list = laborContractApplyViewDao.findRemindAreaAudit();
        for(LaborContractApplyViewDO apply : list){
            TaskQueryCnd taskQueryCnd = new TaskQueryCnd();
            taskQueryCnd.setProcessInstanceId(apply.getProcessInstanceId());
            List<TaskDO> taskList = workFlowQueryManager.getTaskList(taskQueryCnd).getItems();
            if(taskList != null && !taskList.isEmpty()){
                TaskDO taskDO = taskList.get(0);
                if(StringUtils.isNotBlank(taskDO.getAssignee())){
                    this.sendToDealPerson(apply, taskDO, now);
                    this.sendToPerson(apply, taskDO, now);
                }
            }
        }
    }

    private void sendToDealPerson(LaborContractApplyViewDO apply, TaskDO taskDO, Date now) {
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        emailSenderBean.setSubject(SUBJECT);//设置主题

        String[] receivePersonIds = taskDO.getAssignee().split(",");
        List<String> to = new ArrayList<>();
        for(String personId : receivePersonIds){
            PersonDO person = personManager.getPerson(personId);
            to.add(person.getEmail());
        }
        emailSenderBean.setTo(to);//设置收件人

        String context = "<div style=\"font-size: 15px; line-height: 22px;\">" +
                taskDO.getAssigneeName() + ":<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司员工<span style=\"font-weight:bold;\">" + apply.getPersonName() + "</span>的合同即将在<span style=\"font-weight:bold;\">" + DateFormatUtils.format(apply.getEndDate(),"yyyy年MM月dd日") + "</span>到期，请在<span style=\"font-weight:bold;\">" + DateFormatUtils.format(getYesterday(apply.getEndDate()),"yyyy年MM月dd日") + "前</span>安排与该员工进行劳动合同续签，并在系统中登记最新的合同信息，进行流程审批。" +
                "<br/></br></br>" +
                "<div style=\"text-align: right\">人力资源部</div>" +
                "<div style=\"text-align: right\">"+now+"</div>" +
                "</div>" +
                "<hr style=\"border:1px double #e8e8e8\"/>" +
                "此为企业信息门户系统邮件。请勿回复，谢谢！";
        emailSenderBean.setText(context);//邮件正文
        emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
        emailSenderBean.setNeedPassWord(false);//不需要密码发送
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }

    private void sendToPerson(LaborContractApplyViewDO apply, TaskDO taskDO, Date now) {
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        emailSenderBean.setSubject(SUBJECT);//设置主题

        List<String> to = new ArrayList<>();
        to.add(personManager.getPerson(apply.getPersonId()).getEmail());
        emailSenderBean.setTo(to);//设置收件人

        String context =
                "<div style=\"font-size: 15px; line-height: 22px;\">" +
                apply.getPersonName()+":<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您好！<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您的劳动合同即将到期，感谢您这些年来为公司发展所做的贡献！同时您在创业的平台上得到了较大的提升。请于<span style=\"font-weight:bold;\">" + DateFormatUtils.format(getYesterday(apply.getEndDate()),"yyyy年MM月dd日") + "前</span>与<span style=\"font-weight:bold;\">" + taskDO.getAssigneeName() + "</span>联系，完成劳动合同续签，希望您在创业的平台上发挥出更大的潜力。谢谢！</br></br>" +
                "此致</br>" +
                "最美好的祝愿！</br></br</br>" +
                "<div style=\"text-align: right\">人力资源部</div>" +
                "<div style=\"text-align: right\">" + now + "</div>" +
                "</div>" +
                "<hr style=\"border:1px double #e8e8e8\"/>" +
                "此为企业信息门户系统邮件。请勿回复，谢谢！" ;
        emailSenderBean.setText(context);//邮件正文
        emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
        emailSenderBean.setNeedPassWord(false);//不需要密码发送
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }

    @Override
    public void startAndCompleteProcess(List<PersonLaborContractViewDO> personList) {
        Integer currentId = primaryKeyManager.increaseWithSize(LABOR_CONTRACT_APPLY, personList.size());// 获取id
        Integer applyIdCurrentVal = workFlowActionManager.getApplyIdCurrentVal(PROCESS_KEY, personList.size());// 获取流程申请id
        Date now = serverDateManager.getServerDateTime();// 获取服务器时间
        List<LaborContractApplyDO> saveList = new ArrayList<>();
        for (PersonLaborContractViewDO item : personList) {
            currentId += 1;// ID自增
            applyIdCurrentVal += 1;//applyId自增

            // 发起续签流程
            HashMap<String, Object> data = new HashMap<>();
            String title = "劳动合同续签" + "(" + item.getPersonName() + ")";
            data.put("tjr", item.getPersonId());
            data.put("applyId", "LCR" + applyIdCurrentVal);
            data.put("agreeFlag", true);
            String processInstanceId = workFlowActionManager.startAndComplete(item.getPersonId(), item.getPersonName(), item.getDept(), title, PROCESS_KEY, currentId, data);

            // 保存劳动合同申请信息
            LaborContractApplyDO applyDO = new LaborContractApplyDO();
            applyDO.setId(currentId);//ID
            applyDO.setPersonId(item.getPersonId());// 工号
            applyDO.setRenewalStartDate(getTomorrow(item.getEndDate()));// 续签开始时间
            applyDO.setRenewalEndDate(getFiveYearsLater(item.getEndDate()));// 续签结束时间
            applyDO.setRenewalYear(5);// 默认续签五年
            applyDO.setTrialFlag(0);// 试用标志
            applyDO.setRegisterDate(now);// 登记时间
            applyDO.setRegisterPerson(item.getPersonId());// 登记人员
            applyDO.setDeptAudit(0);// 部门审核
            applyDO.setAreaAudit(0);//大区审核
            applyDO.setHrAudit(0);// 人事审核
            applyDO.setStatus(1);// 审核状态1审核中2已审核
            applyDO.setPost(item.getPost());//岗位
            applyDO.setDept(item.getDept());// 部门
            applyDO.setInDate(item.getInDate());// 入职时间
            applyDO.setEndDate(item.getEndDate());// 劳动合同到期时间
            applyDO.setEvaluationGrade(item.getEvaluationGrade());// 年度绩效
            applyDO.setSequence(item.getSequence());// 岗位序列
            applyDO.setSpecialRank(item.getSpecialRank());// 评定职级
            applyDO.setRenewalFlag(1);//自动发起默认首续签
            applyDO.setProcessInstanceId(processInstanceId);//流程实例ID
            saveList.add(applyDO);
        }
        laborContractApplyDao.saveAll(saveList);
    }

    @Override
    public List<LaborContractApplyViewDO> getPersonalApplyList(String personId) {
        List<LaborContractDO> laborContractDOList = laborContractDao.findAllByPersonId(personId);
        List<Integer> applyIdList = laborContractDOList.stream().map(LaborContractDO::getApplyId).collect(Collectors.toList());
        return laborContractApplyViewDao.findAllById(applyIdList);
    }

    @Override
    public List<LaborContractDetailViewDO> getLaborContractDetail(String personId) {
        return laborContractDetailViewDao.findByPersonIdOrderByRenewalStartDateDesc(personId);
    }

    @Override
    public void setStatusToStop(String processInstanceId) {
        List<LaborContractApplyDO> findList = laborContractApplyDao.findByProcessInstanceId(processInstanceId);
        if (findList != null && !findList.isEmpty()) {
            LaborContractApplyDO findDO = findList.get(0);
            findDO.setStatus(3);
            laborContractApplyDao.save(findDO);
        }
    }

    private LaborContractDO initLaborContractDO(String personId,LaborContractApplyDO saveDO,Date now ){
        Integer laborContractId = keyGeneratorManager.nextKey(LABORCONTRACT);
        LaborContractDO laborContractDO = new LaborContractDO();
        laborContractDO.setId(laborContractId);
        laborContractDO.setRenewalStartDate(saveDO.getRenewalStartDate());//续签劳动合同开始日期
        laborContractDO.setRenewalEndDate(saveDO.getRenewalEndDate());//续签劳动合同结束日期
        laborContractDO.setDealPerson(personId);//经办人
        laborContractDO.setRegistrant(personId);//登记人
        laborContractDO.setRegisterDate(now);//登记时间
        laborContractDO.setRenewalFlag(1);//续签
        laborContractDO.setPersonId(saveDO.getPersonId());//工号
        laborContractDO.setRemark(saveDO.getRemark());//备注
        laborContractDO.setSignUnit(saveDO.getSignUnit());//签订单位 社保缴纳地
        laborContractDO.setApplyId(saveDO.getId());//关联合同申请id、
        return laborContractDO;
    }

    /**
     * 获取本月的第一天
     * @return
     */
    private Date getFirstTimeOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private Date getLastTimeAfterThreeMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 4);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    private Date getTomorrow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    private Date getYesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    private Date getFiveYearsLater(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 5);
        return calendar.getTime();
    }
}
