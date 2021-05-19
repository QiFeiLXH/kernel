package com.bsoft.attendance.message;

import com.bsoft.attendance.manager.ProjectLogManager;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:59
 * @Version 1.0
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "updateProjectLog",consumerGroup = "updateProjectLog")
public class ProjectLogAuditChangeMessageProcessor implements RocketMQListener<String> {
    private static final Logger logger = LoggerFactory.getLogger(ProjectLogAuditChangeMessageProcessor.class);
    @Autowired
    private ProjectLogManager projectLogManager;
    @Override
    public void onMessage(String contractno) {
        projectLogManager.changeProjectLogAudit(contractno);
    }
}
