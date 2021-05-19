package com.bsoft.clue.message;

import com.bsoft.clue.dao.primary.SalesPlanDao;
import com.bsoft.clue.entity.primary.SalesPlanDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.email.manager.EmailSenderManager;
import com.bsoft.email.manager.impl.EmailSenderManagerImpl;
import com.bsoft.exception.ServiceException;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.service.QueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:59
 * @Version 1.0
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "salesPlanStart",consumerGroup = "salesPlanStart")
public class SalesPlanMessageProcessor implements RocketMQListener<SalesPlanDO> {
    private static final Logger logger = LoggerFactory.getLogger(SalesPlanMessageProcessor.class);
    private static final String SALESPLAN_PROCESS_KEY = "salesPlan";
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private WorkFlowActionManager workFlowActionManager;
    @Autowired
    private SalesPlanDao salesPlanDao;
    @Reference(check = false)
    private QueryService queryService;

    @Override
    public void onMessage(SalesPlanDO salesPlanDO) {
        logger.info("开始发起销售计划id{}，线索编号{}的流程",new Object[]{salesPlanDO.getClueId(),salesPlanDO.getClueId()});
        String trackDept = salesPlanDO.getTrackDept();//获取跟单部门
        if (!StringUtils.isNotBlank(trackDept)) {
            throw new ServiceException("无跟单部门，发起流程失败");
        } else if (!StringUtils.isNotBlank(salesPlanDO.getTrackPerson())) {
            throw new ServiceException("无跟单人员，发起流程失败");
        } else {
            Map<String, Object> map = new HashMap<>(); //每个不同的业务流程定制化变量
            map.put("tjr", salesPlanDO.getTrackPerson());//设置线索申请人节点处理人
            map.put("applyId", "SC" + serverDateManager.getServerDateTime().getTime());// 申请ID
            map.put("planDate",salesPlanDO.getPlanDate());//设置计划月份
            String personId = salesPlanDO.getTrackPerson();//设置流程发起人
            String personName = salesPlanDO.getTrackPersonName();//设置流程发起人
            String title = salesPlanDO.getCustomerName() + "(" + salesPlanDO.getContent() + ")";//设置流程标题
            Integer planId = salesPlanDO.getId();
            String processInstanceId = workFlowActionManager.startAndComplete(personId, personName, trackDept, title, SALESPLAN_PROCESS_KEY, planId, map);
            salesPlanDO.setProcessInstanceId(processInstanceId);
            salesPlanDao.save(salesPlanDO);
            setPlanAudit(processInstanceId, planId);
        }
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
}
