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
    private static final String SUBJECT = "??????????????????????????????????????????";
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
        // ?????????????????????????????????????????????
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

        // ?????????????????????????????????????????????
        List<LaborContractApplyViewDO> resultList = new ArrayList<>();
        for (TaskDO taskDO : list) {
            if (taskDO.getNotifyFlag().equals(0)) {// ????????????
                List<LaborContractApplyViewDO> collect = applyViewDOList.stream().filter(x -> x.getProcessInstanceId().equals(taskDO.getProcessInstanceId())).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    LaborContractApplyViewDO resultItem = iGenerator.convert(collect.get(0), LaborContractApplyViewDO.class);
                    resultItem.setReadFlag(taskDO.getReadFlag());
                    resultItem.setTaskId(taskDO.getTaskId());
                    resultItem.setTaskDefineKey(taskDO.getTaskDefineKey());
                    resultItem.setNotifyFlag(taskDO.getNotifyFlag());
                    resultList.add(resultItem);
                }
            } else if (taskDO.getNotifyFlag().equals(1)) { // ????????????
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

        //????????????
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
        if(flag.equals(0)){//??????????????????
            tasks = workFlowQueryManager.getTaskList(cnd);
        }else{//????????????
            tasks = workFlowQueryManager.getNotifyTaskList(cnd);
        }
        List<TaskDO> list = tasks.getItems();
        List<String> processInstanceIds = new ArrayList<>();
        list.forEach(taskDO -> {
            String processInstanceId = taskDO.getProcessInstanceId();
            processInstanceIds.add(processInstanceId);
        });
        List<LaborContractApplyViewDO> applyViewDOList = laborContractApplyViewDao.findAllByProcessInstanceIdIn(processInstanceIds);
        // ?????????????????????????????????????????????
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

        //????????????
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
        if(laborContractApplyDO.getDeptAudit() != 1 && laborContractApplyDO.getDeptAudit() != 2) {//????????????
            laborContractApplyDO.setDeptAudit(1);
        }
        saveDO.setDeptAudit(laborContractApplyDO.getDeptAudit());//?????????????????? 1.?????? 2.?????????
        saveDO.setDeptAuditor(personId);//???????????????
        saveDO.setDeptAuditDate(now);//??????????????????
        saveDO.setDeptOpinion(laborContractApplyDO.getDeptOpinion());//??????????????????
        saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//????????????
        saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//??????????????????????????????
        saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//??????????????????????????????
        if(laborContractApplyDO.getDeptAudit().equals(1)){
            saveDO.setRenewalFlag(1);//??????
            map.put("agreeFlag",true);
        }else{
            map.put("agreeFlag",false);
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "??????");
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
        saveDO.setAreaAuditDate(now);//??????????????????
        saveDO.setAreaAudit(1);//????????????
        saveDO.setAreaAuditor(personId);//???????????????
        saveDO.setRemark(laborContractApplyDO.getRemark());//??????
        saveDO.setDealPerson(personId);//?????????
        saveDO.setDealDate(now);//?????????????????????
        if(laborContractApplyDO.getDeptAudit().equals(1)){ //???????????????????????????
            saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//????????????
            saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//??????????????????????????????
            saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//??????????????????????????????
            saveDO.setSignUnit(laborContractApplyDO.getSignUnit());//????????????
            LaborContractDO laborContractDO = initLaborContractDO(personId,saveDO,now);
            laborContractDao.save(laborContractDO);
        } else {//????????????????????????
            saveDO.setQuitApplyId(laborContractApplyDO.getQuitApplyId());//?????????id
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "??????");
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
        saveDO.setHrAuditDate(now);//??????????????????
        saveDO.setHrAuditor(personId);//???????????????
        saveDO.setHrOpinion(laborContractApplyDO.getHrOpinion());//??????????????????
        saveDO.setStatus(2);//????????????
        if(flag.equals(2)){
            //flag=1???????????????????????? ??????????????????????????????
            //flag=2???????????????????????? ??????????????????????????????????????????????????????
            saveDO.setAreaAuditDate(now);//??????????????????
            saveDO.setAreaAudit(1);//????????????
            saveDO.setAreaAuditor(personId);//???????????????
            saveDO.setRemark(laborContractApplyDO.getRemark());//??????
            saveDO.setDealPerson(personId);//?????????
            saveDO.setDealDate(now);//?????????????????????
            if(laborContractApplyDO.getDeptAudit().equals(1)) { //???????????????????????????
                saveDO.setRenewalYear(laborContractApplyDO.getRenewalYear());//????????????
                saveDO.setRenewalStartDate(laborContractApplyDO.getRenewalStartDate());//??????????????????????????????
                saveDO.setRenewalEndDate(laborContractApplyDO.getRenewalEndDate());//??????????????????????????????
                saveDO.setSignUnit(laborContractApplyDO.getSignUnit());//????????????
                LaborContractDO laborContractDO = initLaborContractDO(personId,saveDO,now);
                laborContractDao.save(laborContractDO);
            } else{
                saveDO.setQuitApplyId(laborContractApplyDO.getQuitApplyId());//?????????id
            }
        }
        laborContractApplyDao.save(saveDO);
        String taskId = taskAuditDO.getTaskId();
        map.put("comment", taskAuditDO.getOpinion());
        map.put("action", "??????");
        map.put("system", taskAuditDO.getSystem());
        map.put("userId", personId);
        workFlowActionManager.complete(taskId,map);
    }

    @Override
    public List<PersonLaborContractViewDO> getRenewalPersonList() {

        // ?????????????????????????????????????????????
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

        // ????????????????????????????????????????????????????????????????????????????????????????????????
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
                emailSenderBean.setSubject(SUBJECT);//????????????
                List<String> to = new ArrayList<>();
                to.add(apply.getDeptManagerEmail());//?????????  ???????????????
                emailSenderBean.setTo(to);//???????????????
                List<String> cc = new ArrayList<>();
                cc.add(apply.getAreaManagerEmail());
                String hrStr = apply.getHr();
                String[] hrs = hrStr.split(",");
                for(String hr : hrs){
                    PersonDO person = personManager.getPerson(hr);
                    cc.add(person.getEmail());
                }
                emailSenderBean.setCc(cc);//???????????????
                String context = "<div style=\"font-size: 15px; line-height: 22px;\">" +
                        apply.getDeptManager() + ":<br/>" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;?????????<br/>" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;????????????<span style=\"font-weight:bold;\">" + apply.getPersonName() + "</span>??????????????????<span style=\"font-weight:bold;\">" + DateFormatUtils.format(apply.getEndDate(),"yyyy???MM???dd???") + "</span>???????????????&nbsp;????????????&nbsp;???&nbsp;????????????APP&nbsp;????????????<br/></br></br>" +
                        "<div style=\"text-align: right;\">???????????????</div>" +
                        "<div style=\"text-align: right;\">"+now+"</div>" +
                        "</div>" +
                        "<hr style=\"border:1px double #e8e8e8\"/>" +
                        "???????????????????????????????????????????????????????????????";
                emailSenderBean.setText(context);//????????????
                emailSenderBean.setHasEnd(false);//??????????????????????????????
                emailSenderBean.setNeedPassWord(false);//?????????????????????
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
        emailSenderBean.setSubject(SUBJECT);//????????????

        String[] receivePersonIds = taskDO.getAssignee().split(",");
        List<String> to = new ArrayList<>();
        for(String personId : receivePersonIds){
            PersonDO person = personManager.getPerson(personId);
            to.add(person.getEmail());
        }
        emailSenderBean.setTo(to);//???????????????

        String context = "<div style=\"font-size: 15px; line-height: 22px;\">" +
                taskDO.getAssigneeName() + ":<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;?????????<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;????????????<span style=\"font-weight:bold;\">" + apply.getPersonName() + "</span>??????????????????<span style=\"font-weight:bold;\">" + DateFormatUtils.format(apply.getEndDate(),"yyyy???MM???dd???") + "</span>???????????????<span style=\"font-weight:bold;\">" + DateFormatUtils.format(getYesterday(apply.getEndDate()),"yyyy???MM???dd???") + "???</span>???????????????????????????????????????????????????????????????????????????????????????????????????????????????" +
                "<br/></br></br>" +
                "<div style=\"text-align: right\">???????????????</div>" +
                "<div style=\"text-align: right\">"+now+"</div>" +
                "</div>" +
                "<hr style=\"border:1px double #e8e8e8\"/>" +
                "???????????????????????????????????????????????????????????????";
        emailSenderBean.setText(context);//????????????
        emailSenderBean.setHasEnd(false);//??????????????????????????????
        emailSenderBean.setNeedPassWord(false);//?????????????????????
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }

    private void sendToPerson(LaborContractApplyViewDO apply, TaskDO taskDO, Date now) {
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        emailSenderBean.setSubject(SUBJECT);//????????????

        List<String> to = new ArrayList<>();
        to.add(personManager.getPerson(apply.getPersonId()).getEmail());
        emailSenderBean.setTo(to);//???????????????

        String context =
                "<div style=\"font-size: 15px; line-height: 22px;\">" +
                apply.getPersonName()+":<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;?????????<br/>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????<span style=\"font-weight:bold;\">" + DateFormatUtils.format(getYesterday(apply.getEndDate()),"yyyy???MM???dd???") + "???</span>???<span style=\"font-weight:bold;\">" + taskDO.getAssigneeName() + "</span>??????????????????????????????????????????????????????????????????????????????????????????????????????</br></br>" +
                "??????</br>" +
                "?????????????????????</br></br</br>" +
                "<div style=\"text-align: right\">???????????????</div>" +
                "<div style=\"text-align: right\">" + now + "</div>" +
                "</div>" +
                "<hr style=\"border:1px double #e8e8e8\"/>" +
                "???????????????????????????????????????????????????????????????" ;
        emailSenderBean.setText(context);//????????????
        emailSenderBean.setHasEnd(false);//??????????????????????????????
        emailSenderBean.setNeedPassWord(false);//?????????????????????
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }

    @Override
    public void startAndCompleteProcess(List<PersonLaborContractViewDO> personList) {
        Integer currentId = primaryKeyManager.increaseWithSize(LABOR_CONTRACT_APPLY, personList.size());// ??????id
        Integer applyIdCurrentVal = workFlowActionManager.getApplyIdCurrentVal(PROCESS_KEY, personList.size());// ??????????????????id
        Date now = serverDateManager.getServerDateTime();// ?????????????????????
        List<LaborContractApplyDO> saveList = new ArrayList<>();
        for (PersonLaborContractViewDO item : personList) {
            currentId += 1;// ID??????
            applyIdCurrentVal += 1;//applyId??????

            // ??????????????????
            HashMap<String, Object> data = new HashMap<>();
            String title = "??????????????????" + "(" + item.getPersonName() + ")";
            data.put("tjr", item.getPersonId());
            data.put("applyId", "LCR" + applyIdCurrentVal);
            data.put("agreeFlag", true);
            String processInstanceId = workFlowActionManager.startAndComplete(item.getPersonId(), item.getPersonName(), item.getDept(), title, PROCESS_KEY, currentId, data);

            // ??????????????????????????????
            LaborContractApplyDO applyDO = new LaborContractApplyDO();
            applyDO.setId(currentId);//ID
            applyDO.setPersonId(item.getPersonId());// ??????
            applyDO.setRenewalStartDate(getTomorrow(item.getEndDate()));// ??????????????????
            applyDO.setRenewalEndDate(getFiveYearsLater(item.getEndDate()));// ??????????????????
            applyDO.setRenewalYear(5);// ??????????????????
            applyDO.setTrialFlag(0);// ????????????
            applyDO.setRegisterDate(now);// ????????????
            applyDO.setRegisterPerson(item.getPersonId());// ????????????
            applyDO.setDeptAudit(0);// ????????????
            applyDO.setAreaAudit(0);//????????????
            applyDO.setHrAudit(0);// ????????????
            applyDO.setStatus(1);// ????????????1?????????2?????????
            applyDO.setPost(item.getPost());//??????
            applyDO.setDept(item.getDept());// ??????
            applyDO.setInDate(item.getInDate());// ????????????
            applyDO.setEndDate(item.getEndDate());// ????????????????????????
            applyDO.setEvaluationGrade(item.getEvaluationGrade());// ????????????
            applyDO.setSequence(item.getSequence());// ????????????
            applyDO.setSpecialRank(item.getSpecialRank());// ????????????
            applyDO.setRenewalFlag(1);//???????????????????????????
            applyDO.setProcessInstanceId(processInstanceId);//????????????ID
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
        laborContractDO.setRenewalStartDate(saveDO.getRenewalStartDate());//??????????????????????????????
        laborContractDO.setRenewalEndDate(saveDO.getRenewalEndDate());//??????????????????????????????
        laborContractDO.setDealPerson(personId);//?????????
        laborContractDO.setRegistrant(personId);//?????????
        laborContractDO.setRegisterDate(now);//????????????
        laborContractDO.setRenewalFlag(1);//??????
        laborContractDO.setPersonId(saveDO.getPersonId());//??????
        laborContractDO.setRemark(saveDO.getRemark());//??????
        laborContractDO.setSignUnit(saveDO.getSignUnit());//???????????? ???????????????
        laborContractDO.setApplyId(saveDO.getId());//??????????????????id???
        return laborContractDO;
    }

    /**
     * ????????????????????????
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
