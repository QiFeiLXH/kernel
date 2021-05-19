package com.bsoft.clue.timer;

import com.bsoft.clue.manager.SalesCluesManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-08-18 15:12
 * @Version 1.0
 * @Description 销售线索 超过更新周期 定时关闭
 */
@DisallowConcurrentExecution //作业不并发
@Component
public class CluesCloseJob implements Job {
    @Autowired
    private SalesCluesManager salesCluesManager;
    @Override
    public void execute(JobExecutionContext arg0){
        salesCluesManager.closeClues();
    }
}
