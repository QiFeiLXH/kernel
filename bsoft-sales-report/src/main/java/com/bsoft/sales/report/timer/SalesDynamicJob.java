package com.bsoft.sales.report.timer;

import com.bsoft.sales.report.processor.SalesDynamicProcessor;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution
@Component
public class SalesDynamicJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(SalesDynamicJob.class);

    @Autowired
    private SalesDynamicProcessor salesDynamicProcessor;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        salesDynamicProcessor.process();
        salesDynamicProcessor.doSave();
    }
}
