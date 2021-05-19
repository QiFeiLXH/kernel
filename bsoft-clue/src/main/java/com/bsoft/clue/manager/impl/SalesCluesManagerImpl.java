package com.bsoft.clue.manager.impl;

import com.bsoft.auth.entity.primary.DeptRoleDO;
import com.bsoft.auth.entity.primary.RoleMaintainBaseDO;
import com.bsoft.auth.manager.RoleMaintainManager;
import com.bsoft.clue.condition.SalesCluesTaskQueryCnd;
import com.bsoft.clue.dao.primary.*;
import com.bsoft.clue.entity.primary.*;
import com.bsoft.clue.manager.SalesCluesManager;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.manager.KeyGeneratorManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.common.utils.PinyinUtil;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.entity.primary.ProjectDO;
import com.bsoft.project.manager.ProjectManager;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.WFTaskDTO;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.manager.WorkFlowHisQueryManager;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import com.bsoft.workflow.service.ActionService;
import com.bsoft.workflow.service.QueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class SalesCluesManagerImpl implements SalesCluesManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesCluesManagerImpl.class);

    private static final String SALESCLUES_PROCESS_KEY = "salesClue";
    private static final String CLOSEREMARK = "【超过更新周期未更新，系统自动关闭】";

    @Reference(timeout = 30000,check = false)
    private ActionService actionService;
    @Reference(timeout = 30000,check = false)
    private QueryService queryService;
    @Autowired
    private SalesCluesViewDao salesCluesViewDao;
    @Autowired
    private SalesCluesApprovalDao salesCluesApprovalDao;
    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private KeyGeneratorManager keyGeneratorManager;
    @Autowired
    private SalesCluesDeptDao salesCluesDeptDao;
    @Autowired
    private ClueDao clueDao;
    @Autowired
    private ClueEmailDao clueEmailDao;
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;
    @Autowired
    private WorkFlowHisQueryManager workFlowHisQueryManager;
    @Autowired
    private WorkFlowActionManager workFlowActionManager;
    @Autowired
    private RoleMaintainManager roleMaintainManager;

    @Override
    public void submit(Integer clueId) {
        Map<String, Object> map = new HashMap<>(); //每个不同的业务流程定制化变量
        SalesCluesViewDO salesClue = salesCluesViewDao.findById(clueId).get();
        String trackDept = salesClue.getTrackDeptNo();//跟单部门

        if(!StringUtils.isNotBlank(trackDept)){
            throw new ServiceException("无跟单部门，发起流程失败");
        }else if(!StringUtils.isNotBlank(salesClue.getTrackPersonId())){
            throw new ServiceException("无跟单人员，发起流程失败");
        }else{
            List<DeptRoleDO> deptRoleDO = roleMaintainManager.findDeptRoles(trackDept,21);
            if(deptRoleDO.size() <= 0){
                throw new ServiceException("跟单部门无线索审核人，发起流程失败，请联系销管中心手工立项");
            }
            map.put("tjr",salesClue.getTrackPersonId());//设置线索申请人节点处理人
            map.put("applyId", "SC" + serverDateManager.getServerDateTime().getTime());// 申请ID
            String personId = salesClue.getTrackPersonId();//设置流程发起人
            String personName = salesClue.getTrackPerson();//设置流程发起人
            String title = salesClue.getCustomerName()+"("+salesClue.getProductContent()+")" ;//设置线索标题
            String processInstanceId = workFlowActionManager.startAndComplete(personId,personName,trackDept,title,SALESCLUES_PROCESS_KEY, clueId ,map);
            SalesCluesApprovalDO approvalDO = salesCluesApprovalDao.findById(clueId).get();
            approvalDO.setProcessInstanceId(processInstanceId);
            salesCluesApprovalDao.save(approvalDO); //xs_xmxs回写流程实例Id
            approvalClue(processInstanceId,clueId);
        }

    }

    @Override
    @Transactional
    public void successApply(String personId,String taskId,String opinion,Integer system,Integer clueId,String processInstanceId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("comment",opinion);
        map.put("action","同意");
        map.put("system",system);
        map.put("userId",personId);
        apply(taskId, map);
        approvalClue(processInstanceId,clueId);
//        if(isFinished(processInstanceId)){
//            SalesCluesApprovalDO approvalDO = salesCluesApprovalDao.findById(clueId).get();
//            SalesCluesViewDO salesClue = salesCluesViewDao.findById(clueId).get();
//            if(approvalDO.getApprovalFlag().equals(1)){
//                LOGGER.info("线索编号为"+clueId+"的线索已手工立项，无需重复立项");
//                return;
//            }
//            approvalDO.setApprovalFlag(1);
//            salesCluesApprovalDao.save(approvalDO); //xs_xmxs打上立项标志
//            Date signDate = serverDateManager.getServerDate();
//            Integer projectId = keyGeneratorManager.pubNextKey("t_projectid");
//            ProjectDO projectDO = initProject(salesClue,clueId,projectId,signDate);
//            projectManager.saveProject(projectDO);
//            SalesCluesDeptDO salesCluesDeptDO = initSaleCluesDept(salesClue,clueId,projectId);
//            salesCluesDeptDao.save(salesCluesDeptDO);
//        }
    }

    private SalesCluesDeptDO initSaleCluesDept(SalesCluesViewDO salesClue,Integer clueId,Integer projectId){
        SalesCluesDeptDO salesCluesDeptDO = new SalesCluesDeptDO();
        Integer salesCluesDeptDOId = keyGeneratorManager.nextKey("XS_XSBM");
        salesCluesDeptDO.setId(salesCluesDeptDOId);
        salesCluesDeptDO.setApprovalFlag(1);
        salesCluesDeptDO.setCloseFlag(0);
        salesCluesDeptDO.setClueId(clueId);
        salesCluesDeptDO.setDept(salesClue.getSalesAreaNo());
        salesCluesDeptDO.setProjectId(String.valueOf(projectId));
        salesCluesDeptDO.setTrackPersonId(salesClue.getTrackUserId());//跟踪人员id
        return salesCluesDeptDO;
    }

    private ProjectDO initProject(SalesCluesViewDO salesClue,Integer clueId,Integer projectId,Date signDate){
        ProjectDO projectDO = new ProjectDO();
        projectDO.setProjectId(String.valueOf(projectId));
        String productContent = StringUtils.isNotBlank(salesClue.getProductContent()) ? salesClue.getProductContent() : " ";
        String projectName = salesClue.getCustomerName()+"("+ productContent +")";
        if(projectName.length()>80){
            projectName = projectName.substring(0,79);
        }
        projectDO.setProjectName(projectName);
        projectDO.setCustomerId(salesClue.getCustomerId());
        projectDO.setArea(salesClue.getTrackDeptNo());
        projectDO.setProjectNo(String.valueOf(projectId));
        projectDO.setFlag("3");
        projectDO.setProjectType(40);
        projectDO.setProjectManager(salesClue.getTrackUserId());
        projectDO.setSalesManager(salesClue.getTrackUserId());
        projectDO.setSignDate(signDate);
        String pinyin = PinyinUtil.getFirstSpell(salesClue.getCustomerName()+productContent);
        if(pinyin.length() > 20){
            pinyin = pinyin.substring(0,19);
        }
        projectDO.setPinyin(pinyin);//拼音简码长度最大为20
        projectDO.setClueId(clueId);
        projectDO.setFinshed("0");
        return projectDO;
    }

    @Override
    public void failApply(String personId,String taskId,String opinion,Integer system) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("comment",opinion);
        map.put("action","不同意");
        map.put("system",system);
        map.put("userId",personId);
        actionService.backToLastStep(taskId,map); //不同意退回上一级节点
    }

    @Override
    public void apply(String taskId, Map<String, Object> map) {
        actionService.complete(taskId, map);
    }

    @Override
    public SalesCluesViewDO getByClueId(Integer clueId) {
        SalesCluesViewDO salesCluesViewDO = salesCluesViewDao.findById(clueId).get();
        return salesCluesViewDO;
    }

    @Override
    public Result<SalesCluesTaskDO> getTaskList(SalesCluesTaskQueryCnd data) {
        TaskQueryCnd queryCndDTO = GeneratorUtil.instance().convert(data,TaskQueryCnd.class);
//        Result<TaskDO> result = workFlowQueryManager.getTaskList(queryCndDTO);
        Result<TaskDO> result;
        if(data.getFinished() != null && data.getFinished()){
            result = workFlowHisQueryManager.getFinishedProcess(queryCndDTO);
        }else{
            result = workFlowQueryManager.getTaskList(queryCndDTO);
        }
        Result<SalesCluesTaskDO>  wfResult  = GeneratorUtil.instance().convert(result, SalesCluesTaskDO.class);
        List<SalesCluesTaskDO> list = wfResult.getItems();
        List<Integer> clueIds = getClueIds(list);
        list = resetList(list,clueIds);
        wfResult.setItems(list);
        return  wfResult;
    }

    @Override
    public void sendCluesRemindMessage() {
        LOGGER.info("销售线索未及时更新的邮件提醒（更新周期 到期前 7天 提醒 ）");
        List<ClueEmailDO> clueDOS = new ArrayList<>();
        List<ClueEmailDO> beforeSevenDay = clueEmailDao.findAllByType(1);
        List<ClueEmailDO> beforeOneDay = clueEmailDao.findAllByType(3);
        clueDOS.addAll(beforeOneDay);
        clueDOS.addAll(beforeSevenDay);
        if(clueDOS.size()>0){
            clueDOS.forEach(clueEmailDO -> {
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject("销售线索更新提醒");
                String toEmail = clueEmailDO.getEmail();
                emailSenderBean.addTo(toEmail);
                String context = setClueMailContext(clueEmailDO);
                emailSenderBean.setText(context);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                LOGGER.info("销售线索未及时更新的邮件提醒发送消息队列,线索编号：{}",clueEmailDO.getClueId());
            });
        }
    }

    public String setClueMailContext(ClueEmailDO clueEmailDO){
        Integer days = 0;
        if(clueEmailDO.getType().equals(1)){
            days = 7;
        }
        if(clueEmailDO.getType().equals(3)){
            days = 1;
        }
        String trackDate = DateFormatUtils.format(clueEmailDO.getTrackDate(), "yyyy-MM-dd");
        String context = "&nbsp;&nbsp;您好！<br/>"
                + "<br/>"
                + clueEmailDO.getCustomer() +
                "，自"+trackDate+"日起未更新线索信息，将在"+days+"天后自动关闭。<br/>" +
                "<br/>"+
                "如您要继续跟进此项目，请及时更新（更新方式：公司WEB平台-销售管理-销售线索或者销售日志维护可以直接更新，或者微信关注：公司微门户-更新销售日志，自动更新。<br/>" +
                "只要与本销售线索关联发起售前支持、报价申请、合同评审申请、客户考察申请、投标会签发起等，都可以自动更新）。<br/>" +
                "<br/>"+
                "谢谢您工作配合！";
        return context;
    }

    @Override
    @Transactional
    public void closeClues() {
        LOGGER.info("销售线索超过更新频率要求的时间未更新的，自动关闭立项");
        List<ClueEmailDO> clueEmailDOS = clueEmailDao.findAllByType(2);
        Date now = serverDateManager.getServerDate();
        List<Integer> clueIds = new ArrayList<>();
        List<String> projectIds = new ArrayList<>();
        clueEmailDOS.forEach(clueEmailDO -> {
            clueIds.add(clueEmailDO.getClueId());
            projectIds.add(clueEmailDO.getProjectId());
        });
        List<ClueDO> clueDOS = clueDao.findAllById(clueIds);
        clueDOS.forEach(clueDO -> {
            clueDO.setClosed(1);//关闭线索
        });
        List<ProjectDO> projectDOS = projectManager.getProjects(projectIds);
        projectDOS.forEach(projectDO -> {
            projectDO.setFinshed("1");//设置完工标志
            projectDO.setRemark(CLOSEREMARK);//设置完结备注信息
            projectDO.setFinishDate(now);//设置完工时间
        });
        clueDao.saveAll(clueDOS);
        projectManager.closeProjects(projectDOS);
    }

    /**
     * 查询流程是否完结
     * @param processInstanceId
     * @return
     */
    public boolean isFinished(String processInstanceId){
        boolean flag = queryService.isFinished(processInstanceId);
        return flag;
    }

    /**
     * 查询流程是否完结，若完结则自动立项
     */
    public void approvalClue(String processInstanceId,Integer clueId){
        boolean flag = queryService.isFinished(processInstanceId);
        if(flag){
            SalesCluesApprovalDO approvalDO = salesCluesApprovalDao.findById(clueId).get();
            SalesCluesViewDO salesClue = salesCluesViewDao.findById(clueId).get();
            if(approvalDO.getApprovalFlag().equals(1)){
                LOGGER.info("线索编号为"+clueId+"的线索已手工立项，无需重复立项");
                return;
            }
            approvalDO.setApprovalFlag(1);
            salesCluesApprovalDao.save(approvalDO); //xs_xmxs打上立项标志
            Date signDate = serverDateManager.getServerDate();
            Integer projectId = keyGeneratorManager.pubNextKey("t_projectid");
            ProjectDO projectDO = initProject(salesClue,clueId,projectId,signDate);
            projectManager.saveProject(projectDO);
            SalesCluesDeptDO salesCluesDeptDO = initSaleCluesDept(salesClue,clueId,projectId);
            salesCluesDeptDao.save(salesCluesDeptDO);
        }
    }

    /**
     * 获取需要重置信息的线索id
     * @param list
     * @return
     */
    private List<Integer> getClueIds(List<SalesCluesTaskDO> list){
        List<Integer> clueIds  = new ArrayList<>();
        list.forEach(salesCluesTaskDO->{
            String businessKey = salesCluesTaskDO.getBusinessKey();
            Integer clueId = Integer.valueOf(businessKey.split(":")[1]);
            clueIds.add(clueId);
        });
        return clueIds;
    }

    /**
     * 重置流程待办信息 加上线索信息
     * @param list
     * @param clueIds
     * @return
     */
    private List<SalesCluesTaskDO> resetList(List<SalesCluesTaskDO> list,List<Integer> clueIds){
        List<SalesCluesViewDO> cluesViewDOS = salesCluesViewDao.findAllById(clueIds);
        list.forEach(salesCluesTaskDO -> {
            String businessKey = salesCluesTaskDO.getBusinessKey();
            Integer clueId = Integer.valueOf(businessKey.split(":")[1]);
            cluesViewDOS.forEach(salesCluesViewDO -> {
                if (clueId.equals(salesCluesViewDO.getId())){
                    salesCluesTaskDO.setFirstAmount(salesCluesViewDO.getFirstAmount());
                    salesCluesTaskDO.setSoftwareAmount(salesCluesViewDO.getSoftwareAmount());
                    salesCluesTaskDO.setSignProbability(salesCluesViewDO.getSignProbability());
                    salesCluesTaskDO.setSignTime(salesCluesViewDO.getSignTime());
                    salesCluesTaskDO.setTrackPerson(salesCluesViewDO.getTrackPerson());
                }

            });
        });
        return list;
    }

}
