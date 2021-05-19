package com.bsoft.clue.timer;

import com.bsoft.clue.manager.SalesCluesManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-08-18 15:12
 * @Version 1.0
 * @Description 销售线索 更新周期到期7天前 定时邮件
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class CluesRemindEmailJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(CluesRemindEmailJob.class);
    @Autowired
    private SalesCluesManager salesCluesManager;

    @Override
    public void execute(JobExecutionContext arg0){
        LOGGER.info("定时器开始");
        salesCluesManager.sendCluesRemindMessage();
    }
}
